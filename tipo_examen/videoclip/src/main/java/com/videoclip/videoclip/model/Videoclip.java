package com.videoclip.videoclip.model;

public class Videoclip {
    private String titulo;
    private String artista;
    private String genero;
    private Integer anoPubli;
    private String url;

    public Videoclip(String titulo, String artista, String genero, Integer anoPubli, String url) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.anoPubli = anoPubli;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
