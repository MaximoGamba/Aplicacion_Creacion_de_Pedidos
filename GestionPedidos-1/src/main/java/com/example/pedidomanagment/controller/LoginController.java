package com.example.pedidomanagment.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Retorna el nombre de la plantilla Thymeleaf, sin la extensión ".html"
    }

}
