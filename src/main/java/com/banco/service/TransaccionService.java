package com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.model.Cuenta;
import com.banco.model.Transaccion;
import com.banco.repository.CuentaRepository;
import com.banco.repository.TransaccionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Transaccion> obtenerTransacciones() {
        return transaccionRepository.findAll();
    }

    public Transaccion obtenerTransaccionPorId(Long id) {
        return transaccionRepository.findById(id).orElse(null);
    }

    public Transaccion crearTransaccion(Transaccion transaccion) {
        if (transaccion.getCuenta() == null || transaccion.getCuenta().getId() == null) {
            return null;
        }

        // Buscar la cuenta real desde la BD
        Cuenta cuenta = cuentaRepository.findById(transaccion.getCuenta().getId()).orElse(null);
        if (cuenta == null) {
            return null;
        }

        // Actualizar el saldo según el tipo de transacción
        if ("Depósito".equalsIgnoreCase(transaccion.getTipo())) {
            cuenta.setSaldo(cuenta.getSaldo() + transaccion.getMonto());
        } else if ("Retiro".equalsIgnoreCase(transaccion.getTipo())) {
            cuenta.setSaldo(cuenta.getSaldo() - transaccion.getMonto());
        }

        // Guardar la cuenta actualizada
        cuentaRepository.save(cuenta);

        // Guardar la transacción con fecha actual
        transaccion.setCuenta(cuenta);
        transaccion.setFecha(LocalDateTime.now());

        return transaccionRepository.save(transaccion);
    }

    public void eliminarTransaccion(Long id) {
        transaccionRepository.deleteById(id);
    }
}

