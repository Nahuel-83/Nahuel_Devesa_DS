package e03.e03.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import e03.e03.model.Pregunta;


@Service
public class TestServiceImpl {
    private final List<Pregunta> preguntas = new ArrayList<>();
    private int puntaje = 0;

    public TestServiceImpl() {
        cargarPreguntas("src/main/resources/static/preguntas.csv");
    }

    private void cargarPreguntas(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 7) {
                    int numero = Integer.parseInt(partes[0]);
                    String texto = partes[1];
                    String[] respuestas = new String[]{partes[2], partes[3], partes[4], partes[5]};
                    int correcta = Integer.parseInt(partes[6]);
                    preguntas.add(new Pregunta(numero, texto, respuestas, correcta));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar las preguntas: " + e.getMessage());
        }
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public Pregunta getPregunta(int numero) {
        return preguntas.get(numero - 1);
    }

    public void verificarRespuesta(int numeroPregunta, int respuestaUsuario) {
        Pregunta pregunta = preguntas.get(numeroPregunta - 1);
        if (pregunta.getCorrecta() == respuestaUsuario) {
            puntaje++;
        }
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void reiniciarTest() {
        puntaje = 0;
    }
}
