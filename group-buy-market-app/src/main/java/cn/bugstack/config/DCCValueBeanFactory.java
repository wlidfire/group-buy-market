package cn.bugstack.config;

import cn.bugstack.types.anotation.DCCValue;
import cn.bugstack.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring 配置类和 Bean 生命周期控制；
 * Java 注解 + 反射实现字段动态赋值；
 * Redisson 实现分布式配置存储与实时更新；
 * AOP 代理兼容性处理；
 * 自定义注解设计。
 *
 * DCCValueBeanFactory 实现了 BeanPostProcessor，这样我们就可以拿到 Spring 所有实例化后的 Bean 对象。
 * Spring 是扫描你所工程下所有的 Bean 对象，加载到它的容器里管理。
 */
@Slf4j
@Configuration
public class DCCValueBeanFactory implements BeanPostProcessor {

    // 配置信息的基础路径，用于拼接 Redis 中的键
    private static final String BASE_CONFIG_PATH = "group_buy_market_desc";

    // 存储带有 @DCCValue 注解的 Bean 对象，以便后续更新
    private final Map<String, Object> dccObject = new HashMap<>();

    private final RedissonClient redissonClient;

    public DCCValueBeanFactory(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 创建并初始化 Redisson 的主题，用于监听配置更新
     *
     * @param redissonClient Redisson 客户端
     * @return 初始化后的 RTopic 对象
     *
     * @Bean("dccTopic")：
     *  - 配置类实例化后，spring会调用此方法来创建并注册名为 dccTopic 的 RTopic Bean
     *  - Bean初始化后，执行 postProcessAfterinitialization 方法
     *  - 该方法会对所有带有 @DDCValue 注解的字段进行处理，从 Redis 中读取配置值并反射赋值给对应的字段
     *  - 同时将这些 Bean 存储到 dccObject 中，一遍后续接收到 Redis 消息时能够动态更新字段值
     */
    @Bean("dccTopic")
    public RTopic redisTopicListener(RedissonClient redissonClient) {
        RTopic topic = redissonClient.getTopic("group_buy_market_desc");

        //当其他服务发布配置更新到 Redis 的 group_buy_market_desc 主题时，监听器会被触发
        //更新逻辑通过反射修改存储在 dccObject 中对应 Bean 的字段值，实现配置的热更新
        topic.addListener(String.class, (charSequence, s) -> {
            String[] split = s.split(Constants.SPLIT);
            String attribute = split[0];
            String key = BASE_CONFIG_PATH + attribute;
            String value = split[1];

            RBucket<Object> bucket = redissonClient.getBucket(key);
            boolean exists = bucket.isExists();
            if (!exists) return;

            bucket.set(value);

            Object objectBean = dccObject.get(key);
            if (null == objectBean) return;

            Class<?> objectBeanClass = objectBean.getClass();
            if (AopUtils.isAopProxy(objectBeanClass)) {
                objectBeanClass = AopUtils.getTargetClass(objectBean);
            }

            try {
                Field field = objectBeanClass.getDeclaredField(attribute);
                field.setAccessible(true);
                field.set(objectBean, value);
                field.setAccessible(false);
            } catch (Exception e) {
                throw new RuntimeException("...");
            }
        });

        return topic;
    }

    /**
     * 扫描所有的 Bean 对象，之后检查哪个类的属性加有 @DCCValue 注解，检测到后进行管理操作
     * @param bean 实例化的 Bean 对象
     * @param beanName Bean 的名称
     * @return 处理后的 Bean 对象
     * @throws BeansException 如果处理过程中发生错误
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> targetBeanClass = bean.getClass();
        Object targetBeanObject = bean;

        if (AopUtils.isAopProxy(bean)) {
            targetBeanClass = AopUtils.getTargetClass(bean);
            targetBeanObject = AopProxyUtils.getSingletonTarget(bean);
        }

        Field[] fields = targetBeanClass.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(DCCValue.class)) {
                continue;
            }

            DCCValue dccValue = field.getAnnotation(DCCValue.class);

            String value = dccValue.value();
            if (StringUtils.isBlank(value)) {
                throw new RuntimeException("...");
            }

            String[] split = value.split(":");
            String key = BASE_CONFIG_PATH.concat(split[0]);
            String defaultValue = split.length == 2 ? split[1] : null;

            String setValue = defaultValue;

            try {
                if (StringUtils.isBlank(defaultValue)) {
                    throw new RuntimeException("...");
                }

                RBucket<Object> bucket = redissonClient.getBucket(key);
                boolean exits = bucket.isExists();
                if (!exits) {
                    bucket.set(defaultValue);
                } else {
                    setValue = (String) bucket.get();
                }

                field.setAccessible(true);
                field.set(targetBeanObject, setValue);
                field.setAccessible(false);
            } catch (Exception e) {
                throw new RuntimeException("...");
            }

            dccObject.put(key, targetBeanObject);
        }

        return bean;
    }


}
