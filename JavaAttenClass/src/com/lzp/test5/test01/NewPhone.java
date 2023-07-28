package com.lzp.test5.test01;

/**
 * @author： LZPing
 * @date： 2022-11-28 14:30
 * @Description
 */

public class NewPhone extends OldPhone {
    public void playGame() {
        System.out.println("玩游戏");
    }

    @Override
    public void show() {
        System.out.println("显示手机号");
        System.out.println("显示归属地");
        System.out.println("显示头像");
    }



}
