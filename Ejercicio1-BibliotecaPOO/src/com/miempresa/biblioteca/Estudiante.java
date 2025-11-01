package com.miempresa.biblioteca;

public class Estudiante extends Usuario {
    public Estudiante(String nombre, String carnet) { super(nombre, carnet); }

    @Override
    public int maxPrestamos() { return 3; }
}
