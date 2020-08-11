package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 *
 * @className: FeignConfig
 * @package: com.atguigu.springcloud.config
 * @author: chenbinghuang
 * @date: 2020/7/28 10:49
 */
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
