package com.lzp.test5.test01;

/**
 * @author： LZPing
 * @date： 2022-11-28 14:32
 * @Description
 */

public class test {
    public static void main(String[] args) {
        NewPhone newPhone = new NewPhone();
        newPhone.setBrand("xiaomi");
        newPhone.setPrice("1999");
        System.out.println(newPhone.getBrand()+"手机的价格:"+newPhone.getPrice());
        newPhone.call("李四");
        newPhone.sendMessage();
        newPhone.playGame();
        newPhone.show();

    }
}
