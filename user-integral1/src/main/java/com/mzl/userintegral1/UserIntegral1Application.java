package com.mzl.userintegral1;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class UserIntegral1Application {

  public static void main(String[] args) {
    SpringApplication.run(UserIntegral1Application.class, args);
  }
}
