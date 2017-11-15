package com.wj.dubdemo.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Desc: 
 * @Author: wangjian
 * @Date: 2017/11/15
 */
public interface DemoService extends Remote {
    /**
     * @Description: 
     * @Author: wangjian
     * @Date: 2017/11/15
     * @Params: 
     */
    String saySomething(String msg) throws RemoteException;

}
