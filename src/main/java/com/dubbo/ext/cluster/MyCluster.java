package com.dubbo.ext.cluster;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.Cluster;
import org.apache.dubbo.rpc.cluster.Directory;
import org.apache.dubbo.rpc.cluster.support.FailoverClusterInvoker;

/**
 * @ClassName MyCluster
 * @Description 集群容错扩展， 一般默认为重试2次
 * @Author xuery
 * @Date 2019/5/16 16:33
 * @Version 1.0
 */
@Activate
public class MyCluster implements Cluster {

    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        System.out.println("myCluster..invoke...");
        return new FailoverClusterInvoker(directory);
    }


}
