package com.example.demo1spring.service;

import com.example.demo1spring.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    void deleteOrderFromCart(int userId);

    void sendReceipt(String recipientEmail, Order order, List<Object[]> products);

    List<Object[]> getProductsByUser(int userID);

    List<Object[]> getUserOrders(int userID);

    List<Object[]> getAllOrders();
}
