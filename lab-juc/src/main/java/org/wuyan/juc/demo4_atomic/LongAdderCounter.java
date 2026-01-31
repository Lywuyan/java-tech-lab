package org.wuyan.juc.demo4_atomic;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounter {
    private final LongAdder count = new LongAdder();

    public void increment(){
        count.increment();
    }
    public long get(){
        return count.sum();
    }
}
