package e02.e02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import e02.e02.domain.Proyecto;
import e02.e02.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements ProyectoService{

    private final ProyectoRepository proyectoRepository;

    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    public Proyecto findById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void deleteById(Long id) {
        proyectoRepository.deleteById(id);
    }
}
