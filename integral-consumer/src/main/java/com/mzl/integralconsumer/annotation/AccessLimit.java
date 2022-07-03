package com.mzl.integralconsumer.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface AccessLimit {

    //限流秒数
    int seconds();
    //限流最大次数
    int maxCount();
//    boolean needLogin() default true;

}
