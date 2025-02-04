package e04.e04.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import e04.e04.config.Tarifas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "dni")
@AllArgsConstructor
@NoArgsConstructor
public abstract class Paciente {
    private String dni;
    private String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    public abstract Double facturar(Tarifas tarifas);
}
