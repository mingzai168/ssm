package com.spring.test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo rwd = new ReadWriteLockDemo();


        // 一个线程进行写
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwd.set((int)(Math.random()*100)) ;
            }
        },"wtite").start();



        for (int i = 0 ;i < 15 ;i++){
            new Thread(new Runnable() {
                public void run() {
                    rwd.get();
                }
            },"read:").start();
        }
    }
}

class ReadWriteLockDemo{
    private  int  number  = 0 ;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    // 读
    public  void  get(){

        try {
            lock.readLock().lock(); // 上锁
            System.out.println(Thread.currentThread().getName()+":"+number);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
    // 写
    public  void  set (int number){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+":"+number);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }

}
