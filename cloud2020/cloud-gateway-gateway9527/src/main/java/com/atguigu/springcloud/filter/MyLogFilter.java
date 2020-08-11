package com.atguigu.springcloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 *
 * @className: MyLogFilter
 * @package: com.atguigu.springcloud.filter
 * @author: chenbinghuang
 * @date: 2020/8/5 16:56
 */
@Component
@Slf4j
public class MyLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**********************************come in GlobalFilter"+new Date());
        String uname=exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info("用户名不能为空"+new Date());
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//返回状态
            return  exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);//交给下一个过滤器
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
