package com.lzp.aop.SpringXML;

public class Advice {
    public void check() throws Exception {
        System.out.println("权限检查");
    }

    public void log() throws Exception {
        System.out.println("日志记录");
    }
}
