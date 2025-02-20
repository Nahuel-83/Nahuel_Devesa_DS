package practica.practica.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import practica.practica.model.Explotacion;
import practica.practica.model.Vaca;
import practica.practica.repository.ExplotacionRepository;
import practica.practica.repository.VacaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExplotacionServiceImpl implements ExplotacionService {

    private final ExplotacionRepository explotacionRepository;
    private final VacaRepository vacaRepository;

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
    Explotacion explotacion = explotacionRepository.findById(id).orElse(null);
    if (explotacion != null) {
        // Quitar la explotación de todas las vacas asociadas
        for (Vaca vaca : explotacion.getVacas()) {
            vaca.getExplotaciones().remove(explotacion);
            vacaRepository.save(vaca); // Guardar la vaca después de remover la explotación
        }

        // Eliminar la explotación de la base de datos
        explotacionRepository.deleteById(id);
    } else {
        throw new IllegalArgumentException("Explotación no encontrada con ID: " + id);
    }
}

}
