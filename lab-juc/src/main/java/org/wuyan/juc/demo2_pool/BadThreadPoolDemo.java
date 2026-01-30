package org.wuyan.juc.demo2_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BadThreadPoolDemo {
    public static void main(String[] args) {
        // 默认无界队列，任务堆积在内存中占满堆内存
        //ExecutorService executor = Executors.newFixedThreadPool(5);
        // 默认无界线程，线程创建爆炸
        //ExecutorService executor = Executors.newCachedThreadPool();
        // 默认无界队列，任务堆积在内存中占满堆内存
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for(int i = 0;i<Integer.MAX_VALUE;i++){
            executor.submit(()->{
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ignored){
                }
            });
        }


    }
}
