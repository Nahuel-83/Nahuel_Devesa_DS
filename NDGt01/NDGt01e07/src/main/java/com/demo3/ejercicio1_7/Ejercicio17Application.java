package com.demo3.ejercicio1_7;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejercicio17Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio17Application.class, args);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce un String:");
        String input = scanner.nextLine();

		Map<Character, Integer> frecuenciaLetras = contarLetras(input);

        mostrarLetras(frecuenciaLetras);

	}


	 private static Map<Character, Integer> contarLetras(String input) {
        Map<Character, Integer> frecuenciaLetras = new TreeMap<>();
        
        input = input.toLowerCase();
        
        for (char c : input.toCharArray()) {
           
            if (Character.isLetter(c)) {
                frecuenciaLetras.put(c, frecuenciaLetras.getOrDefault(c, 0) + 1);
            }
        }
        
        return frecuenciaLetras;
    }

	private static void mostrarLetras(Map<Character, Integer> frecuenciaLetras) {
        System.out.println("Frecuencia de cada letra (ordenada alfabéticamente):");
        for (Map.Entry<Character, Integer> entry : frecuenciaLetras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
