package com.spring.test;

public class TestCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            // 创建10个线程,模拟多线程环境
            new Thread(new Runnable() {
                public void run() {
                    int expectedValue = cas.get();

                    boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 100));
                    System.out.println(b);
                }
            }).start();
        }
    }
}
