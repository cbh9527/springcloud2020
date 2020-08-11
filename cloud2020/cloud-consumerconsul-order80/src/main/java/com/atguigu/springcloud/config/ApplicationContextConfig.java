package com.atguigu.springcloud.config;
/**
 *
 * @className: ApplicationContextConfig
 * @package: com.atguigu.springcloud.config
 * @author: chenbinghuang
 * @date: 2020/7/14 17:43
 */
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}