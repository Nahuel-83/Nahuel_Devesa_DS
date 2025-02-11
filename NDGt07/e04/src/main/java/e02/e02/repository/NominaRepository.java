package e02.e02.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e02.e02.domain.Nomina;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, Long> {
    Optional<Nomina> findByEmpleadoIdAndFecha(Long empleadoId, LocalDate fecha);}
