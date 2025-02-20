package practica.practica.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "explotaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Explotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cif;
    private String nombreEmpresa;

    @Column(name = "nombre_calle_ubicacion", nullable = false)
    private String calleUbicacion;

    @ManyToMany(mappedBy = "explotaciones")
    private Set<Vaca> vacas;

    @Override
    public String toString() {
        return "Explotacion{" +
                "id=" + id +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }
}
