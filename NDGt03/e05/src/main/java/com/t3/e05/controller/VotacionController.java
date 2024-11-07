package com.t3.e05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VotacionController {


    private int votosAvatar = 0;
    private int votosCadenaPerpetua = 0;
    private int votosPulpFiction = 0;

    @GetMapping("/")
    public String mostrarPeliculas(Model model) {
      
        model.addAttribute("votosAvatar", votosAvatar);
        model.addAttribute("votosCadenaPerpetua", votosCadenaPerpetua);
        model.addAttribute("votosPulpFiction", votosPulpFiction);
        return "votacion"; 
    }


    @GetMapping("/voto")
    public String votar(@RequestParam("foto") int foto) {
        switch (foto) {
            case 0:
                votosAvatar++;
                break;
            case 1:
                votosCadenaPerpetua++;
                break;
            case 2:
                votosPulpFiction++;
                break;
            default:
                break;
        }
        return "redirect:/";
    }
}