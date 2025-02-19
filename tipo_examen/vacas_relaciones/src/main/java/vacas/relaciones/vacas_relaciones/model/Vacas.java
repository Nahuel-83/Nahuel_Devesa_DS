package vacas.relaciones.vacas_relaciones.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "vacas")
@NoArgsConstructor
@AllArgsConstructor
public class Vacas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;
    
    @Min(value = 0)
    private Double peso;

    @NotBlank
    private String fotoPerfil;
}

