package com.mzl.integralconsumer.config;

import com.mzl.integralconsumer.interceptor.SignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName :   WebMvcAutoConfiguration
 * @Description: 拦截器配置类
 * @Author: mzl
 * @CreateDate: 2022/7/3 22:51
 * @Version: 1.0
 */
@Configuration
public class WebMvcAutoConfiguration implements WebMvcConfigurer {

    @Bean
    public SignInterceptor loginIntercepter() {
        return new SignInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercepter())
                .addPathPatterns("/**");
    }

}
