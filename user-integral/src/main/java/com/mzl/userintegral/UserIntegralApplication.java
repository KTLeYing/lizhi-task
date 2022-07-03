package com.mzl.userintegral;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class UserIntegralApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserIntegralApplication.class, args);
  }
}
