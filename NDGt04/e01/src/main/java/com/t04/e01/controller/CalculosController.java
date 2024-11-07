package com.t04.e01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.t04.e01.service.CalculosServiceImpl;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/calculos")
public class CalculosController {
    @Autowired
    private CalculosServiceImpl calculosServiceImpl;

    @GetMapping("/")
    public String index() {
        return "index";  
    }
    
    @GetMapping("/primo")
    public String getPrimo(Integer numero, Model model) {
        if (numero == null) {
            model.addAttribute("error", "El parámetro 'numero' es requerido.");
            return "error";
        }
        if (numero <= 0) {
            model.addAttribute("error", "El número debe ser mayor que cero.");
            return "error";
        } 
        boolean esPrimo = calculosServiceImpl.esPrimo(numero);
        model.addAttribute("numero", numero);
        model.addAttribute("esPrimo", esPrimo);
        return "primo";
    }
    
    @GetMapping("/hipotenusa/{cateto1}/{cateto2}")
    public String calcularHipotenusa(@PathVariable int cateto1, @PathVariable int cateto2, Model model) {
        if (cateto1 <= 0 || cateto2 <= 0) {
            model.addAttribute("error", "Los catetos deben ser mayores que cero.");
            return "error";
        }
        double hipotenusa = calculosServiceImpl.calcularHipotenusa(cateto1, cateto2);
        model.addAttribute("hipotenusa", hipotenusa);
        model.addAttribute("hipotenusa", hipotenusa);
        model.addAttribute("hipotenusa", hipotenusa);
        return "hipotenusa";
    }

    @GetMapping("/divisores/{numero}")
    public String calcularDivisores(@PathVariable int numero, Model model) {
        if (numero <= 0) {
            model.addAttribute("error", "El número debe ser mayor que cero.");
            return "error";
        }
        
        List<Integer> divisores = calculosServiceImpl.obtenerDivisores(numero);
        
        model.addAttribute("numero", numero);
        model.addAttribute("divisores", divisores);
        return "divisores";
    }
}
