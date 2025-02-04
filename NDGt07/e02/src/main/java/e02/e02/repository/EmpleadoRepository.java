package e02.e02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import e02.e02.domain.Empleado;
import e02.e02.domain.Genero;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNombreContainingIgnoreCase(String search);

    List<Empleado> findByGenero(Genero genero);
}