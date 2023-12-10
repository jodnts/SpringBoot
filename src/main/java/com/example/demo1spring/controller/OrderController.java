package com.example.demo1spring.controller;

import com.example.demo1spring.model.User;
import com.example.demo1spring.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/myOrders")
    public String getUserOrders(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            int userId = user.getId();
            List<Object[]> userOrders = orderService.getUserOrders(userId);

            // Ajoutez la liste des commandes à l'objet Model pour l'affichage dans la vue
            model.addAttribute("userOrders", userOrders);

            // Log
            System.out.println("Number of user orders fetched: " + userOrders.size());

            // Redirigez vers votre vue d'affichage des commandes
            return "myOrders"; // Le nom de votre vue JSP ou Thymeleaf
        }

        // Gérer le cas où l'utilisateur n'est pas connecté ou la session est invalide
        return "redirect:/login"; // Rediriger vers la page de connexion ou une autre page appropriée
    }
}
