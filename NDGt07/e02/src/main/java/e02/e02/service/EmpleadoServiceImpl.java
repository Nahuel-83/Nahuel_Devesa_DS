package e02.e02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import e02.e02.domain.Empleado;
import e02.e02.domain.Genero;
import e02.e02.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;


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
}