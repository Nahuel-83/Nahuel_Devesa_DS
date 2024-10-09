package com.t03.e01.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/", "/index", "/home"})
    public String index(@RequestParam(required = false) String usuario, Model model) {
    String mensajeBienvenida;
    
    if (usuario != null && !usuario.isEmpty()) {
        mensajeBienvenida = "Bienvenido " + usuario + " a nuestra web";
    } else {
        mensajeBienvenida = "Bienvenido a nuestra web";
    }

    model.addAttribute("mensajeBienvenida", mensajeBienvenida);
    model.addAttribute("year", LocalDate.now().getYear());
    return "index"; 
}

    @GetMapping("/palmares")
    public String palmares(Model model) {
        List<String> titulos = new ArrayList<>();
        titulos.add("Liga 2021");
        titulos.add("Copa del Rey 2020");
        titulos.add("Supercopa 2019");

        model.addAttribute("titulos", titulos);
        return "palmares";
    }

    @GetMapping("/galeria-fotos")
    public String galeria() {
        return "galeria-fotos";
    }

    @GetMapping("/enlaces")
    public String enlaces() {
        return "enlaces-externos";
    }
    
}