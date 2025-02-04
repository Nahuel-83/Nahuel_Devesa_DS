package e01.e01.service;

import java.util.List;

import e01.e01.domain.Empleado;
import e01.e01.domain.Genero;

public interface EmpleadoService {
    List<Empleado> obtenerTodos();

    Empleado obtenerPorId(long id);

    Empleado añadir(Empleado empleado);

    Empleado editar(Empleado empleado);

    void borrar(Long id);

    List<Empleado> buscarPorNombre(String search);

    List<Empleado> buscarPorGenero(Genero genero);

    List<Empleado> obtenerEmpleadosSalarioSuperiorAMedia();

    List<Empleado> buscarPorSalarioMayorQue(Double salario);
}
