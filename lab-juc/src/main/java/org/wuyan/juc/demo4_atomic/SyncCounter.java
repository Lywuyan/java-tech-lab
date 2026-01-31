package org.wuyan.juc.demo4_atomic;

public class SyncCounter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public synchronized int get(){
        return count;
    }
}
