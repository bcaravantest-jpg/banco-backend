package com.banco.service;

import com.banco.model.Cliente;
import com.banco.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    // Obtener cliente por ID
    public Cliente obtenerClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    // Agregar un nuevo cliente
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar cliente existente
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setTipoOperacion(clienteActualizado.getTipoOperacion());
            cliente.setEstado(clienteActualizado.getEstado());
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    // Eliminar cliente por ID
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
