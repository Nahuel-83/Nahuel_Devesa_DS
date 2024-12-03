package com.libreria.libros.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.libreria.libros.model.Libro;

@Service
public interface LibroService {
    void guardarLibro(String titulo, String autor, String genero, Integer anoPubli);

    void eliminarLibro(String titulo);

    ArrayList<Libro> listarLibros();

    String getError();
}
