package com.demo4.ejercicio1_3.Service;

import com.demo4.ejercicio1_3.Entity.Habitacion;

public class Suite extends Habitacion{
    
    private static final Double precioDia = 200.0;

    public Suite(int num){
        super(num);
    }

    @Override
    public double calcularPrecio(long diasEstancia){
        double precioFin = precioDia * diasEstancia;

        if (diasEstancia >= 10) {
            precioFin = precioFin * 0.8;
        }
        return precioFin;
    }

}
