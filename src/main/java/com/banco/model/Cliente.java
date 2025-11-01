package com.banco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String dpi;
    private String correo;
    private String telefono;
    private String tipoOperacion; // ejemplo: "Depósito", "Retiro", "Transferencia"
    private String estado; // ejemplo: "Activo", "Inactivo"

    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(String nombre, String dpi, String correo, String telefono, String tipoOperacion, String estado) {
        this.nombre = nombre;
        this.dpi = dpi;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoOperacion = tipoOperacion;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
