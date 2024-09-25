package com.demo4.ejercicio1_3.Entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Habitacion {

    protected int num;
    protected Boolean ocupada;
    protected LocalDateTime checkIn;

    public Habitacion(int num){
        this.num = num;
        this.ocupada = false;
    }

    public long checkOut() {
        LocalDateTime checkOut = LocalDateTime.now();

        long segundos = ChronoUnit.SECONDS.between(checkIn, checkOut);
    
        return segundos; 
    }

    public void checkIn() {
        this.ocupada = true;
        this.checkIn = LocalDateTime.now(); 
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
