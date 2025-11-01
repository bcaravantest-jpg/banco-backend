package com.umg.usuarios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umg.usuarios.entity.Usuario;
import com.umg.usuarios.repository.UsuarioRepository;
import com.umg.usuarios.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombre(usuario.getNombre());
            u.setCorreo(usuario.getCorreo());
            u.setTelefono(usuario.getTelefono());
            return usuarioRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContaining(nombre);
    }
}
