package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ECommerceSystemTest {
    @Test
    public void testPlaceOrder() {
        ECommerceSystem system = new ECommerceSystem();
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product1", 10.0);
        Product product2 = new Product(2, "Product2", 20.0);
        cart.addProduct(product1);
        cart.addProduct(product2);

        Order order = system.placeOrder(cart);

        assertNotNull(order);
        assertEquals(1, order.getOrderId());
        assertEquals(2, order.getProducts().size());
        assertEquals("Pending", order.getStatus());
    }

    @Test
    public void testGetOrderStatus() {
        ECommerceSystem system = new ECommerceSystem();
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product1", 10.0);
        cart.addProduct(product1);

        Order order = system.placeOrder(cart);

        String status = system.getOrderStatus(order.getOrderId());

        assertEquals("Pending", status);
    }
}
