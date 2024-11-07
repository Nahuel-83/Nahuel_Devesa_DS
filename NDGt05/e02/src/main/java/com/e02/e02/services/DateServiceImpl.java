package com.e02.e02.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DateServiceImpl implements DateService{

    @Override
    public long calcularDiasEntreFechas(String fecha1, String fecha2) {
        LocalDate date1 = LocalDate.parse(fecha1); 
        LocalDate date2 = LocalDate.parse(fecha2);
        return ChronoUnit.DAYS.between(date1, date2);
    }

    @Override
    public String listarAniosBisiestos(String fecha1, String fecha2) {
        LocalDate startDate = LocalDate.parse(fecha1); 
        LocalDate endDate = LocalDate.parse(fecha2); 
        List<Integer> bisiestos = new ArrayList<>();

        for (int year = startDate.getYear(); year <= endDate.getYear(); year++) {
            if (LocalDate.of(year, 1, 1).isLeapYear()) {
                bisiestos.add(year);
            }
        }

        return bisiestos.toString();
    }

    @Override
    public int contarDomingos(String fecha1, String fecha2) {
        LocalDate startDate = LocalDate.parse(fecha1);
        LocalDate endDate = LocalDate.parse(fecha2); 
        int count = 0;

        for (int year = startDate.getYear(); year <= endDate.getYear(); year++) {
            LocalDate firstOfJanuary = LocalDate.of(year, 1, 1);
            if (firstOfJanuary.getDayOfWeek().getValue() == 7) { // 7 = Domingo
                count++;
            }
        }

        return count;
    }
}
