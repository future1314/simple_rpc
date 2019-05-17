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
    @Override
    public T getObject() throws Exception {
        log.info("FactoryBean--------getObject--");
        return getRpc();
    }
    @Override
    public Class<?> getObjectType() {
        log.info("FactoryBean--------getObjectType--： "+rpcInterface);
        return this.rpcInterface;
    }
    @Override
    public boolean isSingleton() {
        log.info("FactoryBean--------isSingleton--");
        return true;
    }

    public <T> T getRpc() {
        log.info("FactoryBean--反射--getRpc-rpcInterface.{},getClassLoader.{}",rpcInterface,rpcInterface.getClassLoader());
        return (T) Proxy.newProxyInstance(rpcInterface.getClassLoader(), new Class[] { rpcInterface },factory);
    }
}
