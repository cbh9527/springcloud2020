package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @className: ApplicationContextConfig
 * @package: com.atguigu.springcloud.config
 * @author: chenbinghuang
 * @date: 2020/7/9 10:27
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡能力
    public RestTemplate getRestTemplate()   {
        return new RestTemplate();
    }
}
