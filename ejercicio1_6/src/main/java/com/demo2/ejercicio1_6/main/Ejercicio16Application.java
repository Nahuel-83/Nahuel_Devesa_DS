package com.demo2.ejercicio1_6;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo2.ejercicio1_6.entity.Primitiva;

@SpringBootApplication
public class Ejercicio16Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16Application.class, args);

		Scanner scanner = new Scanner(System.in);
        Primitiva primitiva = new Primitiva();

        System.out.println("Combinación generada: " + primitiva);

        Set<Integer> combinacionUsuario = new HashSet<>();
        while (combinacionUsuario.size() < 6) {
            System.out.println("Introduce tu combinación (6 números entre 1 y 49, sin repetir):");
            try {
                System.out.print("Introduce un número: ");
                int numero = scanner.nextInt();

                
                if (numero < 1 || numero > 49) {
                    System.out.println("Número fuera del rango. Debe estar entre 1 y 49.");
                } else if (combinacionUsuario.contains(numero)) {
                    System.out.println("Número repetido. Por favor, introduce un número diferente.");
                } else {
                    combinacionUsuario.add(numero);
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                scanner.next(); 
            }
        }

        int aciertos = primitiva.contarAciertos(combinacionUsuario);
        System.out.println("Número de aciertos: " + aciertos);
    }

}