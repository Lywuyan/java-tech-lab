package org.wuyan.juc.demo1_order;

public class OrderTask implements Runnable {

    private final OrderService orderService;

    public OrderTask(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run() {
        orderService.placeOrder();
    }
}
