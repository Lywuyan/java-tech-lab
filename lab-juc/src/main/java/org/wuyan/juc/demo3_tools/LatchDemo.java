package org.wuyan.juc.demo3_tools;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int taskCount = 5;
        CountDownLatch latch = new CountDownLatch(taskCount);
        for(int i = 0;i < taskCount;i++){
            int taskId = i;
            new Thread(() -> {
                try{
                    System.out.println("子线程" + taskId+ "开始执行");
                    Thread.sleep(1000);
                    System.out.println("子线程" + taskId+ "执行完毕");
                }catch (InterruptedException ignored){
                }finally {
                    latch.countDown();
                }
            }).start();
        }
        System.out.println("主线程开始等待");
        latch.await();
        System.out.println("所有子线程执行完毕");
    }
}
