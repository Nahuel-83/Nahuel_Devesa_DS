package e02.e02.repository;

import e02.e02.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    boolean existsByNombre(String nombre); 
}
