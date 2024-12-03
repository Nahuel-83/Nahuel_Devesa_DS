package com.libreria.libros.services;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.libreria.libros.model.Libro;

@Service
@Scope("session")
public class LibroServiceImpl implements LibroService {

    private ArrayList<Libro> libros = new ArrayList<>();
    private String error = null;

    @Override
    public void eliminarLibro(String titulo) {
        Libro libroEliminar = null;
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libroEliminar = libro;
                break;
            }
        }

        if (libroEliminar != null) {
            libros.remove(libroEliminar);
            error = null;
        } else {
            error = "No se encontró el libro";
        }

    }

    @Override
    public void guardarLibro(String titulo, String autor, String genero, Integer anoPubli) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                error = "Lo siento, este libro ya existe.";
                return;
            }
        }

        if (genero.isBlank() || genero == null) {
            genero = "Sin genero";
        }

        if (anoPubli != null) {
            anoPubli = -1;
        }

        Libro libroNuevo = new Libro(titulo, autor, genero, anoPubli);
        libros.add(libroNuevo);
        error = null;
    }

    @Override
    public ArrayList<Libro> listarLibros() {
        return libros;
    }

    @Override
    public String getError() {
        return error;
    }
}
