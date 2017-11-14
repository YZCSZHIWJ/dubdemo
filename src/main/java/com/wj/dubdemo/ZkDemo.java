package com.wj.dubdemo;
import org.apache.zookeeper.*;

import java.io.IOException;

public class ZkDemo {
    // 会话超时时间，设置为与系统默认时间一致
    private static final int SESSION_TIMEOUT=30000;

    // 创建 ZooKeeper 实例
    ZooKeeper zk;

    Watcher wh = new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent.toString());
        }
    };

    private void createZKInstance() throws IOException {
        zk = new ZooKeeper("192.168.2.51:2181", SESSION_TIMEOUT, this.wh);
    }

    private void ZKOperations() throws KeeperException, InterruptedException {
        System.out.println("/n1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限：OPEN_ACL_UNSAFE ，节点类型： Persistent");
        zk.create("/zoo2","myData2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println("/n2. 查看是否创建成功： ");
        System.out.println(new String(zk.getData("/zoo2",false,null)));

        System.out.println("/n3. 修改节点数据 ");
        zk.setData("/zoo2", "shenlan211314".getBytes(), -1);

        System.out.println("/n4. 查看是否修改成功： ");
        System.out.println(new String(zk.getData("/zoo2", false, null)));

        System.out.println("/n5. 删除节点 ");
        zk.delete("/zoo2", -1);

        System.out.println("/n6. 查看节点是否被删除： ");
        System.out.println(" 节点状态： ["+zk.exists("/zoo2", false)+"]");
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZkDemo demo = new ZkDemo();
        demo.createZKInstance();
        demo.ZKOperations();
        demo.zk.close();
    }
}
