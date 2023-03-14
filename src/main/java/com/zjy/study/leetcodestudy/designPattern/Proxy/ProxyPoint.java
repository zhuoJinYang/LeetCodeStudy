package com.zjy.study.leetcodestudy.designPattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author zjy
 * @Date 2023/3/14 10:08
 * @Description
 */
public class ProxyPoint implements InvocationHandler {
    private TrainStation trainStation;

    public TrainStation getProxyObject(TrainStation trainStation){
        this.trainStation = trainStation;
        Class<? extends TrainStation> clazz = trainStation.getClass();
        return (TrainStation) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代售火车票收取5%手续费");
        return method.invoke(this.trainStation,args);
    }
}
