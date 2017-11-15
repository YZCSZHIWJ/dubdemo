package com.wj.dubdemo.provider.impl;

import com.wj.dubdemo.service.DemoService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DemoServiceImpl extends UnicastRemoteObject implements DemoService {

    public DemoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String saySomething(String msg) throws RemoteException {
        System.out.println(Thread.currentThread().getId() + " : "
                + Thread.currentThread().getName());
        return "hello, " + msg + " \nservice_id: 1\n";
    }

}
