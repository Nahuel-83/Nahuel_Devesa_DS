package com.example.e04.controllador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.e04.service.CalculadoraServicesImpl;

@Controller
public class CalculadoraController {
    
    @Autowired
    private CalculadoraServicesImpl calculadoraService;

    @GetMapping("/")
    public String index(Model model) {
        // Cargar los valores del servicio en el modelo
        model.addAttribute("operando1", calculadoraService.getOperando1());
        model.addAttribute("operando2", calculadoraService.getOperando2());
        model.addAttribute("resultado", calculadoraService.getEstado() == CalculadoraServicesImpl.Estado.RESULTADO ? calculadoraService.getResultado() : "");
        model.addAttribute("estado", calculadoraService.getEstado());
        return "index";
    }

    @RequestMapping("/digito/{num}")
    public String addDigito(@PathVariable("num") int num) {
        calculadoraService.addDigito(num);
        return "redirect:/";
    }

    @GetMapping("/suma")
    public String sumar() {
        calculadoraService.sumar();
        return "redirect:/";
    }

    @GetMapping("/igual")
    public String calcularResultado() {
        calculadoraService.calcularResultado();
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear(SessionStatus status) {
        calculadoraService.clear();
        return "redirect:/";
    }
}
