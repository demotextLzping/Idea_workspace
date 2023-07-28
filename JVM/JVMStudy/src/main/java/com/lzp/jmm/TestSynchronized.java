package com.lzp.jmm;

/**
 * @author: LZPing
 * @date: 2023-03-27 15:39
 * @Description
 */

public class TestSynchronized {
    synchronized void m() {
    }

    void n() {
        synchronized (this) {
        }
    }

    public static void main(String[] args) {

    }

}
