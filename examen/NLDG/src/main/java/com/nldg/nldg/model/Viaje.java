package com.nldg.nldg.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "viaje")
public class Viaje {
    @Id
    private Long id;

    @Column(name = "destino", nullable = false, length = 100)
    private String destino;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "fecha", nullable = false) 
    private LocalDate fecha;

    @Column(name = "descripcion", length = 500) 
    private String descripcion;

    public Viaje() {
    }

    public Viaje(Long id, String destino, Integer duracion, LocalDate fecha, String descripcion) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
