package org.wuyan.juc.demo4_atomic;

import java.util.concurrent.CountDownLatch;


public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100;
        int times = 10_000;

        UnsafeCounter counter = new UnsafeCounter();
        SyncCounter counter1 = new SyncCounter();
        AtomicCounter counter2 = new AtomicCounter();
        LongAdderCounter counter3 = new LongAdderCounter();
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    counter3.increment();
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("期望值" + (threadCount * times));
        System.out.println("实际值" + counter3.get());
    }
}
