package com.demo2.ejercicio1_6.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Primitiva {
    Set<Integer> numerosPrimitiva = new HashSet<>();
    public Primitiva() {
        Random random = new Random();
        
        while (numerosPrimitiva.size() < 6) {
            int numeroRandom = random.nextInt(49) +1;
            numerosPrimitiva.add(numeroRandom);
        }

        Collections.sort(numerosPrimitiva);

    }

    public int contarAciertos(Set<Integer> combinacionJugada) {
        Set<Integer> copia = new HashSet<>(numerosPrimitiva);
        copia.retainAll(combinacionJugada); // Retiene solo los elementos comunes
        return copia.size();
    }
    
}
