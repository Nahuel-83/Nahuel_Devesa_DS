package e04.e04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import e04.e04.model.Paciente;
import e04.e04.model.PacienteDTO;
import e04.e04.service.PacienteService;

@Controller
public class PacienteController {
    @Autowired
    public PacienteService pacienteService;

    @GetMapping({ "/", "/home" })
    public String showList(Model model) {
        model.addAttribute("listaPacientes", pacienteService.findAll());
        model.addAttribute("factura", 0);
        return "pacientesList";
    }

    @GetMapping("/newPaciente")
    public String showNew(Model model) {
        model.addAttribute("paciente", new PacienteDTO());
        return "pacienteNew";
    }

    @PostMapping("newPaciente/submit")
    public String showNewPaciente(@ModelAttribute PacienteDTO newPacienteDTO) {
        Paciente newPaciente = pacienteService.buildPacienteFromDTO(newPacienteDTO);

        pacienteService.add(newPaciente);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String getMethodName(Model model) {
        Paciente paciente = pacienteService.getFirst();
        double factura = 0;
        if (paciente != null) {
            factura = pacienteService.factura(paciente);
            pacienteService.deleteFirst();
        }
        model.addAttribute("listaPacientes", pacienteService.findAll());
        model.addAttribute("factura", factura);
        return "pacientesList";
    }

}
