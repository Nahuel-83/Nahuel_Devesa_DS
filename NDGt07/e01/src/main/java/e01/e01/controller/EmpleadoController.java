package e01.e01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import e01.e01.domain.Empleado;
import e01.e01.domain.Genero;
import e01.e01.service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping({ "/", "/list" })
    public String showList(@RequestParam(required = false) String search,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String msg,
            @RequestParam(required = false) Double minSalario, // Parametro para salario
            Model model) {
        if (msg != null) {
            model.addAttribute("msg", msg);
            model.addAttribute("alertClass", "alert-danger");
        }

        if (search != null && !search.isBlank()) {
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
        } else {
            model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        }

        model.addAttribute("minSalario", minSalario); // Pasa el valor ingresado por el usuario

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
            // Si hay errores, vuelve a mostrar el formulario con los errores
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

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("empleadoForm", empleadoService.obtenerPorId(id));
            model.addAttribute("generos", Genero.values());
            return "editFormView";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/list";
        }
    }

    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@Valid @ModelAttribute("empleadoForm") Empleado empleadoForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "editFormView";
        }

        try {
            empleadoService.editar(empleadoForm);
            redirectAttributes.addFlashAttribute("msg", "Empleado editado correctamente");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            return "redirect:/list";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/editar/" + empleadoForm.getId();
        }
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
