package vacas.relaciones.vacas_relaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vacas.relaciones.vacas_relaciones.model.Vacas;

@Service
public interface VacaService {

    public List<Vacas> listarVacas();

    Vacas obtenerPorId(Long id) throws RuntimeException;

    public Vacas guardarVaca(Vacas vaca);

    public Vacas actualizarVaca(Vacas vaca);

    public void eliminarVaca(Long id);

    public List<Vacas> buscarPorNombre(String nombre);
}
