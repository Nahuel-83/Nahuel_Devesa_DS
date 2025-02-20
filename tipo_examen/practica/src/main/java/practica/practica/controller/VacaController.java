package practica.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import practica.practica.model.Vaca;
import practica.practica.service.VacaService;

@Controller
@RequiredArgsConstructor
public class VacaController {

    private final VacaService vacaService;

    // Listar todas las vacas
    @GetMapping("/")
    public String listVacas(Model model) {
        model.addAttribute("vacas", vacaService.getAllVacas());
        return "vacas/list";
    }

    // Mostrar formulario para crear una nueva vaca
    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("vaca", new Vaca());
        return "vacas/new";
    }

    // Crear una nueva vaca
    @PostMapping("/nuevo/submit")
    public String createVaca(@ModelAttribute Vaca vaca, Model model) {
        try {
            vacaService.createVaca(vaca);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "vacas/new";
        }
    }

    // Mostrar formulario para editar una vaca
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Vaca vaca = vacaService.getVacaById(id);
        if (vaca != null) {
            model.addAttribute("vaca", vaca);
            return "vacas/edit";
        } else {
            model.addAttribute("error", "No se encontró la vaca con ID: " + id);
            return "redirect:/";
        }
    }

    // Actualizar una vaca
    @PostMapping("/editar/{id}/submit")
    public String updateVaca(@PathVariable Long id, @ModelAttribute Vaca vaca, Model model) {
        try {
            vacaService.updateVaca(id, vaca);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "vacas/edit";
        }
    }

    // Eliminar una vaca
    @GetMapping("/borrar/{id}")
    public String deleteVaca(@PathVariable Long id, Model model) {
        try {
            vacaService.deleteVaca(id);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/";
        }
    }
}
