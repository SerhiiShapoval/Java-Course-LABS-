package com.university.lab_7;

import java.util.*;
import java.util.stream.Collectors;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }

    @Override
    public int compareTo(Product otherProduct) {
        return Double.compare(this.price, otherProduct.price);
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void addToCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        if (cart.containsKey(product)) {
            int currentQuantity = cart.get(product);
            if (currentQuantity - quantity <= 0) {
                cart.remove(product);
            } else {
                cart.put(product, currentQuantity - quantity);
            }
        }
    }

    public void modifyCart(Product product, int newQuantity) {
        if (newQuantity <= 0) {
            cart.remove(product);
        } else {
            cart.put(product, newQuantity);
        }
    }
}

class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(Integer id, Integer userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
        calculateTotalPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<Product, Integer> orderDetails) {
        this.orderDetails = orderDetails;
        calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void calculateTotalPrice() {
        totalPrice = orderDetails.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
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

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public List<Product> getAvailableProducts() {
        return products.values().stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public void updateProductStock(Integer productId, int newStock) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setStock(newStock);
        }
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(0, "smith_cena");
        User user2 = new User(1, "alexander_field");
        Product product1 = new Product(0, "Computer", 3500.0, 25);
        Product product2 = new Product(1, "Chair", 1500.0, 6);
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addProduct(product1);
        platform.addProduct(product2);

        user1.addToCart(product1, 0);
        user2.addToCart(product2, 1);

        Order order1 = new Order(0, user1.getId(), user1.getCart());
        Order order2 = new Order(1, user2.getId(), user2.getCart());
        platform.createOrder(order1);
        platform.createOrder(order2);

        platform.updateProductStock(product1.getId(), 25);
        platform.updateProductStock(product2.getId(), 6);

        System.out.println("Users:");
        for (User user : platform.getUsers()) {
            System.out.println(user);
        }

        System.out.println("Products:");
        for (Product product : platform.getAvailableProducts()) {
            System.out.println(product);
        }

        System.out.println("Orders:");
        for (Order order : platform.getOrders()) {
            System.out.println(order);
        }
    }
}
