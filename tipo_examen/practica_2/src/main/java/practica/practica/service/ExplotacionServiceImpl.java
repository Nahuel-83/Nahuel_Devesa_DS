package practica.practica.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import practica.practica.model.Explotacion;
import practica.practica.repository.ExplotacionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExplotacionServiceImpl implements ExplotacionService {

    private final ExplotacionRepository explotacionRepository;

    @Override
    public List<Explotacion> getAllExplotaciones() {
        return explotacionRepository.findAll();
    }

    @Override
    public Explotacion getExplotacionById(Long id) {
        return explotacionRepository.findById(id).orElse(null);
    }

    @Override
    public Explotacion createExplotacion(Explotacion explotacion) {
        return explotacionRepository.save(explotacion);
    }

    @Override
    public Explotacion updateExplotacion(Long id, Explotacion explotacion) {
        Explotacion existingExplotacion = explotacionRepository.findById(id).orElse(null);
        if (existingExplotacion != null) {
            existingExplotacion.setCif(explotacion.getCif());
            existingExplotacion.setNombreEmpresa(explotacion.getNombreEmpresa());
            existingExplotacion.setCalleUbicacion(explotacion.getCalleUbicacion());
            return explotacionRepository.save(existingExplotacion);
        }
        return null;
    }

    @Override
    public void deleteExplotacion(Long id) {
        explotacionRepository.deleteById(id);
    }
}
