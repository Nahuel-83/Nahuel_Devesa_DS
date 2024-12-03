package com.videoclip.videoclip.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.videoclip.videoclip.model.Videoclip;

@Service
public interface VideoclipService {
    void guardarVideoclip(String titulo, String autor, String genero, Integer anoPubli, String url);

    void eliminarVideoclip(String titulo);

    ArrayList<Videoclip> listarVideoclips();

    String getError();
}
