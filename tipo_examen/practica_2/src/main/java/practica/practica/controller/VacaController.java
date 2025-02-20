package practica.practica.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import practica.practica.model.Explotacion;
import practica.practica.model.Vaca;
import practica.practica.service.ExplotacionService;
import practica.practica.service.VacaService;

@Controller
@RequiredArgsConstructor
public class VacaController {

    private final VacaService vacaService;
    private final ExplotacionService explotacionService;

    // Listar todas las vacas
    @GetMapping("/")
    public String listVacas(Model model) {
        model.addAttribute("vacas", vacaService.getAllVacas());
        return "vacas/list";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        List<Explotacion> explotaciones = explotacionService.getAllExplotaciones();

        model.addAttribute("explotaciones", explotaciones);
        model.addAttribute("vaca", new Vaca());

        return "vacas/new";
    }

    @PostMapping("/nuevo/submit")
    public String createVaca(@ModelAttribute Vaca vaca, Model model) {
        try {
            // Validar que la explotación no sea nula
            if (vaca.getExplotacion() == null || vaca.getExplotacion().getId() == null) {
                throw new IllegalArgumentException("Debe seleccionar una explotación para la vaca.");
            }

            vacaService.createVaca(vaca);

            return "redirect:/";
        } catch (IllegalArgumentException e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("explotaciones", explotacionService.getAllExplotaciones());
            return "vacas/new";
        }
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Vaca vaca = vacaService.getVacaById(id);
        List<Explotacion> explotaciones = explotacionService.getAllExplotaciones();

        if (vaca != null) {
            model.addAttribute("explotaciones", explotaciones);
            model.addAttribute("vaca", vaca);
            return "vacas/edit";
        } else {
            model.addAttribute("error", "No se encontró la vaca con ID: " + id);
            return "redirect:/";
        }
    }

    @PostMapping("/editar/{id}/submit")
    public String updateVaca(@PathVariable Long id, @ModelAttribute Vaca vaca, Model model) {
        try {
            if (vaca.getExplotacion() == null || vaca.getExplotacion().getId() == null) {
                throw new IllegalArgumentException("Debe seleccionar una explotación para la vaca.");
            }

            vacaService.updateVaca(id, vaca);

            return "redirect:/";
        } catch (IllegalArgumentException e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("explotaciones", explotacionService.getAllExplotaciones());
            return "vacas/new";
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
