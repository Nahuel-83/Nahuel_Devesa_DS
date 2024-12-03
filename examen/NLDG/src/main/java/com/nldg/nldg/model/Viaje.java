package com.nldg.nldg.model;

import java.time.LocalDate;

public class Viaje {
    private Integer id;
    private String destino;
    private Integer duracion;
    private LocalDate fecha;
    private String descripcion;
    
    public Viaje(Integer id, String destino, Integer duracion, LocalDate fecha, String descripcion) {
        this.id = id;
        this.destino = destino;
        this.duracion = duracion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
