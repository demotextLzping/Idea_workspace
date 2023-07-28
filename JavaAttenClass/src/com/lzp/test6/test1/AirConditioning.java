package com.lzp.test6.test1;

public class AirConditioning extends  Appliance implements Sockets {
    @Override
    public void open() {
        System.out.println("空调打开了");
    }

    @Override
    public void close() {
        System.out.println("空调关闭了");
    }

    @Override
    public void tongDian() {
        System.out.println("空调通电了");
    }

    public void refrigeration(){
        System.out.println("空调制冷了");
    }
}
