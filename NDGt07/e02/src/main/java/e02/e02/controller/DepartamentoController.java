package e02.e02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import e02.e02.domain.Departamento;
import e02.e02.service.DepartamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/depto")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        return "departamentoListView";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("departamentoForm", new Departamento());
        return "departamentoFormView";
    }

    @PostMapping("/nuevo/submit")
    public String submitNuevo(@Valid @ModelAttribute("departamentoForm") Departamento departamentoForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "departamentoFormView";
        }
        departamentoService.añadir(departamentoForm);
        redirectAttributes.addFlashAttribute("msg", "Departamento añadido correctamente");
        return "redirect:/depto/";
    }
}
