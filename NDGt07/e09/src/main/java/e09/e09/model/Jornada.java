package e09.e09.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import e09.e09.repository.JornadaRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jornada")
public class Jornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;

    @OneToMany(mappedBy = "jornada")
    private List<Partido> partidos;

    public void actualizarNumeroJornada(JornadaRepository jornadaRepository) {
        int numeroJornada = (int) jornadaRepository.count() + 1; 
        this.setNumero(numeroJornada);
    }
}