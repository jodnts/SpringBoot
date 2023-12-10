package com.example.demo1spring.controller;

import com.example.demo1spring.service.CartService;
import com.example.demo1spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteFromCartController {

    private final CartService cartService;

    @Autowired
    public DeleteFromCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/deletefromcart")
    @ResponseBody
    public String deleteFromCart(@RequestParam int productId, @RequestParam boolean removeAll, User user) {
        try {
            int userId = user.getId();
            cartService.removeFromCart(productId, removeAll, userId);
            return "{\"status\":\"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"status\":\"error\"}";
        }
    }
}
