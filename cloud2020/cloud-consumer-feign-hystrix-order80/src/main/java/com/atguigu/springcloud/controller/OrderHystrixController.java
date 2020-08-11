package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 *
 * @className: OrderHystrixController
 * @package: com.atguigu.springcloud.controller
 * @author: chenbinghuang
 * @date: 2020/7/30 16:27
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Autowired
   private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    };

    /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
              @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
      })*/
   @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   public String paymentInfo_TimeOut(@PathVariable("id")Integer id)
   {
       int agr=10/0;
       return paymentHystrixService.paymentInfo_TimeOut(id);
   }
    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "我是消费者80 系统繁忙";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
