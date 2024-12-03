package com.nldg.nldg.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.nldg.nldg.model.Viaje;

@Service
public interface ViajeService {
    void guardarViajes(Integer id,String destino, Integer duracion, LocalDate fecha, String descripcion);

    void eliminarViajes(Integer id);

    ArrayList<Viaje> listarViajes();

    String getError();
}
