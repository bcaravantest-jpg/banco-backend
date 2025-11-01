package com.miempresa.biblioteca;

public class MainPrueba {
    public static void main(String[] args) {
    	
        // Creacion de libros
        Libro l1 = new Libro(1L, "El Bazar de los Malos Sueños", "Stephen King", 2015);
        Libro l2 = new Libro(2L, "La niña del Bosque", "Brian McGilloway", 2016);

        // Creacion de usuarios
        Usuario u1 = new Estudiante("Miguel Cardenas", "E123");
        Usuario u2 = new Profesor("Angel Ortiz", "P001");

        System.out.println("- - - - - SISTEMA DE BIBLIOTECA - - - - -");
        System.out.println("\n📘 Libros disponibles:");
        System.out.println(l1);
        System.out.println(l2);

        System.out.println("\n👩‍🎓 Usuario 1: " + u1.getNombre() + " (" + u1.getCarnet() + ")");
        System.out.println("👨‍🏫 Usuario 2: " + u2.getNombre() + " (" + u2.getCarnet() + ")\n");

        System.out.println("- - - - - PRUEBA DE PRESTAMOS - - - - -");
        System.out.println("Estudiante intenta prestar El Bazar de los Malos Sueños → " + (u1.prestarLibro(l1) ? "✅ Éxito" : "❌ Fallo"));
        System.out.println("Profesor intenta prestar El Bazar de los Malos Sueños → " + (u2.prestarLibro(l1) ? "✅ Éxito" : "❌ Fallo"));

        System.out.println("\n📖 Estado actual de los libros:");
        System.out.println(l1);
        System.out.println(l2);

        System.out.println("\n- - - - - DEVOLUCION - - - - -");
        System.out.println("Estudiante devuelve El Bazar de los Malos Sueños → " + (u1.devolverLibro(l1) ? "✅ Devuelto" : "❌ No lo tenía"));
        System.out.println("Profesor ahora presta El Bazar de los Malos Sueños → " + (u2.prestarLibro(l1) ? "✅ Éxito" : "❌ Fallo"));

        System.out.println("\n📚 Libros en préstamo del profesor:");
        for (Libro libro : u2.getPrestamos()) {
            System.out.println("→ " + libro.getTitulo() + " (" + libro.getAutor() + ")");
        }

        System.out.println("\n - - - - - FIN DEL SIMULADOR - - - - -");
    }
}
