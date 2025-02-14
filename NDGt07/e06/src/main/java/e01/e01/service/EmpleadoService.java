package e01.e01.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import e01.e01.domain.Empleado;

public interface EmpleadoService {
    Page<Empleado> obtenerTodos(Pageable pageable);
}
