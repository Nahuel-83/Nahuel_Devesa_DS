package com.e02.e02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e02.e02.services.DateService;

import org.springframework.ui.Model;

@Controller
public class formController {

    @Autowired
    private DateService dateService;

    @GetMapping("/")
    public String getIndex() {
        return "/index";
    }

    @PostMapping("/procesarFechas")
    public String procesarFechas(@RequestParam("fecha1") String fecha1, @RequestParam("fecha2") String fecha2,
            @RequestParam("operacion") String operacion, Model model) {
    
        String resultado;


        switch (operacion) {
            case "dias":
                long dias = dateService.calcularDiasEntreFechas(fecha1, fecha2);
                resultado = "Días entre las fechas: " + dias;
                break;

            case "bisiestos":
                String aniosBisiestos = dateService.listarAniosBisiestos(fecha1, fecha2);
                resultado = "Años bisiestos: " + aniosBisiestos;
                break;

            case "domingo":
                int domingos = dateService.contarDomingos(fecha1, fecha2);
                resultado = "Años en que el 1 de enero fue domingo: " + domingos;
                break;

            default:
                resultado = "Operación no válida.";
                break;
        }

        model.addAttribute("resultado", resultado);
        return "resultado"; 
    }

}
