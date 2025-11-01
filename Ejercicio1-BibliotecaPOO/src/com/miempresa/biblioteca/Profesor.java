package com.miempresa.biblioteca;

public class Profesor extends Usuario {
    public Profesor(String nombre, String carnet) { super(nombre, carnet); }

    @Override
    public int maxPrestamos() { return 6; }
}
