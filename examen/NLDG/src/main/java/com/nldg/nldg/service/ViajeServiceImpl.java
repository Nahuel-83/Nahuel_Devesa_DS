package com.nldg.nldg.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.nldg.nldg.model.Viaje;

@Service
@Scope("session")
public class ViajeServiceImpl implements ViajeService {

    private ArrayList<Viaje> viajes = new ArrayList<>();
    private String error = null;

    @Override
    public void eliminarViajes(Integer id) {
        Viaje viajeEliminar = null;
        for (Viaje viaje : viajes) {
            if (viaje.getId().equals(id)) {
                viajeEliminar = viaje;
                break;
            }
        }

        if (viajeEliminar != null) {
            viajes.remove(viajeEliminar);
            error = null;
        } else {
            error = "No se encontró el videclip";
        }

    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public void guardarViajes(Integer id,String destino, Integer duracion, LocalDate fecha, String descripcion) {
        for (Viaje viaje : viajes) {
            if (viaje.getId().equals(id)) {
                error = "Lo siento, este viaje no puede tener el mismo id que otro viaje, mire en el listado de viajes par obtener un numero apto";
                return;
                
            }
        }

        if (descripcion.isBlank() || descripcion == null) {
            descripcion = "Sin descripcion";
        }

        if (id == null) {
            error = "El id no puede estar vacio";
            return;
        }

        if (destino == null || destino.isEmpty()) {
            error = "El destino no puede estar vacio";
            return;
        }

        if (duracion == null) {
            error = "La duracion no puede estar vacia";
            return;
        }

        if (fecha == null) {
            error = "La fecha no puede estar vacia";
            return;
        }

        if (id <= 0) {
            error = "El id no puede ser igual o menor a 0";
            return;
        }

        if (duracion <= 0) {
            error = "La duracion no puede ser igual o menor a 0";
            return;
        }

        LocalDate diaHoy = LocalDate.now() ;
        
        if (fecha.isBefore(diaHoy)) {
            error = "La fecha no puedo ser antes que la fecha de hoy";
            return;
        }

        Viaje viajeNuevo = new Viaje(id, destino, duracion, fecha, descripcion);
        viajes.add(viajeNuevo);
        error = null;

    }

    @Override
    public ArrayList<Viaje> listarViajes() {
        return viajes;
    }

}
