package com.nldg.nldg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nldg.nldg.model.Viaje;
import com.nldg.nldg.service.ViajeService;

@Controller
@Scope("session")
public class ViajeController {
    @Autowired
    ViajeService viajeService;

    @GetMapping("/viajes")
    public String home(Model model) {
        List<Viaje> viajes = viajeService.listarViajes();
        model.addAttribute("viajes", viajes);
        return "index";
    }

    @PostMapping("/viajes")
    public String procesarFormulario(
            @RequestParam("metodo") String metodo,
            Model model) {

        switch (metodo) {
            case "crear":
                return "redirect:/viajes/crear";
            case "listar":
                model.addAttribute("videoclips", viajeService.listarViajes());
                return "index";
            default:
                model.addAttribute("error", "Operación no válida.");
                return "index";
        }
    }

    @PostMapping("/viajes/eliminar")
    public String eliminarLibro(@RequestParam("id") Integer id, Model model) {
        viajeService.eliminarViajes(id);
        if (viajeService.getError() != null) {
            model.addAttribute("error", viajeService.getError());
        }

        List<Viaje> viajes = viajeService.listarViajes();
        model.addAttribute("videoclips", viajes);
        return "redirect:/viajes";
    }

    @GetMapping("/viajes/crear")
    public String mostrarCrearFormulario() {
        return "crear";
    }

    @PostMapping("/viajes/crear")
    public String crearLibro(
            @RequestParam("id") Integer id,
            @RequestParam("destino") String destino,
            @RequestParam("duracion") Integer duracion,
            @RequestParam("fecha") LocalDate fecha,
            @RequestParam("descripcion") String descripcion,
            Model model) {


        viajeService.guardarViajes(id, destino, duracion, fecha, descripcion);
        if (viajeService.getError() != null) {
            model.addAttribute("error", viajeService.getError());
        } else {
            model.addAttribute("success", "Viaje creada exitosamente.");
        }
        return "crear";
    }
}
