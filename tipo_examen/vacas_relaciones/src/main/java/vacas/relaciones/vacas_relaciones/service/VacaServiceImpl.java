package vacas.relaciones.vacas_relaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vacas.relaciones.vacas_relaciones.model.Vacas;
import vacas.relaciones.vacas_relaciones.repository.VacaRepository;

@Service
@RequiredArgsConstructor
public class VacaServiceImpl implements VacaService {
    private final VacaRepository vacaRepository;

    @Override
    public List<Vacas> listarVacas() {
        return vacaRepository.findAll();
    }

    @Override
    public Vacas obtenerPorId(Long id) throws RuntimeException {
        return vacaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Override
    public Vacas guardarVaca(Vacas vaca) {
        return vacaRepository.save(vaca);
    }

    @Override
    public Vacas actualizarVaca(Vacas vaca) {
        return vacaRepository.save(vaca);
    }

    @Override
    public void eliminarVaca(Long id) {
        vacaRepository.deleteById(id);
    }

    @Override
    public List<Vacas> buscarPorNombre(String nombre) {
        return vacaRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
