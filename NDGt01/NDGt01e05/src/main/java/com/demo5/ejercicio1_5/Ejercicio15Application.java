package com.demo5.ejercicio1_5;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo5.ejercicio1_5.entity.Ascensor;
import com.demo5.ejercicio1_5.entity.Calefacion;
import com.demo5.ejercicio1_5.entity.DialRadio;
import com.demo5.ejercicio1_5.entity.Objeto;

@SpringBootApplication
public class Ejercicio15Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio15Application.class, args);

		ArrayList<Objeto> dispositivos = new ArrayList<>();
		dispositivos.add(new Calefacion());
		dispositivos.add(new Ascensor());
		dispositivos.add(new DialRadio());

		Scanner sc = new Scanner(System.in);

		int opcion;

		do {
			mostrarEstadoDispositivos(dispositivos);
            System.out.println("\n¿Qué operación desea realizar?");
            System.out.println("0: Salir");
            System.out.println("1: Subir un dispositivo");
            System.out.println("2: Bajar un dispositivo");
            System.out.println("3: Resetear un dispositivo");
            System.out.println("4: Revisar termostato");

			opcion = sc.nextInt();
            if (opcion == 0) break;
            
            if (opcion >= 1 && opcion <= 3) {
                System.out.println("Seleccione el dispositivo (0 - " + (dispositivos.size() - 1) + "):");
                int dispositivoIndex = sc.nextInt();

                if (dispositivoIndex < 0 || dispositivoIndex >= dispositivos.size()) {
                    System.out.println("Índice de dispositivo no válido.");
                    continue;
                }

                Objeto dispositivo = dispositivos.get(dispositivoIndex);
                switch (opcion) {
                    case 1:
                        if (dispositivo.subir()) {
                            System.out.println("No se puede subir más el dispositivo.");
                        }
                        break;
                    case 2:
                        if (dispositivo.bajar()) {
                            System.out.println("No se puede bajar más el dispositivo.");
                        }
                        break;
                    case 3:
                        dispositivo.reset();
                        break;
                }
            } else if (opcion == 4) {
                if (dispositivos.get(0) instanceof Calefacion) {
                    ((Calefacion) dispositivos.get(0)).revisar();
                    System.out.println("El termostato ha sido revisado.");
                }
            }
		} while (opcion != 0);
	}

	private static void mostrarEstadoDispositivos(ArrayList<Objeto> dispositivos) {
        System.out.println("\nEstado de los dispositivos:");
        for (int i = 0; i < dispositivos.size(); i++) {
            System.out.println(i + ": " + dispositivos.get(i).verEstado());
        }
    }

}
