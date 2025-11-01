package com.miempresa.biblioteca;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private int año;
    private boolean prestado;

    public Libro(Long id, String titulo, String autor, int año) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.prestado = false;
    }

    // Encapsulación: getters/setters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return año; }

    public boolean isPrestado() { return prestado; }

    // Métodos para prestar y devolver
    public boolean prestar() {
        if (prestado) return false;
        prestado = true;
        return true;
    }

    public boolean devolver() {
        if (!prestado) return false;
        prestado = false;
        return true;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo='" + titulo + '\'' +
               ", autor='" + autor + '\'' + ", año=" + año +
               ", prestado=" + prestado + '}';
    }
}
