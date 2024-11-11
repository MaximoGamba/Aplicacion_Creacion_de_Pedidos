package com.example.pedidomanagment.service;
import com.example.pedidomanagement.model.ActividadProducto;
import com.example.pedidomanagment.repository.ActividadProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ActividadProductoService {
	@Autowired
    private ActividadProductoRepository actividadProductoRepository;

    public List<ActividadProducto> obtenerTodasLasActividades() {
        return actividadProductoRepository.findAll();
    }

    public ActividadProducto guardarActividad(ActividadProducto actividad) {
        return actividadProductoRepository.save(actividad);
    }

    public ActividadProducto obtenerActividadPorId(String id) {
        return actividadProductoRepository.findById(id).orElse(null);
    }

    public void eliminarActividad(String id) {
        actividadProductoRepository.deleteById(id);
        
}


}
