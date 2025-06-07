package cn.bugstack.types.anotation;

import java.lang.annotation.*;

/**
 * 自定义注释，用于动态变更配置
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface DCCValue {
    String value() default "";
}