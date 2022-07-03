package com.mzl.userintegral.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName :   RedissonConfig
 * @Description: 分布式锁的配置类
 * @Author: mzl
 * @CreateDate: 2022/7/3 21:16
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class RedissonConfig {

    @Value("${redisson.address}")
    private String addressUrl;

    @Value("${redisson.password}")
    private String password;

    @Bean
    public RedissonClient getRedisson() throws Exception{
        RedissonClient redisson = null;
        Config config = new Config();
        config.useSingleServer().setAddress(addressUrl).setPassword(password);
        redisson = Redisson.create(config);

        log.info(redisson.getConfig().toJSON().toString());
        return redisson;
    }


}
