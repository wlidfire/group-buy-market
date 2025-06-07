package cn.bugstack.config;

import cn.bugstack.types.anotation.DCCValue;
import cn.bugstack.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class DCCValueBeanFactory implements BeanPostProcessor {

    private static final String BASE_CONFIG_PATH = "group_buy_market_desc";

    private final Map<String, Object> dccObject = new HashMap<>();

    private final RedissonClient redissonClient;

    public DCCValueBeanFactory(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Bean("dccTopic")
    public RTopic redisTopicListener(RedissonClient redissonClient) {
        RTopic topic = redissonClient.getTopic("group_buy_market_desc");

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
