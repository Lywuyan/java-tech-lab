package org.wuyan.juc.demo1_order;

public class OrderTest {
    public static void main(String[] args) throws InterruptedException {
        // 原始做法
        //OrderService orderService = new UnsafeOrderService();
        // 加 synchronized 锁做法
        //OrderService orderService = new SynchronizedOrderService();
        // 加 ReentrantLock 锁做法
        OrderService orderService = new LockOrderService();

        int threadCount = 1000;
        Thread[] threads = new Thread[threadCount];
        long start = System.currentTimeMillis();
        for(int i = 0; i < threadCount; i++){
            threads[i] = new Thread(new OrderTask(orderService));
            threads[i].start();

        }
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start));
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println("最终库存" + orderService.getStock());
    }
}
