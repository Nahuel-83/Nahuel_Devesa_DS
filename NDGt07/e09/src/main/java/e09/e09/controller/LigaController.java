package e09.e09.controller;

import e09.e09.service.LigaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/liga")
@RequiredArgsConstructor
public class LigaController {
    private final LigaService ligaService;

    @GetMapping("/clasificacion")
    public String mostrarClasificacion(Model model) {
        model.addAttribute("equipos", ligaService.getClasificacion());
        return "clasificacion";
    }

    @GetMapping("/jornadas")
    public String mostrarJornadas(Model model) {
        model.addAttribute("jornadas", ligaService.getJornadas());
        return "jornadas";
    }

    @PostMapping("/simular-jornada")
    public String simularJornada(Model model) {
        try {
            ligaService.simularJornada();
            return "redirect:/liga/jornadas"; // Redirigir a la página de jornadas después de simular
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); // Pasar el mensaje de error a la vista
            return "jornadas"; // Regresar a la vista de jornadas con el mensaje de error
        }
    }

    // Capturar la excepción IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public String manejarError(IllegalArgumentException e, Model model) {
        model.addAttribute("error", e.getMessage()); // Mostrar el mensaje de error
        return "jornadas"; // Redirigir a la página de jornadas con el mensaje de error
    }
}
