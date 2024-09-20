package com.demo4.ejercicio1_3.Entity;

import java.util.ArrayList;

import com.demo4.ejercicio1_3.Service.Doble;
import com.demo4.ejercicio1_3.Service.Lowcost;
import com.demo4.ejercicio1_3.Service.Suite;

public class Hotel {
    private ArrayList<Habitacion> habitaciones;

    public Hotel(){
        habitaciones = new ArrayList();


        for (int i = 1; i <= 3; i++){
            habitaciones.add(new Lowcost(i));
        }
        for (int i = 3; i <= 13; i++){
            habitaciones.add(new Doble(i));
        }
        for (int i = 13; i <= 18; i++){
            habitaciones.add(new Suite(i));
        }
    }

    public void checkIn(int numeroHabitacion) {
        Habitacion habitacion = buscarHabitacionPorNumero(numeroHabitacion);
        
        if (habitacion != null && !habitacion.getOcupada()) {
            habitacion.checkIn();  
            System.out.println("Check-in realizado correctamente para la habitación " + numeroHabitacion);
        } else {
            System.out.println("La habitación ya está ocupada o no existe.");
        }
    }

    public void checkOut(int numeroHabitacion) {
        Habitacion habitacion = buscarHabitacionPorNumero(numeroHabitacion);
        if (habitacion != null && habitacion.getOcupada()) {
            long diasEstancia = habitacion.checkOut();
            double importe = habitacion.calcularPrecio(diasEstancia);
            System.out.println("Check-out realizado. Estancia de " + diasEstancia + " días. Importe: " + importe + " euros.");
        } else {
            System.out.println("La habitación no está ocupada.");
        }
    }

    public void listarHabitacionesLibres() {
        System.out.println("Habitaciones libres:");
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.getOcupada()) {
                System.out.println(habitacion);
            }
        }
    }

    public void listarHabitacionesOcupadas() {
        System.out.println("Habitaciones ocupadas:");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getOcupada()) {
                System.out.println(habitacion);
            }
        }
    }

    private Habitacion buscarHabitacionPorNumero(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNum() == numero) {
                return habitacion;
            }
        }
        return null;
    }
}


