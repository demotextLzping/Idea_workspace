package com.lzp.test6.test1;

public class TV  extends  Appliance implements Sockets{

    @Override
    public void open() {
        System.out.println("电视机打开了");
    }

    @Override
    public void close() {
        System.out.println("电视机关闭了");
    }
    @Override

    public void tongDian() {
        System.out.println("电视通电了");
    }

    public void lookTv(){
        System.out.println("看电视剧");
    }
}
