package com.dubbo.consumer;

import com.dubbo.service.CallbackListener;
import com.dubbo.service.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class CallbackServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        context.start();

        CallbackService callbackService = (CallbackService) context.getBean("callbackService");

        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener(){
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
    }
}
