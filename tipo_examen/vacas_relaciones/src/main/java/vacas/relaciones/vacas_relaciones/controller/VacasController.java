package vacas.relaciones.vacas_relaciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import vacas.relaciones.vacas_relaciones.model.Vacas;
import vacas.relaciones.vacas_relaciones.service.VacaService;

@Controller
@RequiredArgsConstructor
public class VacasController {
    private final VacaService vacaService;

    @GetMapping({ "/", "/list" })
    public String showList(@RequestParam(required = false) String msg, Model model) {

        if (msg != null) {
            model.addAttribute("msg", msg);
            model.addAttribute("alertClass", "alert-danger");
        }

        model.addAttribute("listaEmpleados", vacaService.listarVacas());

        return "listView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("vacaForm", new Vacas());
        return "newView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid @ModelAttribute("VacasForm") Vacas vacasForm, RedirectAttributes redirectAttributes) {
        try {
            vacaService.guardarVaca(vacasForm);
            redirectAttributes.addFlashAttribute("msg", "Vaca añadido correctamente");
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
        Vacas vaca = vacaService.obtenerPorId(id);
        model.addAttribute("VacasForm", vaca);
        return "editFormView";
    }

    @PostMapping("/editar/{id}/submit")
    public String actualizarEmpleado(@ModelAttribute("VacasForm") Vacas vaca) {
        vacaService.actualizarVaca(vaca);
        return "redirect:/list";
    }


    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            vacaService.eliminarVaca(id); 
            redirectAttributes.addFlashAttribute("msg", "Vaca borrado correctamente");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/list"; 
    }
}