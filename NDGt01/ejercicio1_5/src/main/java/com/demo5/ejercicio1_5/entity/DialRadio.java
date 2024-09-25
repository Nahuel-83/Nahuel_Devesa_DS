package com.demo5.ejercicio1_5.entity;

public class DialRadio extends Objeto{
    float dial;

    public DialRadio(){
        dial = 88.0f;
    }

    
    @Override
    public Boolean subir() {
        if (dial < 104.00f) {
            dial += 0.1f;
            return true;
        }
        return false;
    }

    @Override
    public Boolean bajar() {
        if (dial > 88.0f) {
            dial -= 0.1f;
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        dial = 88.0f;
    }

    @Override
    public String verEstado() {
        return "Radio: \nLa dial de la radio esta a " + dial;
    }
    
}
