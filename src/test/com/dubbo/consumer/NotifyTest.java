package com.dubbo.consumer;

import static org.junit.Assert.*;

import com.dubbo.domain.Person;
import com.dubbo.service.DemoService;
import com.dubbo.service.Notify;
import com.dubbo.service.impl.NotifyImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName NotifyTest
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/17 15:02
 * @Version 1.0
 */
public class NotifyTest {

    public static void main(String[] args) throws Exception{

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        NotifyImpl notify = (NotifyImpl) context.getBean("demoCallback");
        int requestId = 2;
        Person ret = demoService.get(requestId);
        assertEquals(null, ret);
        //for Test：只是用来说明callback正常被调用，业务具体实现自行决定.
        for (int i = 0; i < 10; i++) {
            if (!notify.ret.containsKey(requestId)) {
                Thread.sleep(200);
            } else {
                break;
            }
        }
        assertEquals(requestId, notify.ret.get(requestId).getId());
    }
}
