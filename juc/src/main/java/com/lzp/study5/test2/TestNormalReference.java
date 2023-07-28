package com.lzp.study5.test2;

import java.io.IOException;

/**
 * @author: LZPing
 * @date: 2023-02-12 14:51
 * @Description
 */

public class TestNormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m=null;
        System.gc();

        //线程堵塞
        System.in.read();
    }

}
