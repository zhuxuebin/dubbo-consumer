package com.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.service.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class RpcContextDemo {
    public static void main(String[] args) {
        //这里注意spring配置文件的名字和路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        Test test = (Test) applicationContext.getBean("springservice");

        RpcContext.getContext().setAttachment("index","1");
        test.sayHello("James Zhu");
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
        String serverIp = RpcContext.getContext().getRemoteHost();
        String application = RpcContext.getContext().getUrl().getParameter("application");
    }
}
