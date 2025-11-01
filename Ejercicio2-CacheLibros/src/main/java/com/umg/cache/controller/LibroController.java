package com.umg.cache.controller;

import com.umg.cache.model.Libro;
import com.umg.cache.service.LibroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id);
    }
}
