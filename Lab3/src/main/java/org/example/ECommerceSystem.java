package org.example;

import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    private List<Order> orders;

    public ECommerceSystem() {
        this.orders = new ArrayList<>();
    }

    public Order placeOrder(Cart cart) {
        Order order = new Order(orders.size() + 1, cart.getProducts());
        orders.add(order);
        return order;
    }

    public String getOrderStatus(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order.getStatus();
            }
        }
        return "Order not found";
    }
}
