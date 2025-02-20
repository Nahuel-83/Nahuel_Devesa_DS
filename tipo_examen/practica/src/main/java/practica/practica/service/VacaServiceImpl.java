package practica.practica.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import practica.practica.model.Vaca;
import practica.practica.repository.VacaRepository;

@Service
@RequiredArgsConstructor
public class VacaServiceImpl implements VacaService {

    private final VacaRepository vacaRepository;

     @Override
    public List<Vaca> getAllVacas() {
        return vacaRepository.findAll();
    }

    @Override
    public Vaca getVacaById(Long id) {
        return vacaRepository.findById(id).orElse(null);
    }

    @Override
    public Vaca createVaca(Vaca vaca) {
        // Validar que la fecha de nacimiento no sea en el futuro
        if (vaca.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
        }

        // Validar que el peso sea positivo
        if (vaca.getPeso() <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo.");
        }

        // Validar que la foto de perfil no esté vacía
        if (vaca.getFotoPerfil() == null || vaca.getFotoPerfil().isEmpty()) {
            throw new IllegalArgumentException("La foto de perfil no puede estar vacía.");
        }

        return vacaRepository.save(vaca);
    }

    @Override
    public Vaca updateVaca(Long id, Vaca vaca) {
        Vaca existingVaca = vacaRepository.findById(id).orElse(null);
        if (existingVaca != null) {
            // Validar que la fecha de nacimiento no sea en el futuro
            if (vaca.getFechaNacimiento().isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
            }

            // Validar que el peso sea positivo
            if (vaca.getPeso() <= 0) {
                throw new IllegalArgumentException("El peso debe ser un valor positivo.");
            }

            // Validar que la foto de perfil no esté vacía
            if (vaca.getFotoPerfil() == null || vaca.getFotoPerfil().isEmpty()) {
                throw new IllegalArgumentException("La foto de perfil no puede estar vacía.");
            }

            existingVaca.setNombre(vaca.getNombre());
            existingVaca.setFechaNacimiento(vaca.getFechaNacimiento());
            existingVaca.setPeso(vaca.getPeso());
            existingVaca.setFotoPerfil(vaca.getFotoPerfil());
            return vacaRepository.save(existingVaca);
        }
        throw new IllegalArgumentException("No se encontró la vaca con ID: " + id);
    }

    @Override
    public void deleteVaca(Long id) {
        if (!vacaRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró la vaca con ID: " + id);
        }
        vacaRepository.deleteById(id);
    }
}