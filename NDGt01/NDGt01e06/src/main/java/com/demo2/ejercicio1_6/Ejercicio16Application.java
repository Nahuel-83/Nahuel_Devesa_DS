package com.demo2.ejercicio1_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo2.ejercicio1_6.entity.Primitiva;

@SpringBootApplication
public class Ejercicio16Application {

	public static void main(String[] args) {
        
		SpringApplication.run(Ejercicio16Application.class, args);
		
        Primitiva primitiva = new Primitiva();
    
        Set<Integer> combinacionUsuario = primitiva.obtenerCombinacionUsuario();

        List<Integer> listaCombinacionUsuario = new ArrayList<>(combinacionUsuario);
        Collections.sort(listaCombinacionUsuario);

        System.out.println("La primitiva ordenada es: " + primitiva.getNumerosPrimitivaOrdenados());

        System.out.println("Tu combinación (ordenada): " + listaCombinacionUsuario);

        int aciertos = primitiva.contarAciertos(combinacionUsuario);
        System.out.println("Número de aciertos: " + aciertos);
    }

}