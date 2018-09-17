package com.spring.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    // 测试类: 以卖票为例
    // 使用 lock 之前
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "@2号窗口").start();
        new Thread(ticket, "3号窗口").start();
        new Thread(ticket, "4号窗口").start();

    }
}

// 使用 Lock
class Ticket implements Runnable {

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    public void run() {
        while (true) {
            // 上锁
            lock.lock();

            try {
                if (tick > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {

                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票,余票为: " + --tick);
                }
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}

