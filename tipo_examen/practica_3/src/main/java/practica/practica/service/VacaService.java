package practica.practica.service;

import java.util.List;

import practica.practica.model.Vaca;

public interface VacaService {
    List<Vaca> getAllVacas();
    Vaca getVacaById(Long id);
    Vaca createVaca(Vaca vaca);
    Vaca updateVaca(Long id, Vaca vaca);
    void deleteVaca(Long id);
    List<Vaca> searchVacasByName(String nombre);
}