package com.wj.dubdemo.provider.impl;

import com.wj.dubdemo.service.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String saySomething(String msg) {
        return "hello, " + msg + " \nservice_id: 3\n";
    }

}
