package com.umg.cache.service;

import com.umg.cache.model.Libro;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
public class LibroService {

    private static final Map<Long, Libro> LIBROS = new HashMap<>();

    static {
        LIBROS.put(1L, new Libro(1L, "Cien años de soledad", "Gabriel García Márquez"));
        LIBROS.put(2L, new Libro(2L, "Don Quijote de la Mancha", "Miguel de Cervantes"));
        LIBROS.put(3L, new Libro(3L, "El Principito", "Antoine de Saint-Exupéry"));
    }

    @Cacheable("libros")
    public Libro obtenerLibroPorId(Long id) {
        try {
            System.out.println("Consultando libro desde la base de datos...");
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return LIBROS.get(id);
    }
}
