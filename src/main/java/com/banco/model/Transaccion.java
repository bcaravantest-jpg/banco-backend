package com.banco.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // "Depósito", "Retiro" o "Transferencia"
    private Double monto;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    public Transaccion() {
        this.fecha = LocalDateTime.now();
    }

    public Transaccion(String tipo, Double monto, Cuenta cuenta) {
        this.tipo = tipo;
        this.monto = monto;
        this.cuenta = cuenta;
        this.fecha = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
