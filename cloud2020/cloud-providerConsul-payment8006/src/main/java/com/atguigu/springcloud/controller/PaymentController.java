package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 *
 * @className: PaymentController
 * @package: com.atguigu.springcloud.controller
 * @author: chenbinghuang
 * @date: 2020/7/14 17:25
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private  String serverPort;

    @RequestMapping("/payment/consul")
    public String consul(){
        return serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
