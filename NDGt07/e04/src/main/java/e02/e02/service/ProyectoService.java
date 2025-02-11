package e02.e02.service;

import java.util.List;

import e02.e02.domain.Proyecto;

public interface ProyectoService {
    public List<Proyecto> findAll();

    public Proyecto findById(Long id);

    public Proyecto save(Proyecto proyecto);

    public void deleteById(Long id);
}
