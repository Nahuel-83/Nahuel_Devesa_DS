package e02.e02.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import e02.e02.domain.Nomina;
import e02.e02.repository.NominaRepository;

@Service
public class NominaServiceImpl implements NominaService {
    private final NominaRepository nominaRepository;

    public NominaServiceImpl(NominaRepository nominaRepository) {
        this.nominaRepository = nominaRepository;
    }

    public List<Nomina> obtenerTodas() {
        return nominaRepository.findAll();
    }

    public boolean existeNomina(Long empleadoId, LocalDate fecha) {
        return nominaRepository.findByEmpleadoIdAndFecha(empleadoId, fecha).isPresent();
    }

    public void guardarNomina(Nomina nomina) {
        if (!existeNomina(nomina.getEmpleado().getId(), nomina.getFecha())) {
            nominaRepository.save(nomina);
        }
    }
}
