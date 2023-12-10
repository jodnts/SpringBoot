package com.example.demo1spring.service;

import java.util.List;

public interface CartService {
    void addToCart(int productId, int userId, int quantity);

    void removeFromCart(int productId, boolean removeAll, int userId);

    List<Object[]> getAllCartItem(int userId);
    // Ajoute d'autres méthodes si nécessaire
}
