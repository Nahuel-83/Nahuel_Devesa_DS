package e02.e02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import e02.e02.domain.Departamento;
import e02.e02.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento obtenerPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
    }

    public Departamento añadir(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento editar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void borrar(Long id) {
        departamentoRepository.deleteById(id);
    }
}
