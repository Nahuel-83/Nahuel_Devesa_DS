package e09.e09.service;

import e09.e09.model.Equipo;
import e09.e09.model.Jornada;

import java.util.List;

public interface LigaService {
    List<Equipo> getClasificacion();
    List<Jornada> getJornadas();
    void simularJornada();
}