package com.lzp.common;

/**
 * @author: LZPing
 * @date: 2022-12-11 14:19
 * @Description
 */

public class BaseContext {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

}
