package com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.model.Cuenta;
import com.banco.model.Cliente;
import com.banco.repository.ClienteRepository;
import com.banco.repository.CuentaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "*")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cuenta> obtenerCuentas() {
        return cuentaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuentaPorId(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        return cuenta.isPresent() ? ResponseEntity.ok(cuenta.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crearCuenta(@RequestBody Cuenta cuenta) {
        if (cuenta.getCliente() != null && cuenta.getCliente().getId() != null) {
            Optional<Cliente> clienteOpt = clienteRepository.findById(cuenta.getCliente().getId());
            if (clienteOpt.isPresent()) {
                cuenta.setCliente(clienteOpt.get());
            } else {
                return ResponseEntity.badRequest().body("El cliente con el ID especificado no existe");
            }
        } else {
            return ResponseEntity.badRequest().body("Debe especificar un cliente válido");
        }

        Cuenta nuevaCuenta = cuentaRepository.save(cuenta);
        return ResponseEntity.ok(nuevaCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCuenta(@PathVariable Long id) {
        cuentaRepository.deleteById(id);
        return ResponseEntity.ok("Cuenta eliminada correctamente");
    }
}
