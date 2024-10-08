package com.demo4.ejercicio1_3;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo4.ejercicio1_3.Entity.Hotel;

@SpringBootApplication
public class Ejercicio13Application {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio13Application.class, args);

        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Listar habitaciones libres");
            System.out.println("4. Listar habitaciones ocupadas");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Número de habitación para check-in: ");
                    int numeroCheckIn = scanner.nextInt();
                    hotel.checkIn(numeroCheckIn);
                    break;
                case 2:
                    System.out.print("Número de habitación para check-out: ");
                    int numeroCheckOut = scanner.nextInt();
                    hotel.checkOut(numeroCheckOut);
                    break;
                case 3:
                    hotel.listarHabitacionesLibres();
                    break;
                case 4:
                    hotel.listarHabitacionesOcupadas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
