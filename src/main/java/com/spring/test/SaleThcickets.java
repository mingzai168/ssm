package com.spring.test;

import org.junit.Test;

public class SaleThcickets {
    public static void main(String[] args) {
        //1
        SaleThcickets thcickets = new SaleThcickets();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.run();
        thread.start();
    }

    public static int number = 100;

    public synchronized void sale() {
        number--;
        if (number > 0) synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "\t" + "卖出一张票，剩余票数：" + number);
        }
    }


    @Test
    public void test() {

    }
}
