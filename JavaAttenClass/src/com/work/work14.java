package com.work;

/**
 * @author: LZPing
 * @date: 2022-12-18 17:28
 * @Description
 */
interface USB{
    void work();
    void stop();
}
class Mouse implements USB{

    @Override
    public void work() {
        System.out.println("我点点点");
    }

    @Override
    public void stop() {
        System.out.println("我不能点了");
    }
}
class Upan implements USB{

    @Override
    public void work() {
        System.out.println("我存存存");
    }

    @Override
    public void stop() {
        System.out.println("我走了");
    }
}

public class work14 {
    public static void main(String[] args) {
        USB usb1=new Mouse();
        usb1.work();
        usb1.stop();
        USB[] usbs=new USB[2];
        usbs[0]=new Upan();
        usbs[1]=new Mouse();
        for (USB usb : usbs) {
            usb.work();
            usb.stop();
        }
    }
}
