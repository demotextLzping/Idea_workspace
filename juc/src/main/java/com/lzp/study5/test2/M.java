package com.lzp.study5.test2;

/**
 * @author: LZPing
 * @date: 2023-02-12 14:51
 * @Description
 */

public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
