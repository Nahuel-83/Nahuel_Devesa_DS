package e02.e02.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String nombre;

    private Double presupuestoAnual;  

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    public boolean presupuestoValido() {
        double totalSalarios = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .sum();
        return totalSalarios <= presupuestoAnual;
    }

    public boolean puedeAgregarSalario(double salario) {
        double totalSalarios = empleados.stream().mapToDouble(Empleado::getSalario).sum();
        return (totalSalarios + salario) <= presupuestoAnual;
    }
}
