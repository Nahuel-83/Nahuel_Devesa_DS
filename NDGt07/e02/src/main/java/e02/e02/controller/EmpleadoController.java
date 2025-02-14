package e02.e02.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import e02.e02.domain.Departamento;
import e02.e02.domain.Empleado;
import e02.e02.domain.Genero;
import e02.e02.service.DepartamentoService;
import e02.e02.service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;
    private final DepartamentoService departamentoService;

    @ModelAttribute("generos")
    public Genero[] getGeneros() {
        return Genero.values();
    }

    @ModelAttribute("departamentos")
    public List<Departamento> getDepartamentos() {
        return departamentoService.obtenerTodos();
    }

    @GetMapping({ "/", "/list" })
    public String showList(@RequestParam(required = false) String search,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String msg,
            @RequestParam(required = false) Double minSalario,
            @RequestParam(required = false) Boolean salarioMayorPromedio,
            @RequestParam(required = false) Long departamentoId,
            Model model) {

        if (msg != null) {
            model.addAttribute("msg", msg);
            model.addAttribute("alertClass", "alert-danger");
        }

        if (salarioMayorPromedio != null && salarioMayorPromedio) {
            model.addAttribute("listaEmpleados", empleadoService.obtenerEmpleadosConSalarioAlto());
        } else if (search != null && !search.isBlank()) {
            model.addAttribute("listaEmpleados", empleadoService.buscarPorNombre(search));
        } else if (genero != null && !genero.isBlank()) {
            try {
                model.addAttribute("listaEmpleados", empleadoService.buscarPorGenero(Genero.valueOf(genero)));
            } catch (IllegalArgumentException e) {
                model.addAttribute("msg", "Género inválido");
                model.addAttribute("alertClass", "alert-danger");
            }
        } else if (minSalario != null) {
            model.addAttribute("listaEmpleados", empleadoService.buscarPorSalarioMayorQue(minSalario));
        } else if (departamentoId != null && departamentoId > 0) {
            model.addAttribute("listaEmpleados", empleadoService.obtenerPorDepartamento(departamentoId));
        } else {
            model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        }

        model.addAttribute("minSalario", minSalario);
        model.addAttribute("departamentoId", departamentoId);

        return "listView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("empleado", empleadoService.obtenerPorId(id));
            return "listOneView";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/list";
        }
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("empleadoForm", new Empleado());
        model.addAttribute("generos", Genero.values());
        return "newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid @ModelAttribute("empleadoForm") Empleado empleadoForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("generos", Genero.values());
            return "newFormView";
        }

        try {
            empleadoService.añadir(empleadoForm);
            redirectAttributes.addFlashAttribute("msg", "Empleado añadido correctamente");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            return "redirect:/list";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/nuevo";
        }
    }

    @RequestMapping("/editar/{id}")
    public String editarEmpleado(@PathVariable("id") Long id, Model model) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        List<Departamento> departamentos = departamentoService.obtenerTodos();
        model.addAttribute("empleadoForm", empleado);
        model.addAttribute("departamentos", departamentos);
        return "editFormView";
    }

    @PostMapping("/editar/{id}/submit")
    public String actualizarEmpleado(@ModelAttribute("empleadoForm") Empleado empleado) {
        empleadoService.añadir(empleado);
        return "redirect:/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            empleadoService.borrar(id); 
            redirectAttributes.addFlashAttribute("msg", "Empleado borrado correctamente");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/list"; 
    }
}
