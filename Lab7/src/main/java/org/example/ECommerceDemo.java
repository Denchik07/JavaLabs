package org.example;

import java.util.*;



class Product implements Comparable<Product> {
    private Integer id;
    private String name;
    private double price;
    private int stock;

    public Product(Integer id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }



    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + ", stock=" + stock + "}";
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    public void setStock(int newStock) {
        stock = newStock;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
}

class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }



    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', cart=" + cart + "}";
    }
}

class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = new HashMap<>();
        this.totalPrice = 0.0;
    }



    @Override
    public String toString() {
        return "Order{id=" + id + ", userId=" + userId + ", orderDetails=" + orderDetails + ", totalPrice=" + totalPrice + "}";
    }
}



class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    // Методи для додавання користувачів, товарів, створення замовлення, переліку доступних товарів, переліку користувачів, переліку замовлень та оновлення запасів товарів.

    public List<Product> getAvailableProducts() {
        return new ArrayList<>(products.values());
    }

    public List<User> getUsersList() {
        return new ArrayList<>(users.values());
    }

    public List<Order> getOrdersList() {
        return new ArrayList<>(orders.values());
    }

    public void updateProductStock(Product product, int newStock) {
        if (products.containsKey(product.getId())) {
            product.setStock(newStock);
        }
    }

    public List<Product> recommendProducts(User user) {
        return new ArrayList<>(); // Поки що повертає пустий список.
    }
}

// Реалізація Comparable у класі Product дозволяє його сортування за ціною.

class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class ProductStockComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p1.getStock(), p2.getStock());
    }
}



public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        // Ініціалізація користувачів, товарів і т. д.

        // Симуляція взаємодій користувачів, оновлень кошика, обробки замовлень, рекомендацій і т. д.
    }
}