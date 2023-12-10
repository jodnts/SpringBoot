package com.example.demo1spring.controller;

import com.example.demo1spring.model.User;
import com.example.demo1spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    private final UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public String signInUser(@RequestParam("mail") String mail,
                             @RequestParam("password") String password) {
        User user = new User();
        user.setMail(mail);
        user.setPassword(password);

        userService.registerUser(user);

        boolean isAuthenticated = userService.authenticateUser(mail, password);

        if (isAuthenticated) {
            // L'authentification a réussi
            // Envoyer un e-mail de confirmation
            // Rediriger l'utilisateur vers la page de connexion
            return "redirect:/login.jsp?success=sign_succeeded";
        } else {
            // L'authentification a échoué
            // Afficher un message d'erreur sur la page de connexion
            return "redirect:/signin.jsp?error=sign_failed";
        }
    }
}
