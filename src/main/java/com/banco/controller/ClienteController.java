package com.banco.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.banco.model.Cliente;
import com.banco.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*") // permite acceso desde el frontend
public class ClienteController {
	private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteService.obtenerClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerPorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }
}
