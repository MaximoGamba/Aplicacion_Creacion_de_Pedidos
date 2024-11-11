package com.example.pedidomanagment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pedidomanagment.repository.ActividadUsuarioRepository;

import com.example.pedidomanagement.model.ActividadUsuario;

import java.util.List;

@Service

public class ActividadUsuarioService {
	@Autowired
    private ActividadUsuarioRepository actividadUsuarioRepository;

    public List<ActividadUsuario> obtenerTodasLasActividades() {
        return actividadUsuarioRepository.findAll();
    }

    public ActividadUsuario guardarActividad(ActividadUsuario actividad) {
        return actividadUsuarioRepository.save(actividad);
    }

    public ActividadUsuario obtenerActividadPorUsuarioId(String usuarioId) {
        return actividadUsuarioRepository.findById(usuarioId).orElse(null);
    }

    public void eliminarActividad(String id) {
        actividadUsuarioRepository.deleteById(id);
    }

    public void actualizarTiempoConexion(String usuarioId, int minutos) {
        ActividadUsuario actividad = obtenerActividadPorUsuarioId(usuarioId);
        if (actividad != null) {
            actividad.setMinutosConectado(actividad.getMinutosConectado() + minutos);
            actividad.setCategoriaUsuario(determinarCategoriaUsuario(actividad.getMinutosConectado()));
            actividadUsuarioRepository.save(actividad);
        }
    }

    private String determinarCategoriaUsuario(int minutosConexion) {
        if (minutosConexion > 240) {
            return "TOP";
        } else if (minutosConexion >= 120) {
            return "MEDIUM";
        } else {
            return "LOW"; }
            
 }
}

