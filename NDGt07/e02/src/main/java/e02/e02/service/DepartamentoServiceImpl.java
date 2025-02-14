package e02.e02.service;

import e02.e02.domain.Departamento;
import e02.e02.domain.Empleado;
import e02.e02.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento obtenerPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
    }

    @Override
    public Departamento añadir(Departamento departamento) {
        if (existeDepartamentoPorNombre(departamento.getNombre())) {
            throw new RuntimeException("Ya existe un departamento con ese nombre.");
        }
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento editar(Departamento departamento) {
        if (presupuestoValido(departamento)) {
            return departamentoRepository.save(departamento);

        } else {
            throw new RuntimeException("El presupuesto anual es insuficiente para los salarios.");
        }
    }

    @Override
    public void borrar(Long id) {
        obtenerPorId(id);
        departamentoRepository.deleteById(id);
    }

    @Override
    public boolean existeDepartamentoPorNombre(String nombre) {
        return departamentoRepository.existsByNombre(nombre);
    }

    public List<Empleado> obtenerEmpleadosPorDepartamento(Long idDepartamento) {
        Optional<Departamento> departamentoOpt = departamentoRepository.findById(idDepartamento);

        if (departamentoOpt.isPresent()) {
            Departamento departamento = departamentoOpt.get();
            return departamento.getEmpleados(); 
        } else {
            throw new RuntimeException("Departamento no encontrado con ID: " + idDepartamento);
        }
    }


    public boolean presupuestoValido(Departamento departamento) {
        System.out.println("---------------HOLIII---------------");
        if (obtenerEmpleadosPorDepartamento(departamento.getId()) != null) {
            double totalSalarios = obtenerEmpleadosPorDepartamento(departamento.getId()).stream()
                    .mapToDouble(Empleado::getSalario)
                    .sum();

            System.out.println("------------------------------" + totalSalarios);
            System.out.println("------------------------------" + departamento.getPresupuestoAnual());
            System.out.println("------------------------------" + (totalSalarios <= departamento.getPresupuestoAnual()));

            return totalSalarios <= departamento.getPresupuestoAnual();
        } else return true;
    }
}
