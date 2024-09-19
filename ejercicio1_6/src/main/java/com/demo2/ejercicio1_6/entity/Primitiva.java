package com.demo2.ejercicio1_6.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Primitiva {
    Set<Integer> numerosPrimitiva = new HashSet<>();
    public Primitiva() {
        Random random = new Random();
        
        while (numerosPrimitiva.size() < 6) {
            int numeroRandom = random.nextInt(49) +1;
            numerosPrimitiva.add(numeroRandom);
        }

    }

    public List<Integer> getNumerosPrimitivaOrdenados() {
        List<Integer> lista = new ArrayList<>(numerosPrimitiva);
        Collections.sort(lista);
        return lista;
    }

    public int contarAciertos(Set<Integer> combinacionJugada) {
        Set<Integer> copia = new HashSet<>(numerosPrimitiva);
        copia.retainAll(combinacionJugada); // Retiene solo los elementos comunes
        return copia.size();
    }

    public Set<Integer> obtenerCombinacionUsuario() {
        Scanner scanner = new Scanner(System.in);
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
                scanner.next(); // Limpiar el buffer del scanner
            }
        }

        return combinacionUsuario;
    }
    
}
