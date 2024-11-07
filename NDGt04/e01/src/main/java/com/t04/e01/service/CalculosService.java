package com.t04.e01.service;

import java.util.List;

public interface CalculosService {
    boolean esPrimo(int numero);
    double calcularHipotenusa(int cateto1, int cateto2);
    List<Integer> obtenerDivisores(int numero);
}