package e02.e02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import e02.e02.domain.Empleado;
import e02.e02.domain.Genero;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNombreContainingIgnoreCase(String search);

    List<Empleado> findByGenero(Genero genero);

    List<Empleado> findBySalarioGreaterThan(Double salario);

    @Query("select e from Empleado e where e.salario > (select avg (e2.salario) from Empleado e2)")
    List<Empleado> queryBySalarioOverAverage();

    List<Empleado> findByDepartamentoId(Long departamentoId);

    @Modifying
    @Query("UPDATE Empleado e SET e.departamento = NULL WHERE e.id = :id")
    void quitarDepartamento(@Param("id") Long id);
}