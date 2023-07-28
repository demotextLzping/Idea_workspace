package com.lzp.aop.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        /*
         * 参数一 ClassLoader 类加载器
         * 参数二 Interfaces 接口类型
         * 参数三 InvocationHandler 代理对象
         */
        return Proxy.newProxyInstance(
                this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        check();
        Object invoke = method.invoke(this.targetObject, args);
        log();
        return invoke;
    }

    public void check() throws Exception {
        System.out.println("权限检查");
    }

    public void log() throws Exception {
        System.out.println("日志记录");
    }
}
