package e02.e02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e02.e02.domain.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
