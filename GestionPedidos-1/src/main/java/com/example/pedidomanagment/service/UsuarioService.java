package com.example.pedidomanagment.service;

import com.example.pedidomanagement.model.Usuario;
import com.example.pedidomanagment.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

@Service

public class UsuarioService {
	    @Autowired
	    private UsuarioRepository usuarioRepository;

	    public List<Usuario> obtenerTodosLosUsuarios() {
	        return usuarioRepository.findAll();
	    }

	    public Usuario guardarUsuario(Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }

	    public Usuario obtenerUsuarioPorId(String id) {
	        return usuarioRepository.findById(id).orElse(null);
	    }

	    public void eliminarUsuario(String id) {
	        usuarioRepository.deleteById(id);
	    }

	    public void actualizarTiempoConexion(String id, int minutos) {
	        Usuario usuario = obtenerUsuarioPorId(id);
	        if (usuario != null) {
	            usuario.setTiempoConexionDiario(usuario.getTiempoConexionDiario() + minutos);
	            usuario.setFechaUltimaConexion(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
	            usuario.setCategoriaUsuario(determinarCategoriaUsuario(usuario.getTiempoConexionDiario()));
	            usuarioRepository.save(usuario);
	        }
	    }

	    public String determinarCategoriaUsuario(int tiempoConexionDiario) {
	        if (tiempoConexionDiario > 240) {
	            return "TOP";
	        } else if (tiempoConexionDiario >= 120) {
	            return "MEDIUM";
	        } else {
	            return "LOW";
	        }
	    }
	}
	
     



