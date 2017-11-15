package com.wj.dubdemo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {

    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo-demo-provider.xml"});
        context.start();
    }

    /**
     * @Desc:
     * @Author: wangjian
     * @Date: 2017/11/15
     * @Params:
     */
    public static void main(String[] args) throws IOException {
       Provider provider = new Provider();
       provider.init();
       System.in.read();
    }
}
