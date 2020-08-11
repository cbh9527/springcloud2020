package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: cloud2020
 * @description: 1
 * @author: chenbinghuang
 * @create: 2020-07-26 10:39
 */
public interface LoadBalancer {
    /***
     * 初始化
     * @param serviceInstances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
