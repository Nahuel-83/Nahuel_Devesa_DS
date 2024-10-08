package com.t03.e01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/", "/index", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping("/palmares")
    public String palmares() {
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