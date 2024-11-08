package com.example.app;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.app.model.EstadoJuego;
import com.example.app.model.Intento;
import com.example.app.model.MasterMind;

@Service
@Scope("session")
public class MasterMindService {

    public MasterMind masterMind;
    private String errorMessage;


    public void nuevoJuego(int intentos, int digitos) {
        masterMind = new MasterMind(digitos, intentos);
        do {
            masterMind.setNumeroSecreto(cadenaAlAzar(masterMind.getTamNumero()));
        } while (cadenaConDuplicados(masterMind.getNumeroSecreto()));
        masterMind.getListaIntentos().clear();
        masterMind.setEstadoJuego(EstadoJuego.JUGANDO);
        System.out.println("=====> Num secreto: " + masterMind.getNumeroSecreto()); // solo para testing
        
        this.errorMessage = null;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean comprobarIntento(String intento) {

        errorMessage = null;

        if (intento.length() != masterMind.getTamNumero()) {
            errorMessage = "Error: La longitud del número debe ser de " + masterMind.getTamNumero() + " dígitos.";
            return false;
        }

        if (!intento.matches("\\d+")) {
            errorMessage = "Error: Solo se permiten dígitos numéricos.";
            return false;
        }

        if (cadenaConDuplicados(intento)) {
            errorMessage = "Error: El número no debe tener dígitos repetidos.";
            return false;
        }

        if (yaIntentado(intento)) {
            errorMessage = "Error: Ya has intentado este número.";
            return false;
        }

        if (masterMind.getEstadoJuego() != EstadoJuego.JUGANDO) {
            errorMessage = "Error: El juego ya ha terminado. Por favor, inicia un nuevo juego.";
            return false;
        }
        if (intento.length() != masterMind.getTamNumero()) {
            errorMessage = "Error: La longitud del número debe ser de " + masterMind.getTamNumero() + " dígitos.";
            return false;
        }

        int bienColocados = 0, malColocados = 0;
        String numeroSecreto = masterMind.getNumeroSecreto();
        for (int cont = 0; cont < intento.length(); cont++) {
            char letra = intento.charAt(cont);
            if (letra == numeroSecreto.charAt(cont))
                bienColocados++;
            else if (numeroSecreto.indexOf(letra) != -1)
                malColocados++;
        }
        masterMind.getListaIntentos().add(new Intento(intento, bienColocados, malColocados));
        if (bienColocados == masterMind.getTamNumero())
            masterMind.setEstadoJuego(EstadoJuego.GANO);
        if (masterMind.getListaIntentos().size() >= masterMind.getMaxIntentos())
            masterMind.setEstadoJuego(EstadoJuego.PERDIO);

        return true;
    }
    
    private boolean yaIntentado(String intento) {
        return masterMind.getListaIntentos().stream()
                .anyMatch(previo -> previo.getCombinacion().equals(intento));
    }

    private boolean cadenaConDuplicados(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            char c = cad.charAt(i);
            if (cad.indexOf(c, i + 1) != -1)
                return true;
        }
        return false;
    }

    private String cadenaAlAzar(int tamanho) {
        Random random = new Random();
        String cad = "";
        int x;
        for (int i = 0; i < tamanho; i++) {
            x = random.nextInt(10);
            cad += Integer.toString(x);
        }
        return cad;
    }
}
