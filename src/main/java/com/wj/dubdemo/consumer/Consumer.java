package com.wj.dubdemo.consumer;

import com.wj.dubdemo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("DemoService"); // obtain proxy object for remote invocation
        for (int i=0; i<100; i++) {
            String hello = demoService.saySomething("world"); // execute remote invocation
            logger.info(hello);
        }
    }
}
