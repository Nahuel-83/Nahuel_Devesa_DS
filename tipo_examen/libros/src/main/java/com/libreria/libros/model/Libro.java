package com.libreria.libros.model;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private Integer anoPubli;

    public Libro(String titulo, String autor, String genero, Integer anoPubli) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPubli = anoPubli;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoPubli() {
        return anoPubli;
    }

    public void setAnoPubli(Integer anoPubli) {
        this.anoPubli = anoPubli;
    }
}
