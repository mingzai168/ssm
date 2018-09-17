package com.spring.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool  {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo tpd = new ThreadPoolDemo();
        long start = System.currentTimeMillis();

        // 2. 为线程池中线程分配任务
        //    submit(Callable<T> task)
        //    submit(Runnable task)

        for(int i=0; i<5; i++){
            pool.submit(tpd);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为:" + (end - start));
        // 3. 关闭线程池
        pool.shutdown();
    }
}




class ThreadPoolDemo implements Runnable{

    private int i=0;

    public synchronized void  run(){

        while(i <= 200){
            System.out.println(Thread.currentThread().getName()+" : "+ i++);
        }


    }
}