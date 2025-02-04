package e04.e04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import e04.e04.model.Paciente;
import e04.e04.model.PacienteDTO;

@Service
public interface PacienteService {
    void add(Paciente paciente);

    void deleteFirst();

    Paciente getFirst();

    List<Paciente> findAll();

    Paciente buildPacienteFromDTO(PacienteDTO pacienteDTO);

    Double factura (Paciente paciente);
}
