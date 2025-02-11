package e02.e02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import e02.e02.domain.Proyecto;
import e02.e02.service.ProyectoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/proyecto")
@RequiredArgsConstructor
public class ProyectoController {
    private final ProyectoService proyectoService;

    @GetMapping("/")
    public String listarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.findAll());
        return "proyecto/listView";
    }

    @GetMapping("/nuevo")
    public String nuevoProyecto(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyecto/newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoService.save(proyecto);
        return "redirect:/proyecto/";
    }

    @GetMapping("/editar/{id}")
    public String editarDepartamento(@PathVariable Long id, Model model) {
        Proyecto proyecto = proyectoService.findById(id);
        model.addAttribute("proyecto", proyecto);
        return "proyecto/editFormView";
    }

    @PostMapping("/editar/{id}/submit")
    public String updateDepartamento(@ModelAttribute("proyecto") Proyecto proyecto, Model model) {
        try {
            proyectoService.save(proyecto);
            return "redirect:/proyecto/";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "proyecto/editFormView";
        }
    }

    @GetMapping("/borrar/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        proyectoService.deleteById(id);
        return "redirect:/proyecto/";
    }
}