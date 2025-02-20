package practica.practica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practica.practica.model.Vaca;

@Repository
public interface VacaRepository extends JpaRepository<Vaca, Long> {
    List<Vaca> findByNombreContainingIgnoreCase(String nombre);
}
