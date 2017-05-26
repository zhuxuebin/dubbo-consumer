package com.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.domain.Bar;
import com.dubbo.domain.Foo;
import com.dubbo.service.BarService;
import com.dubbo.service.FooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Future;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class AsyncDemo {
    public static void main(String[] args) {
        //这里注意spring配置文件的名字和路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        FooService fooService = (FooService) applicationContext.getBean("fooservice");
        BarService barService = (BarService)applicationContext.getBean("barservice");


        long start = System.currentTimeMillis();
        Foo foo = fooService.findFoo(1);
        //调用后立即返回null
        System.err.println("立即返回的为null:"+foo);

        Future<Foo>  fooFuture = RpcContext.getContext().getFuture();


        barService.findBar(1);
        Future<Bar> barFuture = RpcContext.getContext().getFuture();

        try {
            foo = fooFuture.get();
            Bar bar = barFuture.get();
        }catch(Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0);
    }
}
