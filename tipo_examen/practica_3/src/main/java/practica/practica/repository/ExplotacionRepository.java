package practica.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practica.practica.model.Explotacion;

@Repository
public interface ExplotacionRepository extends JpaRepository<Explotacion, Long> {
}
