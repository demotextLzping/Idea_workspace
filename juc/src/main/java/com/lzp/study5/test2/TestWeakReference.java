package com.lzp.study5.test2;

import java.lang.ref.WeakReference;

/**
 * @author: LZPing
 * @date: 2023-02-12 15:10
 * @Description
 */

public class TestWeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<Object> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
