package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 *
 * @className: OrderController
 * @package: com.atguigu.springcloud.controller
 * @author: chenbinghuang
 * @date: 2020/7/9 10:21
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Autowired
    private  DiscoveryClient discoveryClient;
    public static  final String ADD_URL ="http://CLOUD-PAYMENT-SERVICE";
    @GetMapping("/consumer/payment/create")
    @ResponseBody
    public ResponseEntity<CommonResult> create(Payment payment){
        return restTemplate.postForEntity(ADD_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    @ResponseBody
    public ResponseEntity<CommonResult> get(@PathVariable(value = "id")Long id){
        return restTemplate.getForEntity(ADD_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/panyment/lb")
    public String getlb(){
        List<ServiceInstance> service=  discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(service != null && service.size()<=0){
            return  null;
        }
        ServiceInstance serviceIns=loadBalancer.instance(service);
        URI uri = serviceIns.getUri();
        return restTemplate.getForObject(uri+"/panyment/lb",String.class);
    }
}
