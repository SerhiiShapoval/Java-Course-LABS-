package com.university.lab_3;

import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Геттеры и сеттеры
}

class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    // Другие методы
}

class Order {
    private int orderId;
    private List<Product> products;
    private String status;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "Pending"; // Статус по умолчанию
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Другие методы
}

public class ECommerceSystem {
    public static void main(String[] args) {
        // Создание продуктов
        Product product1 = new Product(1, "Product 1", 19.99);
        Product product2 = new Product(2, "Product 2", 29.99);

        // Создание корзины и добавление продуктов
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        // Создание заказа из корзины
        Order order = new Order(1, cart.getProducts());

        // Обновление статуса заказа
        order.setStatus("Shipped");

        // Вывод статуса заказа
        System.out.println("Статус заказа: " + order.getStatus());
    }
}

