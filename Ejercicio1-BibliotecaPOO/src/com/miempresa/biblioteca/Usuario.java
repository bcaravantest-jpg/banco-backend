package com.miempresa.biblioteca;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private String nombre;
    private String carnet;
    private List<Libro> prestamos = new ArrayList<>();

    public Usuario(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
    }

    // Encapsulación
    public String getNombre() { return nombre; }
    public String getCarnet() { return carnet; }

    public List<Libro> getPrestamos() { return prestamos; }

    // Polimorfismo: cada tipo de usuario define su maximo de prestamos
    public abstract int maxPrestamos();

    // Método para prestar
    public boolean prestarLibro(Libro libro) {
        if (libro.isPrestado()) return false;
        if (prestamos.size() >= maxPrestamos()) return false;
        if (libro.prestar()) {
            prestamos.add(libro);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {
        if (!prestamos.contains(libro)) return false;
        if (libro.devolver()) {
            prestamos.remove(libro);
            return true;
        }
        return false;
    }
}
