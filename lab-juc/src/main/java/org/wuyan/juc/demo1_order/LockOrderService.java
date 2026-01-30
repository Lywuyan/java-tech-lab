package org.wuyan.juc.demo1_order;

import java.util.concurrent.locks.ReentrantLock;

public class LockOrderService implements OrderService{

    private int stock = 100;

    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public boolean placeOrder() {
        //lock.lock();
        try {
            lock.lockInterruptibly(); // 锁中断
            if(stock > 0){
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                Thread.sleep(1000);
                stock--;
                return true;
            }
            return false;
        }catch (InterruptedException e){
            System.out.println("线程被中断");
            return false;
        } finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }

        }
    }

    @Override
    public int getStock() {
        return stock;
    }
}
