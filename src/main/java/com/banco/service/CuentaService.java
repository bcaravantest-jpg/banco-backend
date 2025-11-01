package com.banco.service;

import com.banco.model.Cuenta;
import com.banco.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> obtenerCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
