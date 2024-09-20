package com.demo4.ejercicio1_3.Service;

import java.time.LocalDate;

import com.demo4.ejercicio1_3.Entity.Habitacion;

public class Doble extends Habitacion{
    
    private static final Double precioDia = 100.0;

    public Doble(int num){
        super(num);
    }

    @Override
    public double calcularPrecio(long diasEstancia){
        double tarifaFin = precioDia * diasEstancia;
        
        LocalDate fechaSalida = checkIn.plusDays(diasEstancia);
        int mesSalida = fechaSalida.getMonthValue();
        if (mesSalida == 4 || mesSalida == 7 || mesSalida == 8) {
            tarifaFin *= 1.2;
        }
        return tarifaFin;
    }
}
