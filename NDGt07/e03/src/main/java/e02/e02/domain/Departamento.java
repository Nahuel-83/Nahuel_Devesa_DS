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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Empleado> empleados;

    public boolean presupuestoValido() {
        if (this.empleados != null && this.empleados.size() > 0) {
            double totalSalarios = empleados.stream()
                    .mapToDouble(Empleado::getSalario)
                    .sum();
            return totalSalarios <= presupuestoAnual;
        } else return true;
    }

    public boolean puedeAgregarSalario(double salario) {
        if (empleados == null || empleados.isEmpty()) {
            return salario <= presupuestoAnual;
        }
        double totalSalarios = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .sum();
        return (totalSalarios + salario) <= presupuestoAnual;
    }

}
