package e01.e01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import e01.e01.domain.Empleado;
import e01.e01.domain.Genero;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNombreContainingIgnoreCase(String search);

    List<Empleado> findByGenero(Genero genero);

    List<Empleado> findBySalarioGreaterThan(Double salario);
}