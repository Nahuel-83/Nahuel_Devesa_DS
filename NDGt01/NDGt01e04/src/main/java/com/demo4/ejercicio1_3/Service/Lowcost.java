package com.demo4.ejercicio1_3.Service;


import com.demo4.ejercicio1_3.Entity.Habitacion;

public class Lowcost extends Habitacion{
    
    private static final Double precioDia = 50.0;

    public Lowcost(int num){
        super(num);
    }

    
    @Override
    public double calcularPrecio(long diasEstancia) {
        return precioDia * diasEstancia;
    }

}
