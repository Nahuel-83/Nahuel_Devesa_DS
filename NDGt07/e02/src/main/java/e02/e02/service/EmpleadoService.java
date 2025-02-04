package e02.e02.service;

import java.util.List;

import e02.e02.domain.Empleado;
import e02.e02.domain.Genero;

public interface EmpleadoService {
    List<Empleado> obtenerTodos();

    Empleado obtenerPorId(long id);

    Empleado añadir(Empleado empleado);

    Empleado editar(Empleado empleado);

    void borrar(Long id);

    List<Empleado> buscarPorNombre(String search);

    List<Empleado> buscarPorGenero(Genero genero);
}
