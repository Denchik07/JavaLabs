package org.example;

import java.util.*;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}

class Order {
    private int orderId;
    private List<Product> products;
    private String status;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "Pending"; // Початковий статус
    }

    // Геттери та сеттери

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }


    public Collection<Object> getProducts() {

        return null;
    }
}

