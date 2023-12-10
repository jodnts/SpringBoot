package com.example.demo1spring.controller;

import com.example.demo1spring.service.OrderService;
import com.example.demo1spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddOrderController {

    private final OrderService orderService;

    @Autowired
    public AddOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam("userId") int userId,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("address") String address,
                           @RequestParam("city") String city,
                           @RequestParam("postalCode") String postalCode,
                           @RequestParam("mail") String mail) {
        try {
            Order order = new Order();
            order.setUserId(userId);
            order.setFirstName(firstName);
            order.setLastName(lastName);
            order.setAddress(address);
            order.setCity(city);
            order.setPostalCode(postalCode);

            orderService.addOrder(order);

            // Obtenir la liste des produits par utilisateur
            List<Object[]> products = orderService.getProductsByUser(userId);

            // Envoyer le reçu par e-mail
            orderService.sendReceipt(mail, order, products);

            return "redirect:/orderConfirmation"; // Rediriger vers une page de confirmation
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les exceptions et rediriger vers une page d'erreur si nécessaire
            return "redirect:/error";
        }
    }
}
