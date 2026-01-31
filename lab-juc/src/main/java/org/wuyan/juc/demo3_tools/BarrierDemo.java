package org.wuyan.juc.demo3_tools;

import java.util.concurrent.CyclicBarrier;

public class BarrierDemo {
    public static void main(String[] args) {
        int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> System.out.println("所有线程到达屏障，进入下一阶段"));
        for (int i = 0; i < threadCount; i++) {
            int taskId = i;
            new Thread(() -> {
                try{
                    System.out.println("线程" + taskId+ "第一阶段完成");
                    Thread.sleep(1000);
                    System.out.println("线程" + taskId+ "第二阶段完成");
                }catch (InterruptedException ignored){
                }
            }).start();
        }
    }
}
