package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @className: ConfigClientController
 * @package: com.atguigu.springcloud.controller
 * @author: chenbinghuang
 * @date: 2020/8/7 9:53
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort:"+serverPort+"\t\n\n configInfo: "+configInfo;
    }


}
