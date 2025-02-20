package practica.practica.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vacas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    @Min(value = 1, message = "El peso debe ser mayor a 0")
    private double peso;

    private String fotoPerfil;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "vacas_explotaciones", joinColumns = @JoinColumn(name = "vaca_id"), inverseJoinColumns = @JoinColumn(name = "explotacion_id"))
    private List<Explotacion> explotaciones;

    @Override
    public String toString() {
        return "Vaca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", explotaciones=" + (explotaciones != null ? explotaciones.size() : 0) +
                '}';
    }

}
