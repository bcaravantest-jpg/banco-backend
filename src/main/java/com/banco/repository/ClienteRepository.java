package com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banco.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
