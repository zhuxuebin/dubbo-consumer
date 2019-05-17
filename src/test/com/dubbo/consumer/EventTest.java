package com.dubbo.consumer;

import com.dubbo.domain.Person;
import com.dubbo.service.DemoService;
import com.dubbo.service.impl.NotifyImpl;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class EventTest {
    public static void main(String[] args) {
        //这里注意spring配置文件的名字和路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        DemoService demoService = (DemoService)applicationContext.getBean("demoService");
        NotifyImpl notify = (NotifyImpl)applicationContext.getBean("demoCallback");
        int requestId = 2;
        Person ret = demoService.get(requestId);
        Assert.assertEquals(null, ret);
        //for Test：只是用来说明callback正常被调用，业务具体实现自行决定.
        for (int i = 0; i < 10; i++) {
            if (!notify.ret.containsKey(requestId)) {
                try {
                    Thread.sleep(200);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
        Assert.assertEquals(requestId, notify.ret.get(requestId).getId());


    }
}
