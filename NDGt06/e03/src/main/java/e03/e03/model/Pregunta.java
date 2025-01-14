package e03.e03.model;

import lombok.Data;

@Data
public class Pregunta {
    private int numero;
    private String texto;
    private String[] respuestas;
    private int respuestaCorrecta;

    public Pregunta(int numero, String texto, String[] respuestas, int respuestaCorrecta) {
        this.numero = numero;
        this.texto = texto;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
