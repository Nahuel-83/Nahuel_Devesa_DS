package com.libreria.libros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreria.libros.services.LibroService;

@Controller
@Scope("session")
public class LibrosController {
    @Autowired
    LibroService libroService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/libro")
    public String procesarFormulario(
            @RequestParam("metodo") String metodo,
            Model model) {

        switch (metodo) {
            case "crear":
                return "redirect:/crear";
            case "listar":
                model.addAttribute("libros", libroService.listarLibros());
                return "index";
            default:
                model.addAttribute("error", "Operación no válida.");
                return "index";
        }
    }

    @PostMapping("/eliminar")
    public String eliminarLibro(@RequestParam("titulo") String titulo, Model model) {
        libroService.eliminarLibro(titulo);
        if (libroService.getError() != null) {
            model.addAttribute("error", libroService.getError());   
        }
        return "redirect:/";
    }

    @GetMapping("/crear")
    public String mostrarCrearFormulario() {
        return "crearLibro";
    }

    @PostMapping("/crear")
    public String crearLibro(
            @RequestParam("titulo") String titulo,
            @RequestParam("autor") String autor,
            @RequestParam("genero") String genero,
            @RequestParam("anoPubli") Integer anoPubli,
            Model model) {

        libroService.guardarLibro(titulo, autor, genero, anoPubli);
        if (libroService.getError() != null) {
            model.addAttribute("error", libroService.getError());
        } else {
            model.addAttribute("success", "Libro creada exitosamente.");
        }
        return "crearLibro";
    }

}
