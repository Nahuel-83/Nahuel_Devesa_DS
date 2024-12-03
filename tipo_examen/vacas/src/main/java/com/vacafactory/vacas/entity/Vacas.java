package com.vacafactory.vacas.entity;


public class Vacas {
    private Integer id;
    private String nombre;
    private String fechaNac;
    private Double peso;

    public Vacas(Integer id, String nombre, String fechaNac, Double peso) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }


}
