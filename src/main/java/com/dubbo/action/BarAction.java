package com.dubbo.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.service.Test;
import org.springframework.stereotype.Component;

/**
 * 测试dubbo注解
 *
 * @Author xuery
 * @Create 2017 06 04 16:11
 */
@Component
public class BarAction {
    @Reference(version = "1.0.0")
    Test test;
    public String testDubboAnnotation(String name){
        test.sayHello("hello,"+name);
        return null;
    }
}
