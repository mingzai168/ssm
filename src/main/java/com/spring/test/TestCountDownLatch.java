package com.spring.test;
//是一个同步辅助类,在完成一组正在其他线程中执行的操作之前,它允许一个或多个线程一直等待
import java.util.concurrent.CountDownLatch;

// 测试类: 计算多线程的执行时间
public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        LatchDemo latchDemo = new LatchDemo(latch);
        long start = System.currentTimeMillis();

        //创建10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(latchDemo).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("耗费时间为:" + (end - start));
    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    // 有参构造器
    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 线程数量递减
                latch.countDown();
            }
        }
    }
}