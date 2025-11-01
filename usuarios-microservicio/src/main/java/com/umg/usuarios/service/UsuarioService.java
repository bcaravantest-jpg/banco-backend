package com.umg.usuarios.service;

import java.util.List;
import java.util.Optional;

import com.umg.usuarios.entity.Usuario;

public interface UsuarioService {
	List<Usuario> listar();
    Optional<Usuario> obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
    List<Usuario> buscarPorNombre(String nombre);
}
