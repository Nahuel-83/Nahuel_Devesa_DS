package practica.practica.service;

import java.util.List;

import practica.practica.model.Explotacion;

public interface ExplotacionService {
    List<Explotacion> getAllExplotaciones();
    Explotacion getExplotacionById(Long id);
    Explotacion createExplotacion(Explotacion explotacion);
    Explotacion updateExplotacion(Long id, Explotacion explotacion);
    public void deleteExplotacion(Long id);
}
