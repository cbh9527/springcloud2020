package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 *
 * @className: PaymentFallBackService
 * @package: com.atguigu.springcloud.service
 * @author: chenbinghuang
 * @date: 2020/8/3 10:15
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----------FeignClient--FallBack-----------paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------FeignClient--FallBack-----------paymentInfo_TimeOut";
    }
}
