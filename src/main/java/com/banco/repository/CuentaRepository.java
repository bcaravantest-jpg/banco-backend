package com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banco.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}

