package com.lzp.study5.test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @author: LZPing
 * @date: 2023-02-12 12:06
 * @Description 测试使用VarHandle来操作数据
 * 1.普通属性原子操作
 * 2.理解为直接操作二进制码，比反射快
 */

public class TestVarHandle {
    int x = 8;
    private static VarHandle handle;
    static {
        try {
            handle = MethodHandles.lookup().findVarHandle(TestVarHandle.class, "x", int.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestVarHandle t = new TestVarHandle();
        //输出
        System.out.println((int) handle.get(t));
        //设置数据值
        handle.set(t, 9);
        System.out.println(t.x);
        //比较预期值并修改
        handle.compareAndSet(t, 9, 10);
        System.out.println(t.x);
        //得到并增加
        handle.getAndAdd(t, 10);
        System.out.println(t.x);
    }
}
