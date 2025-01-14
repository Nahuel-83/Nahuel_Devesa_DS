package e03.e03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import e03.e03.service.TestService;


@Controller
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String startTest() {
        testService.resetearTest();
        return "redirect:/pregunta";  // Redirige a la primera pregunta
    }

    @GetMapping("/pregunta")
    public String showPregunta(Model model) {
        if (testService.getPreguntaActual() == null) {
            return "redirect:/resultado";  // Si no hay más preguntas, muestra el resultado
        }
        model.addAttribute("pregunta", testService.getPreguntaActual());
        return "pregunta";  // Vista para mostrar la pregunta
    }

    @PostMapping("/enviar")
    public String submitAnswer(@RequestParam("respuesta") int respuesta) {
        testService.responderPregunta(respuesta);
        return "redirect:/pregunta";  // Redirige a la siguiente pregunta
    }

    @GetMapping("/resultado")
    public String showResultado(Model model) {
        model.addAttribute("puntaje", testService.getPuntaje());
        model.addAttribute("total", testService.getTotalPreguntas());
        return "resultado";  // Vista con los resultados finales
    }
}
