package com.demo4.ejercicio1_3.Entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Habitacion {

    protected int num;
    protected Boolean ocupada;
    protected LocalDate checkIn;

    public Habitacion(int num){
        this.num = num;
        this.ocupada = false;
    }

    public long checkOut() {
        this.ocupada = false;

        LocalDate fechaSalida = LocalDate.now(); 
        
        long diasEstancia = java.time.temporal.ChronoUnit.SECONDS.between(checkIn, fechaSalida);
        
        return diasEstancia;
    }

    public void checkIn() {
        this.ocupada = true;
        this.checkIn = LocalDate.now(); 
    }

    public int getNum() {
        return num;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    @Override
    public String toString() {
        return "Habitación " + num + " (Ocupada: " + ocupada + ")";
    }

    public abstract double calcularPrecio(long diasEstancia);
    
    
}
