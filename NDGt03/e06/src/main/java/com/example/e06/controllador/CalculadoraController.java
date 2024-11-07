package com.example.e06.controllador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculadoraController {

    enum Estado {
        OPERANDO1, OPERANDO2, RESULTADO
    }

    private int operando1 = 0;
    private int operando2 = 0;
    private int resultado = 0;
    private Estado estado = Estado.OPERANDO1;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("operando1", operando1);
        model.addAttribute("operando2", operando2);
        model.addAttribute("resultado", estado == Estado.RESULTADO ? resultado : "");
        model.addAttribute("estado", estado);
        return "index";
    }

    @RequestMapping("/digito/{num}")
    public String addDigito(@PathVariable("num") int num) {
        if (estado == Estado.OPERANDO1) {
            operando1 = operando1 * 10 + num;
        } else if (estado == Estado.OPERANDO2) {
            operando2 = operando2 * 10 + num;
        }
        return "redirect:/";
    }

    @GetMapping("/suma")
    public String sumar() {
        if (estado == Estado.OPERANDO1) {
            estado = Estado.OPERANDO2;
        }
        return "redirect:/";
    }

    @GetMapping("/igual")
    public String calcularResultado() {
        if (estado == Estado.OPERANDO2) {
            resultado = operando1 + operando2;
            estado = Estado.RESULTADO;
        }
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        operando1 = 0;
        operando2 = 0;
        resultado = 0;
        estado = Estado.OPERANDO1;
        return "redirect:/";
    }
}
