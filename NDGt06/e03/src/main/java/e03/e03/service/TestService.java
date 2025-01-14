package e03.e03.service;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

import e03.e03.model.Pregunta;
import jakarta.annotation.PostConstruct;

@Service
public class TestService {
    private List<Pregunta> preguntas = new ArrayList<>();
    private int preguntaActualIndex = 0;
    private int puntaje = 0;

    @PostConstruct
    public void init() {
        try {
            ClassPathResource resource = new ClassPathResource("test.csv");  // Asegúrate de que este archivo esté en /resources
            try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {
                String[] line;
                while ((line = reader.readNext()) != null) {
                    String[] respuestas = {line[2], line[3], line[4], line[5]};
                    preguntas.add(new Pregunta(
                        Integer.parseInt(line[0]),  // Número de pregunta
                        line[1],                    // Texto de la pregunta
                        respuestas,                 // Respuestas
                        Integer.parseInt(line[6])   // Índice de la respuesta correcta (1-4)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pregunta getPreguntaActual() {
        if (preguntaActualIndex < preguntas.size()) {
            return preguntas.get(preguntaActualIndex);
        }
        return null;
    }

    public void responderPregunta(int respuestaSeleccionada) {
        if (getPreguntaActual().getRespuestaCorrecta() == respuestaSeleccionada) {
            puntaje++;
        }
        preguntaActualIndex++;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void resetearTest() {
        preguntaActualIndex = 0;
        puntaje = 0;
    }

    public int getTotalPreguntas() {
        return preguntas.size();
    }
}
