package com.example.pedidomanagment.controller;

import com.example.pedidomanagement.model.Usuario;
import com.example.pedidomanagment.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable String id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(id);
    }

    @PutMapping("/{id}/tiempoConexion")
    public void actualizarTiempoConexion(@PathVariable String id, @RequestParam int minutos) {
        usuarioService.actualizarTiempoConexion(id, minutos);
    }

    @PostMapping("/{id}/actividad")
    public void registrarActividad(@PathVariable String id, @RequestBody int minutosConectados) {
        usuarioService.actualizarTiempoConexion(id, minutosConectados);
    }
}

    


