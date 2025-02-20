package practica.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import practica.practica.model.Explotacion;
import practica.practica.service.ExplotacionService;

@Controller
@RequiredArgsConstructor
public class ExplotacionController {

    private final ExplotacionService explotacionService;

    // Listar todas las explotaciones
    @GetMapping("/explotaciones")
    public String listExplotaciones(Model model) {
        model.addAttribute("explotaciones", explotacionService.getAllExplotaciones());
        return "explotaciones/list";
    }

    // Mostrar formulario para crear una nueva explotación
    @GetMapping("/explotaciones/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("explotacion", new Explotacion());
        return "explotaciones/new";
    }

    // Crear una nueva explotación
    @PostMapping("/explotaciones/nuevo/submit")
    public String createExplotacion(@ModelAttribute Explotacion explotacion, Model model) {
        try {
            explotacionService.createExplotacion(explotacion);
            return "redirect:/explotaciones";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "explotaciones/new";
        }
    }

    // Mostrar formulario para editar una explotación
    @GetMapping("/explotaciones/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Explotacion explotacion = explotacionService.getExplotacionById(id);
        if (explotacion != null) {
            model.addAttribute("explotacion", explotacion);
            return "explotaciones/edit";
        } else {
            model.addAttribute("error", "No se encontró la explotación con ID: " + id);
            return "redirect:/explotaciones";
        }
    }

    // Actualizar una explotación
    @PostMapping("/explotaciones/editar/{id}/submit")
    public String updateExplotacion(@PathVariable Long id, @ModelAttribute Explotacion explotacion, Model model) {
        try {
            explotacionService.updateExplotacion(id, explotacion);
            return "redirect:/explotaciones";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "explotaciones/edit";
        }
    }

    @GetMapping("/explotaciones/borrar/{id}")
    public String deleteExplotacion(@PathVariable Long id, Model model) {
        try {
            explotacionService.deleteExplotacion(id);
            return "redirect:/explotaciones";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/explotaciones";
        }
    }
}
