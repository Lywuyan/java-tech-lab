package org.wuyan.juc.demo3_tools;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 最多允许3个线程同时执行
        Semaphore semaphore = new Semaphore(3);

        for(int i = 0;i<10;i++){
            int taskId = i;
            new Thread(() -> {
                try{
                    semaphore.acquire();
                    System.out.println("子线程" + taskId+ "获取到资源");
                    Thread.sleep(1000);
                }catch (InterruptedException ignored){
                }finally {
                    System.out.println("子线程" + taskId+ "释放资源");
                    semaphore.release();
                }
            }).start();
        }
    }
}
