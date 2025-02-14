package e02.e02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import e02.e02.domain.Departamento;
import e02.e02.domain.Empleado;
import e02.e02.domain.Genero;
import e02.e02.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoService departamentoService;

    @Override
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public List<Empleado> obtenerPorDepartamento(Long departamentoId) {
        if (departamentoId == null || departamentoId == 0) {
            return obtenerTodos();
        }
        return empleadoRepository.findByDepartamentoId(departamentoId);
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
        Departamento departamento = departamentoService.obtenerPorId(empleado.getDepartamento().getId());
        if (!departamento.puedeAgregarSalario(empleado.getSalario())) {
            throw new RuntimeException("No se puede añadir el empleado porque excede el presupuesto del departamento.");
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado editar(Empleado empleado) throws RuntimeException {
        if (empleado.getSalario() < 18000) {
            throw new RuntimeException("El salario no puede ser menor a 18,000 euros.");
        }
        Departamento departamento = departamentoService.obtenerPorId(empleado.getDepartamento().getId());
        if (!departamento.puedeAgregarSalario(empleado.getSalario())) {
            throw new RuntimeException("No se puede actualizar el empleado porque excede el presupuesto del departamento.");
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public void borrar(Long id) throws RuntimeException {
        try {
            empleadoRepository.findById(id).ifPresent(empleado -> {
                empleado.setDepartamento(null);
                empleadoRepository.save(empleado);
                empleadoRepository.delete(empleado);
            });
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el empleado", e);
        }
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
    public List<Empleado> buscarPorSalarioMayorQue(Double salario) {
        return empleadoRepository.findBySalarioGreaterThan(salario);
    }

    public List<Empleado> obtenerEmpleadosConSalarioAlto() {
        return empleadoRepository.queryBySalarioOverAverage();
    }
}