package vacas.relaciones.vacas_relaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vacas.relaciones.vacas_relaciones.model.Vacas;
import vacas.relaciones.vacas_relaciones.repository.VacaRepository;

@Service
@RequiredArgsConstructor
public class VacaServiceImpl implements VacaService{
private final VacaRepository vacaRepository;

    public List<Vacas> listarVacas() {
        return vacaRepository.findAll();
    }

    public Optional<Vacas> obtenerVacaPorId(Long id) {
        return vacaRepository.findById(id);
    }

    public Vacas guardarVaca(Vacas vaca) {
        return vacaRepository.save(vaca);
    }

    public Vacas actualizarVaca(Vacas vaca) {
        return vacaRepository.save(vaca);
    }

    public void eliminarVaca(Long id) {
        vacaRepository.deleteById(id);
    }

    public List<Vacas> buscarPorNombre(String nombre) {
        return vacaRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
