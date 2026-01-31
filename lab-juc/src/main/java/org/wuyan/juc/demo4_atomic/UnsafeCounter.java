package org.wuyan.juc.demo4_atomic;

public class UnsafeCounter {
    private int count = 0;
    public void increment(){
        count++;
    }
    public int get(){
        return count;
    }
}
