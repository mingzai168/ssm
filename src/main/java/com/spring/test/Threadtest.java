package com.spring.test;

public class Threadtest {
    public static void main(String[] args) {

        Demo demo = new Demo();
        Demo dem2 = new Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.getOne();
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.gettwo();
            }
        }).start();
    }
}


class Demo {
    public synchronized void getOne() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.getCause();
        }

        System.out.println("one!");
    }

    public synchronized void gettwo() {
        System.out.println("two!");
    }
}