package org.wuyan.juc.demo2_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GoodThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for(int i = 0; i < 1000; i++){
            executor.submit(()->{
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ignored){
                }
            });
        }
        executor.shutdown();
    }
}
