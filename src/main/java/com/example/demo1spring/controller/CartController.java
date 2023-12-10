package com.example.demo1spring.controller;

import com.example.demo1spring.service.CartService;
import com.example.demo1spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartController {

        private final CartService cartService;

        @Autowired
        public CartController(CartService cartService) {
                this.cartService = cartService;
        }

        @GetMapping("/panier")
        public String viewCartItems(Model model, User user) {
                int userId = user.getId();
                List<Object[]> cartItems = cartService.getAllCartItem(userId);

                model.addAttribute("cartItems", cartItems);

                // Log
                System.out.println("Number of cartItems fetched: " + cartItems.size());

                return "panier"; // Le nom de la vue à afficher (panier.jsp)
        }
}
