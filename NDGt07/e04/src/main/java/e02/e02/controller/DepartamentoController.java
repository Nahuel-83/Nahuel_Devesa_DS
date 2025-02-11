package e02.e02.controller;

import e02.e02.domain.Departamento;
import e02.e02.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/depto")
@RequiredArgsConstructor
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @GetMapping("/")
    public String listDepartamentos(Model model) {
        model.addAttribute("departamentos", departamentoService.obtenerTodos());
        return "departamento/listView";
    }

    @GetMapping("/nuevo")
    public String showNewForm(Model model) {
        model.addAttribute("departamentoForm", new Departamento());
        return "departamento/newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String createDepartamento(@ModelAttribute("departamentoForm") Departamento departamento, Model model) {
        try {
            departamentoService.añadir(departamento);
            return "redirect:/depto/";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "departamento/newFormView";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarDepartamento(@PathVariable Long id, Model model) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        model.addAttribute("departamento", departamento);
        return "departamento/editFormView";
    }

    @PostMapping("/editar/{id}/submit")
    public String updateDepartamento(@ModelAttribute("departamentoForm") Departamento departamento, Model model) {
        try {
            departamentoService.editar(departamento);
            return "redirect:/depto/";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "departamento/editFormView";
        }
    }

    @GetMapping("/borrar/{id}")
    public String deleteDepartamento(@PathVariable Long id) {
        departamentoService.borrar(id);
        return "redirect:/depto/";
    }
}
