package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @className: CommonResult
 * @package: entities
 * @author: chenbinghuang
 * @date: 2020/7/8 14:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    // 404 not found
    private Integer code;
    private String message;
    private T       data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}