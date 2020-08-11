package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @className: MyLb
 * @package: com.atguigu.springcloud.lb
 * @author: chenbinghuang
 * @date: 2020/7/26 10:42
 */
@Component
public class MyLb implements LoadBalancer {
    /**原子类*/
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取下标
     * @return
     */
    public  final int   getAndIncrement(){
        int next;//下一次请求
        int current; //当前请求
        do {
            //得到当前请求数
            current = this.atomicInteger.get();
            next = current>2147483647?0:current+1;
        }while (!atomicInteger.compareAndSet(current,next));
            System.out.println("当前请求数"+next);
            return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
