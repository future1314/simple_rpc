package com.viewscenes.netsupervisor.configurer.rpc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Proxy;

/**
 * Created by MACHENIKE on 2018-12-03.
 */
@Slf4j
public class RpcFactoryBean<T> implements FactoryBean<T> {

    private Class<T> rpcInterface;

    @Autowired
    RpcFactory<T> factory;

    public RpcFactoryBean() {}

    public RpcFactoryBean(Class<T> rpcInterface) {
        this.rpcInterface = rpcInterface;
    }

    public T getObject() throws Exception {
        return getRpc();
    }

    public Class<?> getObjectType() {
        return this.rpcInterface;
    }

    public boolean isSingleton() {
        return true;
    }

    public <T> T getRpc() {
        log.info("rpcInterface.{},getClassLoader.{}",rpcInterface,rpcInterface.getClassLoader());
        return (T) Proxy.newProxyInstance(rpcInterface.getClassLoader(), new Class[] { rpcInterface },factory);
    }
}
