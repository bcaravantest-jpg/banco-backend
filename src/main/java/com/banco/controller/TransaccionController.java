package com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.model.Transaccion;
import com.banco.service.TransaccionService;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
@CrossOrigin(origins = "*")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping
    public List<Transaccion> obtenerTransacciones() {
        return transaccionService.obtenerTransacciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> obtenerTransaccionPorId(@PathVariable Long id) {
        Transaccion transaccion = transaccionService.obtenerTransaccionPorId(id);
        return (transaccion != null) ? ResponseEntity.ok(transaccion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Transaccion> registrarTransaccion(@RequestBody Transaccion transaccion) {
        Transaccion nueva = transaccionService.crearTransaccion(transaccion);
        return (nueva != null) ? ResponseEntity.ok(nueva) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTransaccion(@PathVariable Long id) {
        transaccionService.eliminarTransaccion(id);
        return ResponseEntity.ok("Transacción eliminada correctamente");
    }
}