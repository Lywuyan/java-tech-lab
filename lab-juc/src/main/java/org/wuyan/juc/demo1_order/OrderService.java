package org.wuyan.juc.demo1_order;

public interface OrderService {

    /**
     * 下单
     */
    boolean placeOrder();

    /**
     * 当前库存
     */
    int getStock();
}
