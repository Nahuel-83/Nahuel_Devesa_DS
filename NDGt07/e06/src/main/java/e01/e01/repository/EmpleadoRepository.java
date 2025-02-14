package e01.e01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import e01.e01.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Page<Empleado> findAll(Pageable pageable);
}