package com.wj.dubdemo.provider;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import com.wj.dubdemo.provider.impl.DemoServiceImpl;
import com.wj.dubdemo.service.DemoService;

public class ServerSide {
    public static void main(String[] args) {
        try {
            DemoService demoService = new DemoServiceImpl();
            LocateRegistry.createRegistry(6600);
            Naming.rebind("rmi://127.0.0.1:6600/demoservice", demoService);
            System.out.println("server side start");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
