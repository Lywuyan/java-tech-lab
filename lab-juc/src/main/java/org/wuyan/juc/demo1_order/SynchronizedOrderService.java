package org.wuyan.juc.demo1_order;

public class SynchronizedOrderService implements OrderService{

    private int stock = 100;

    @Override
    public synchronized boolean placeOrder() {
        if(stock > 0){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stock--;
            return true;
        }
        return false;
    }

    @Override
    public int getStock() {
        return stock;
    }
}
