package e03.e03.model;

public class Pregunta {
    private int numero;
    private String texto;
    private String[] respuestas;
    private int correcta;

    public Pregunta(int numero, String texto, String[] respuestas, int correcta) {
        this.numero = numero;
        this.texto = texto;
        this.respuestas = respuestas;
        this.correcta = correcta;
    }

    public int getNumero() {
        return numero;
    }

    public String getTexto() {
        return texto;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public int getCorrecta() {
        return correcta;
    }
}
