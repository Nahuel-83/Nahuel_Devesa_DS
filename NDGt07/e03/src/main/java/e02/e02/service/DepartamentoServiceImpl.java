package e02.e02.service;

import e02.e02.domain.Departamento;
import e02.e02.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (departamento.presupuestoValido()) {
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
}