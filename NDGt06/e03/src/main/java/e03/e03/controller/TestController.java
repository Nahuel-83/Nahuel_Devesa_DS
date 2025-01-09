package e03.e03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import e03.e03.model.Pregunta;
import e03.e03.service.TestServiceImpl;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestServiceImpl testService;

    private int numeroPregunta = 1;

    @GetMapping
    public String iniciarTest(Model model) {
        numeroPregunta = 1;
        testService.reiniciarTest();
        return "redirect:/test/pregunta/" + numeroPregunta;
    }

    @GetMapping("/pregunta/{numero}")
    public String mostrarPregunta(@PathVariable int numero, Model model) {
        Pregunta pregunta = testService.getPregunta(numero);
        model.addAttribute("pregunta", pregunta);
        return "pregunta";
    }

    @PostMapping("/pregunta/{numero}")
    public String responderPregunta(@PathVariable int numero, @RequestParam int respuesta) {
        testService.verificarRespuesta(numero, respuesta);
        if (numero < testService.getPreguntas().size()) {
            return "redirect:/test/pregunta/" + (numero + 1);
        } else {
            return "redirect:/test/resultado";
        }
    }

    @GetMapping("/resultado")
    public String mostrarResultado(Model model) {
        model.addAttribute("puntaje", testService.getPuntaje());
        model.addAttribute("total", testService.getPreguntas().size());
        return "resultado";
    }
}