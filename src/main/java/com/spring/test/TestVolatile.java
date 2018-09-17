package com.spring.test;

/**
 * volatile 关键字: 当多个线程进行操作共享数据时,可以保证内存中的数据是可见的;相较于 synchronized 是一种
 * 较为轻量级的同步策略;
 * volatile 不具备"互斥性";
 * volatile 不能保证变量的"原子性";
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo1 td = new ThreadDemo1();
        new Thread(td).start();
        while (true) {
//            synchronized (td) {      //  解决问题方式一: 同步锁 使用同步锁但是,效率太低
                if (td.isFlag()) {
                    System.out.println("使用 volatile 之前########");
                    break;
                }
//            }
        }

    }

}

class ThreadDemo1 implements Runnable {
    //private boolean flag = false;
    private volatile boolean flag = false; // 解决方式二: 使用 volatile 关键字
    @Override
    public void run() {
        try {
            Thread.sleep(200);  // 该线程 sleep(200), 导致了程序无法执行成功
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + isFlag());
    }

    public Boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}