package com.videoclip.videoclip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.videoclip.videoclip.model.Videoclip;
import com.videoclip.videoclip.service.VideoclipService;

@Controller
@Scope("session")
public class VideclipController {
    @Autowired
    VideoclipService videoclipService;

    @GetMapping("/")
    public String home(Model model) {
        List<Videoclip> videoclips = videoclipService.listarVideoclips(); 
        model.addAttribute("videoclips", videoclips);
        return "index";
    }

    @PostMapping("/vidioclip")
    public String procesarFormulario(
            @RequestParam("metodo") String metodo,
            Model model) {

        switch (metodo) {
            case "crear":
                return "redirect:/crear";
            case "listar":
                model.addAttribute("videoclips", videoclipService.listarVideoclips());
                return "index";
            default:
                model.addAttribute("error", "Operación no válida.");
                return "index";
        }
    }

    @PostMapping("/eliminar")
    public String eliminarLibro(@RequestParam("titulo") String titulo, Model model) {
        videoclipService.eliminarVideoclip(titulo);
        if (videoclipService.getError() != null) {
            model.addAttribute("error", videoclipService.getError());
        }

        List<Videoclip> videoclips = videoclipService.listarVideoclips(); 
        model.addAttribute("videoclips", videoclips);
        return "redirect:/";
    }

    @GetMapping("/crear")
    public String mostrarCrearFormulario() {
        return "crearvideoclip";
    }

    @PostMapping("/crear")
    public String crearLibro(
            @RequestParam("titulo") String titulo,
            @RequestParam("artista") String artista,
            @RequestParam("genero") String genero,
            @RequestParam("anopubli") String anoPubli,
            @RequestParam("url") String url,
            Model model) {

        Integer ano;
        if (!anoPubli.isEmpty() && anoPubli != null) {
            ano = Integer.parseInt(anoPubli);
        } else {
            ano = -1;
        }
        videoclipService.guardarVideoclip(titulo, artista, genero, ano, url);
        if (videoclipService.getError() != null) {
            model.addAttribute("error", videoclipService.getError());
        } else {
            model.addAttribute("success", "videclip creada exitosamente.");
        }
        return "crearvideoclip";
    }
}
