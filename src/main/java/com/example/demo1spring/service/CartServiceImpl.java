package com.example.demo1spring.service;

import com.example.demo1spring.model.CartItem;
import com.example.demo1spring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void addToCart(int productId, int userId, int quantity) {
        // Implémente la logique pour ajouter au panier
        // Utilise le CartRepository pour interagir avec la base de données
        // ...
    }

    @Override
    public void removeFromCart(int productId, boolean removeAll, int userId) {

    }


    @Override
    public List<Object[]> getAllCartItem(int userId) {
        // Implémente la logique pour récupérer tous les articles du panier pour un utilisateur donné
        // Utilise le CartRepository pour interagir avec la base de données
        // ...
        return null;
    }
}
