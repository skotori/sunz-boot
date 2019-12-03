package com.skotori.sunzboot.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志记录注解
 * @author skotori
 * @date 2019-12-02 18:01
 */
@Target(ElementType.METHOD) // 用于描述注解的使用范围
@Retention(RetentionPolicy.RUNTIME) // 表示需要在什么级别保存该注释信息，用于描述注解的生命周期
public @interface Log {

    String name() default "";
    LogType type() default LogType.INSERT_LOG;

}
