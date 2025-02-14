package e02.e02.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import e02.e02.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    boolean existsByNombre(String nombre); 
    
    @EntityGraph(attributePaths = "empleados") 
    Optional<Departamento> findById(Long id);

}
