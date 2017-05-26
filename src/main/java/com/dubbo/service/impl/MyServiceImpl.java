package com.dubbo.service.impl;

import com.dubbo.service.MyService;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class MyServiceImpl implements MyService {
    @Override
    public void sayHello() {
        System.out.println("MyServiceImpl:hello");
    }
}
