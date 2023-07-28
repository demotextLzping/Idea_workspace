package com.lzp.aop.proxy3;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CGLIBProxy implements MethodInterceptor {
    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer en = new Enhancer();
        en.setSuperclass(this.targetObject.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        check();
        Object ob = methodProxy.invokeSuper(o, objects);
        log();
        return ob;
    }

    public void check() throws Exception {
        System.out.println("权限检查");
    }

    public void log() throws Exception {
        System.out.println("日志记录");
    }
}
