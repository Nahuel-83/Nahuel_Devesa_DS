package e09.e09.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String escudo_url;
    private int partidos_jugados = 0;
    private int ganados = 0;
    private int empatados = 0;
    private int perdidos = 0;
    private int goles_favor = 0;
    private int goles_contra = 0;
    private int puntos = 0;
}