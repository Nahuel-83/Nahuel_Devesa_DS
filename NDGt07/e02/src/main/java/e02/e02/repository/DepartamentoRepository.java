package e02.e02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import e02.e02.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}