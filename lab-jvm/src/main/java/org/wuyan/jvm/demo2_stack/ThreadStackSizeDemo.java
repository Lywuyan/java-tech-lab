package org.wuyan.jvm.demo2_stack;

import java.util.concurrent.TimeUnit;

public class ThreadStackSizeDemo {
    public static void main(String[] args) {
        int count = 0;
        try{
            while (true){
                new Thread(() -> {
                    try{
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                }).start();
                count++;
                System.out.println("创建了" + count + "个线程");
            }
        }catch (Throwable e){
            System.out.println("失败时线程shu" + count);
            e.printStackTrace();
        }
    }
}
