package com.spring.test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo ad= new AtomicDemo();


        for(int i=0; i <= 10; i++){
            new Thread(ad).start();
        }
    }
}
class AtomicDemo implements Runnable{
    private int serialNumber = 0;
    // 改进: 使用原子变量
    // private AtomicInteger serialNumber = new AtomicInteger();
    @Override
    public void run() {
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){

        }
        System.out.println(Thread.currentThread().getName()+ ":" + getSerialNumber());
    }

    private int getSerialNumber() {
       return serialNumber++;
        // 自增运算
        //  return serialNumber.getAndIncrement();
    }
}