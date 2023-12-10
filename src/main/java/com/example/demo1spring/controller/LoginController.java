package com.example.demo1spring.controller;

import com.example.demo1spring.model.User;
import com.example.demo1spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String mail, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            User user = userService.getUser(mail, password);
            if (user != null) {
                // Session activée
                request.getSession().setAttribute("user", user);
                // L'authentification a réussi, redirigez vers la page d'accueil ou une autre page sécurisée
                return "{\"status\":\"success\", \"redirect\":\"/demo1_war_exploded/products\"}";
            } else {
                // L'authentification a échoué, redirigez vers la page de connexion avec un message d'erreur
                return "{\"status\":\"error\", \"redirect\":\"/demo1_war_exploded/login.jsp?error=auth_failed\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"status\":\"error\", \"redirect\":\"/demo1_war_exploded/login.jsp?error=server_error\"}";
        }
    }
}
