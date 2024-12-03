package com.tienda.tienda.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tienda.tienda.model.User;

@Controller
@Scope("session")
public class HomeController {
    
    private User user;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        this.user = user;
        return "redirect:/";
    }

    public User getUser() {
        return user;
    }
}
