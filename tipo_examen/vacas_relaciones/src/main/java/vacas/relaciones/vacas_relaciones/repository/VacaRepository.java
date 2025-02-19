package vacas.relaciones.vacas_relaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vacas.relaciones.vacas_relaciones.model.Vacas;

@Repository
public interface VacaRepository extends JpaRepository<Vacas, Long> {
    List<Vacas> findByNombreContainingIgnoreCase(String nombre);
}

