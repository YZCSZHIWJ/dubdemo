package com.wj.dubdemo.consumer;

import com.wj.dubdemo.service.DemoService;

import java.rmi.Naming;

public class ClientSide {
    public static void main(String[] args) {
        try {
            DemoService demoService = (DemoService) Naming.lookup("rmi://127.0.0.1:6600/demoservice");
            for (int i = 0; i < 10; i++) {
                System.out.println(demoService.saySomething("brad pitt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
