package com.e02.e02.services;

public interface DateService {
    long calcularDiasEntreFechas(String fecha1, String fecha2);

    String listarAniosBisiestos(String fecha1, String fecha2);

    int contarDomingos(String fecha1, String fecha2);
}
