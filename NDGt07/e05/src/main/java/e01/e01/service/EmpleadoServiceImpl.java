package e01.e01.service;

import e01.e01.domain.Empleado;
import e01.e01.domain.Genero;
import e01.e01.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado obtenerPorId(long id) throws RuntimeException {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Override
    public Empleado añadir(Empleado empleado) {
        if (empleado.getSalario() < 18000) {
            throw new RuntimeException("El salario no puede ser menor a 18,000 euros.");
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado editar(Empleado empleado) throws RuntimeException {
        if (empleado.getSalario() < 18000) {
            throw new RuntimeException("El salario no puede ser menor a 18,000 euros.");
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public void borrar(Long id) throws RuntimeException {
        empleadoRepository.deleteById(id);
    }

    @Override
    public List<Empleado> buscarPorNombre(String search) {
        return empleadoRepository.findByNombreContainingIgnoreCase(search);
    }

    @Override
    public List<Empleado> buscarPorGenero(Genero genero) {
        return empleadoRepository.findByGenero(genero);
    }

    @Override
    public List<Empleado> obtenerEmpleadosSalarioSuperiorAMedia() {
        List<Empleado> empleados = obtenerTodos();
        double media = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);

        return empleados.stream()
                .filter(empleado -> empleado.getSalario() > media)
                .collect(Collectors.toList());
    }

    @Override
    public List<Empleado> buscarPorSalarioMayorQue(Double salario) {
        return empleadoRepository.findBySalarioGreaterThan(salario);
    }

    public List<Empleado> obtenerEmpleadosConSalarioAlto() {
        return empleadoRepository.queryBySalarioOverAverage();
    }
}