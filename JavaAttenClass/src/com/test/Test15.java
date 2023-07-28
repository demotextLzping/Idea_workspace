package com.test;

/**
 * @author: LZPing
 * @date: 2023-02-28 21:22
 * @Description
 */

interface USB {
    void work();

    void stop();
}

class Mouse implements USB {
    @Override
    public void work() {
        System.out.println("我点点点");
    }

    @Override
    public void stop() {
        System.out.println("我不能点了");
    }
}

class UPan implements USB {
    @Override
    public void work() {
        System.out.println("我存存存");
    }

    @Override
    public void stop() {
        System.out.println("我走了");
    }
}

class Test15 {
    public static void main(String[] args) {
        USB usb1 = new Mouse();
        usb1.work();
        usb1.stop();
        USB[] usbs = new USB[2];
        usbs[0] = new UPan();
        usbs[1] = new Mouse();
        for (USB usb : usbs) {
            usb.work();
            usb.stop();
        }
    }
}