package com.demo5.ejercicio1_5.entity;

public class Ascensor extends Objeto{
    private int planta;

    public Ascensor() {
        this.planta = 0;
    }

    @Override
    public Boolean subir() {
        if (planta < 8) {
            planta++;
            return true;
        }
        return false;
    }

    @Override
    public Boolean bajar() {
        if (planta > 0) {
            planta--;
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        planta = 0;
    }

    @Override
    public String verEstado() {
        return "Ascensor: \nLa planta actual es " + planta;
    }
}
