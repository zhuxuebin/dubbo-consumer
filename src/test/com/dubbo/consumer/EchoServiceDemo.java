package com.dubbo.consumer;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.dubbo.service.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class EchoServiceDemo {
    public static void main(String[] args) {
        //这里注意spring配置文件的名字和路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        Test test = (Test) applicationContext.getBean("springservice");
        EchoService echoService = (EchoService)test;
        String status = (String)echoService.$echo("OK"); //回声测试可用性
        System.out.println(status);
        assert(status.equals("OK"));
    }
}
