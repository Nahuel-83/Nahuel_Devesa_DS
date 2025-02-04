package e04.e04.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e04.e04.config.Tarifas;
import e04.e04.model.Paciente;
import e04.e04.model.PacienteConsulta;
import e04.e04.model.PacienteDTO;
import e04.e04.model.PacienteReceta;
import e04.e04.model.PacienteRevision;

@Service
public class PacienteServiceImpl implements PacienteService {
    List<Paciente> reposirio = new ArrayList<>();

    @Autowired
    Tarifas tarifas;

    public void add(Paciente paciente) {
        reposirio.add(paciente);
    }

    public void deleteFirst() {
        if (reposirio.size() > 0)
            reposirio.remove(0);
    }

    public Paciente getFirst() {
        if (reposirio.size() > 0)
            return reposirio.get(0);
        return null;
    }

    public List<Paciente> findAll() {
        return reposirio;
    }

    @Override
    public Double factura(Paciente paciente) {
        if (paciente != null) {
            return paciente.facturar(tarifas);
        } else {
            return 0d;
        }

    }

    public Paciente buildPacienteFromDTO(PacienteDTO pacienteDTO) {
        Paciente paciente;
        switch (pacienteDTO.getTipoPaciente()) {
            case 1 -> { 
                paciente = new PacienteConsulta();
                ((PacienteConsulta) paciente).setMotivoConsulta(pacienteDTO.getMotivoConsulta());
            }
            case 2 -> { // PacienteReceta
                paciente = new PacienteReceta();
                String[] med = pacienteDTO.getListaMedicamentos().split(",");
                ((PacienteReceta) paciente).setListaMedicamentos(Arrays.asList(med));
            }
            case 3 -> { // PacienteRevision
                paciente = new PacienteRevision();
                ((PacienteRevision) paciente).setFechaUltimaRevision(pacienteDTO.getFechaUltimaRevision());
            }
            default -> throw new IllegalArgumentException("Tipo de paciente no válido: " + pacienteDTO.getTipoPaciente());
        }
    
        paciente.setDni(pacienteDTO.getDni());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
    
        return paciente;
    }
    
}
