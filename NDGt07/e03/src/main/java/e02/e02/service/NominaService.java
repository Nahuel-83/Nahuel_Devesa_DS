package e02.e02.service;

import e02.e02.domain.Nomina;
import java.time.LocalDate;
import java.util.List;

public interface NominaService {

    List<Nomina> obtenerTodas();

    boolean existeNomina(Long empleadoId, LocalDate fecha);

    void guardarNomina(Nomina nomina); 
}