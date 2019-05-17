package com.dubbo.service;

import java.util.concurrent.CompletableFuture;

/**
 * @Description 消费者异步调用
 * @Author xuery
 * @Date 2019/5/17 12:25
 * @Version 1.0
 */
public interface AsyncService {
    CompletableFuture<String> sayHello(String name);

}
