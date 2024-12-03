package com.vacafactory.vacas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vacafactory.vacas.services.VacasService;

@Controller
@Scope("session")
public class VacasController {
    @Autowired
    VacasService vacasService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/metodoVaca")
    public String procesarFormulario(
            @RequestParam("metodo") String metodo,
            Model model) {

        switch (metodo) {
            case "crear":
                return "redirect:/crear";
            case "eliminar":
                return "redirect:/eliminar";
            case "editar":
                return "redirect:/editar";
            case "listar":
                model.addAttribute("vacas", vacasService.listarVacas());
                return "listarVacas";
            default:
                model.addAttribute("error", "Operación no válida.");
                return "index";
        }
    }

    @GetMapping("/crear")
    public String mostrarCrearFormulario() {
        return "crearVaca";
    }

    @PostMapping("/crear")
    public String crearVaca(
            @RequestParam("id") Integer id,
            @RequestParam("nombre") String nombre,
            @RequestParam("fechaNac") String fechaNac,
            @RequestParam("peso") Double peso,
            @RequestParam("foto") MultipartFile file,
            Model model) {

        if (file == null || file.isEmpty()) {
            model.addAttribute("error", "Debe subir una foto de la vaca.");
            return "crearVaca";
        }

        vacasService.guardarVaca(id, nombre, fechaNac, peso, file);
        if (vacasService.getError() != null) {
            model.addAttribute("error", vacasService.getError());
        } else {
            model.addAttribute("success", "Vaca creada exitosamente.");
        }
        return "crearVaca";
    }

    @GetMapping("/eliminar")
    public String mostrarEliminarFormulario() {
        return "eliminarVaca";
    }

    @PostMapping("/eliminar")
    public String eliminarVaca(
            @RequestParam("id") Integer id,
            Model model) {

        vacasService.eliminarVaca(id);
        if (vacasService.getError() != null) {
            model.addAttribute("error", vacasService.getError());
        } else {
            model.addAttribute("success", "Vaca eliminada exitosamente.");
        }
        return "eliminarVaca";
    }

    @GetMapping("/editar")
    public String mostrarEditarFormulario() {
        return "editarVaca";
    }

    @PostMapping("/editar")
    public String editarVaca(
            @RequestParam("id") Integer id,
            @RequestParam("nombre") String nombre,
            @RequestParam("fechaNac") String fechaNac,
            @RequestParam("peso") Double peso,
            Model model) {

        vacasService.editarVaca(id, nombre, fechaNac, peso);
        if (vacasService.getError() != null) {
            model.addAttribute("error", vacasService.getError());
        } else {
            model.addAttribute("success", "Vaca editada exitosamente.");
        }
        return "editarVaca";
    }
}
