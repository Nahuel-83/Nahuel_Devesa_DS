package com.demo5.ejercicio1_5.entity;

import java.time.LocalDate;

public class Calefacion extends Objeto{
    private int grados;
    private LocalDate revison;

    public Calefacion() {
        grados = 20;
        revison = null;
    }

    @Override
    public Boolean subir() {
        if (grados < 80) {
            grados++;
            return true;
        }
        return false;
    }

    @Override
    public Boolean bajar() {
        if (grados > 15) {
            grados--;
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        grados = 20;
        
    }

    public void revisar() {
        revison = LocalDate.now();
    }


    @Override
    public String verEstado() {
        return "Termostato: \nTemperatura actual es de " + grados + "º \nLa ultima revisión es el la fecha " + revison;
    } 
}
