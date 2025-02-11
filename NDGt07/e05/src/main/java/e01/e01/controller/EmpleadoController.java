package e01.e01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import e01.e01.service.EmpleadoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping({ "/", "/list" })
    public String showList(@RequestParam(required = false) String msg, Model model) {

        if (msg != null) {
            model.addAttribute("msg", msg);
            model.addAttribute("alertClass", "alert-danger");
        }

        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());

        return "listView";
    }

}
