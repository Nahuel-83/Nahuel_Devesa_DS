package com.t04.e01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculosServiceImpl implements CalculosService{

    
    @Override
    public boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    @Override
    public double calcularHipotenusa(int cateto1, int cateto2) {
        return Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
    }

    @Override
    public List<Integer> obtenerDivisores(int numero) {
        List<Integer> divisores = new ArrayList<>();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) divisores.add(i);
        }
        return divisores;
    }
}
