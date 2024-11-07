package com.example.e04.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraServicesImpl implements CalculadoraServices{

    public enum Estado {
        OPERANDO1, OPERANDO2, RESULTADO
    }

    private int operando1 = 0;
    private int operando2 = 0;
    private int resultado = 0;
    private Estado estado = Estado.OPERANDO1;

    

    public int getOperando1() {
        return operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public int getResultado() {
        return resultado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void addDigito(int num) {
        if (estado == Estado.OPERANDO1) {
            operando1 = operando1 * 10 + num;
        } else if (estado == Estado.OPERANDO2) {
            operando2 = operando2 * 10 + num;
        }
    }

    public void sumar() {
        if (estado == Estado.OPERANDO1) {
            estado = Estado.OPERANDO2;
        }
    }

    public void calcularResultado() {
        if (estado == Estado.OPERANDO2) {
            resultado = operando1 + operando2;
            estado = Estado.RESULTADO;
        }
    }

    public void clear() {
        operando1 = 0;
        operando2 = 0;
        resultado = 0;
        estado = Estado.OPERANDO1;
    }
}
