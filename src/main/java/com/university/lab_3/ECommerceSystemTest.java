package com.university.lab_3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ECommerceSystemTest {

    private Product product1;
    private Product product2;
    private Cart cart;
    private Order order;

    @Before
    public void setup() {
        // Создание тестовых продуктов и корзины
        product1 = new Product(1, "Product 1", 19.99);
        product2 = new Product(2, "Product 2", 29.99);
        cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        // Создание заказа из корзины
        order = new Order(1, cart.getProducts());
    }

    @Test
    public void testAddProductToCart() {
        // Тест на добавление продукта в корзину
        Product product3 = new Product(3, "Product 3", 9.99);
        cart.addProduct(product3);
        List<Product> products = cart.getProducts();
        assertTrue(products.contains(product3));
    }

    @Test
    public void testRemoveProductFromCart() {
        // Тест на удаление продукта из корзины
        cart.removeProduct(product1);
        List<Product> products = cart.getProducts();
        assertFalse(products.contains(product1));
    }

    @Test
    public void testCreateOrderFromCart() {
        // Тест на создание заказа из корзины
        assertNotNull(order);
        List<Product> orderProducts = order.getProducts();
        assertEquals(cart.getProducts(), orderProducts);
    }

    @Test
    public void testUpdateOrderStatus() {
        // Тест на обновление статуса заказа
        order.setStatus("Shipped");
        assertEquals("Shipped", order.getStatus());
    }
}
