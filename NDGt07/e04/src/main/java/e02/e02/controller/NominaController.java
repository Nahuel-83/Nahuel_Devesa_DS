package e02.e02.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import e02.e02.domain.Empleado;
import e02.e02.domain.Nomina;
import e02.e02.service.EmpleadoService;
import e02.e02.service.NominaService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/nominas")
@RequiredArgsConstructor
public class NominaController {
    private final NominaService nominaService;
    private final EmpleadoService empleadoService;

    @PostMapping("/cargar")
    public ResponseEntity<String> cargarNominasDesdeCSV(@RequestParam("file") MultipartFile file) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
            String line;
            List<Nomina> nuevasNominas = new ArrayList<>();

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");

                if (datos.length != 4) {
                    continue;
                }

                try {
                    Long empleadoId = Long.parseLong(datos[0]);
                    LocalDate fecha = LocalDate.parse(datos[1]);
                    Double salarioBruto = Double.parseDouble(datos[2]);
                    Double salarioNeto = Double.parseDouble(datos[3]);

                    Empleado empleado = empleadoService.obtenerPorId(empleadoId);

                    if (empleado == null) {
                        System.out.println("Empleado con ID " + empleadoId + " no encontrado.");
                        continue;
                    }

                    if (!nominaService.existeNomina(empleadoId, fecha)) {
                        Nomina nomina = new Nomina(null, fecha, salarioBruto, salarioNeto, empleado);
                        nuevasNominas.add(nomina);
                    }

                } catch (Exception e) {
                    continue;
                }
            }

            nuevasNominas.forEach(nominaService::guardarNomina);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header(HttpHeaders.LOCATION, "/nominas/listView")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al procesar el archivo CSV: " + e.getMessage());
        }
    }

    @GetMapping("/listView")
    public String listarNominas(Model model) {
        model.addAttribute("nominas", nominaService.obtenerTodas());
        return "nominas/listView";
    }
}