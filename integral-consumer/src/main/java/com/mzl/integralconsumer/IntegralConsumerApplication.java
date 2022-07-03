package com.mzl.integralconsumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class IntegralConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(IntegralConsumerApplication.class, args);
  }
}
