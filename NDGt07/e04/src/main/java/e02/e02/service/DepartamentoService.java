package e02.e02.service;

import e02.e02.domain.Departamento;
import java.util.List;

public interface DepartamentoService {
    List<Departamento> obtenerTodos();

    Departamento obtenerPorId(Long id);

    Departamento añadir(Departamento departamento);

    Departamento editar(Departamento departamento);

    void borrar(Long id);

    boolean existeDepartamentoPorNombre(String nombre); 
}
