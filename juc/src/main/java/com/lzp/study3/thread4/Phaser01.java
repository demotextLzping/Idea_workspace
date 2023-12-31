package com.lzp.study3.thread4;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @author: LZPing
 * @date: 2023-01-15 11:36
 * @Description
 */

public class Phaser01 {
    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();

    static void millSleep(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p_" + i)).start();

        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }

    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人都到齐了 " + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人都吃完了 " + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人都离开了 " + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束，新郎新娘抱抱 " + registeredParties);
                    System.out.println();
                    return false;
                default:
                    return true;
            }
        }
    }

    static class Person implements Runnable {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            millSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            millSleep(r.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            millSleep(r.nextInt(1000));
            System.out.printf("%s 离开!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void hug() {
            if (name.equals("新郎") || name.equals("新娘")) {
                millSleep(r.nextInt(1000));
                System.out.printf("%s 洞房!\n",name);
                phaser.arriveAndAwaitAdvance();
            }else {
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            arrive();

            eat();

            leave();

            hug();

        }
    }

}
