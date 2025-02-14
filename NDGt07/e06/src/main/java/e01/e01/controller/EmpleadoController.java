package e01.e01.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import e01.e01.domain.Empleado;
import e01.e01.service.EmpleadoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping({ "/", "/list" })
    public String showList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Page<Empleado> paginaEmpleados = empleadoService.obtenerTodos(PageRequest.of(page, size));
        model.addAttribute("listaEmpleados", paginaEmpleados.getContent());
        model.addAttribute("paginaActual", page);
        model.addAttribute("totalPaginas", paginaEmpleados.getTotalPages());

        return "listView";
    }
}