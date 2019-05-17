package com.dubbo.consumer;

import com.dubbo.handler.MyInvocationHandler;
import com.dubbo.service.EchoService;
import com.dubbo.service.MyService;
import com.dubbo.service.impl.MyServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class EchoServiceTest {
    public static void main(String[] args) {
        //首先定义一个MyService实例
        MyService myservice = new MyServiceImpl();
        //获取该实例所实现的接口
        Class<?>[] interfaces2 = myservice.getClass().getInterfaces();
        //将EchoService接口添加到Class<?>数组中
        Class<?>[] interfaces = new Class<?>[interfaces2.length+1];
        interfaces[0] = EchoService.class;
        for(int i=0;i<interfaces2.length;i++){
            interfaces[i+1] = interfaces2[i];
        }

        Object obj = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),interfaces,new MyInvocationHandler(myservice));

        //正常调用
        MyService ms = (MyService)obj;
        ms.sayHello();

        //强制转换为EchoService对象并调用方法
        EchoService es = (EchoService)obj;
        Object data = es.$echo("aaaa");
        System.out.println(data);

        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
