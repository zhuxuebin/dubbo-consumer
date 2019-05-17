package com.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.action.BarAction;
import com.dubbo.service.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class DubboAnnotationTest {
    public static void main(String[] args) {
        //这里注意spring配置文件的名字和路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        BarAction action = (BarAction) applicationContext.getBean("barAction");
        action.testDubboAnnotation("xuery");
    }
}
