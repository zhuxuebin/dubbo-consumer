package com.dubbo.consumer;

import com.dubbo.service.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName AsyncServiceTest
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/17 12:52
 * @Version 1.0
 */
public class AsyncServiceTest {


    public static void main(String[] args) {
        //这里注意spring配置文件的名字和路径
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-consumer.xml"});
        AsyncService asyncService = (AsyncService) applicationContext.getBean("asyncService");

        RpcContext.getContext().setAttachment("consumer-key1","consumer1");

        //此时会立刻返回null,即future == null
        CompletableFuture<String> future =  asyncService.sayHello("James Zhu");

        //拿到调用的Future引用，当结果返回后，会被通知和设置到此Future, 2.7.0以前不支持CompletableFuture
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();

        //利用CompletableFuture异步获取结果
        helloFuture.whenComplete((v,t)->{
            if(t!= null){
                t.printStackTrace();
            } else {
                System.out.println("response:" + v);
            }
        });

        //先于异步获取的结果，说明异步获取是新开了线程
        System.out.println("executed before response return.");
    }
}
