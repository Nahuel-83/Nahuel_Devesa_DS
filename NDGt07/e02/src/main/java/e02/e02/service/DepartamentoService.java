package e02.e02.service;

import java.util.List;

import e02.e02.domain.Departamento;

public interface DepartamentoService {
    List<Departamento> obtenerTodos();

    Departamento obtenerPorId(Long id);

    Departamento añadir(Departamento departamento);

    Departamento editar(Departamento departamento);

    void borrar(Long id);
}
