package e04.e04.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteDTO {
    
    private String dni;
    private String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private Integer tipoPaciente;
    private String motivoConsulta;
    private String listaMedicamentos; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaUltimaRevision;
}
