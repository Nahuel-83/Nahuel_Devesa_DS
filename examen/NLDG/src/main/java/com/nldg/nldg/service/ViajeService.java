package com.nldg.nldg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nldg.nldg.model.Viaje;

@Service
public interface ViajeService {
    void guardarViajes(Long id,String destino, Integer duracion, LocalDate fecha, String descripcion);

    void eliminarViajes(Long id);

    List<Viaje> listarViajes();

    String getError();
}
