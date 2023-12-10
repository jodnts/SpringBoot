package com.example.demo1spring.controller;

import com.example.demo1spring.service.CartService;
import com.example.demo1spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AddToCartController {

    private final CartService cartService;

    @Autowired
    public AddToCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addtocart")
    public String addToCart(@RequestParam("productId") int productId,
                            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
                            HttpSession session,
                            Model model) {
        // Vérifier si l'utilisateur est connecté
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // Redirection vers la page de connexion si l'utilisateur n'est pas connecté
            return "redirect:/login?notConnected=true";
        }

        int userId = user.getId();
        cartService.addToCart(productId, userId, quantity);

        return "redirect:/panier";
    }
}
