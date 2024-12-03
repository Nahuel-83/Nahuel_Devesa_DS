package com.videoclip.videoclip.service;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.videoclip.videoclip.model.Videoclip;

@Service
@Scope("session")
public class VideoclipServiceImpl implements VideoclipService {

    private ArrayList<Videoclip> videoclips = new ArrayList<>();
    private String error = null;

    @Override
    public void eliminarVideoclip(String titulo) {
        Videoclip videoclipEliminar = null;
        for (Videoclip videoclip : videoclips) {
            if (videoclip.getTitulo().equals(titulo)) {
                videoclipEliminar = videoclip;
                break;
            }
        }

        if (videoclipEliminar != null) {
            videoclips.remove(videoclipEliminar);
            error = null;
        } else {
            error = "No se encontró el videclip";
        }

    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public void guardarVideoclip(String titulo, String autor, String genero, Integer anoPubli, String url) {
        for (Videoclip videoclip : videoclips) {
            if (videoclip.getTitulo().equals(titulo)) {
                error = "Lo siento, este videclip ya existe.";
                return;
            }
        }

        if (genero.isBlank() || genero == null) {
            genero = "Sin genero";
        }

        if (anoPubli != null) {
            anoPubli = -1;
        }

        if (url != null){
            url = "URL desconocida";
        }

        Videoclip videoclipNuevo = new Videoclip(titulo, autor, genero, anoPubli, url);
        videoclips.add(videoclipNuevo);
        error = null;

    }

    @Override
    public ArrayList<Videoclip> listarVideoclips() {
        return videoclips;
    }

}
