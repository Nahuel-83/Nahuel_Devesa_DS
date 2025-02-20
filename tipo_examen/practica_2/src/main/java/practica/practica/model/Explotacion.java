package practica.practica.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "explotacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaca> vacas;
}
