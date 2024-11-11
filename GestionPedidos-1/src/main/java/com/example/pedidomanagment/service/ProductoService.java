package com.example.pedidomanagment.service;
import com.example.pedidomanagement.model.Producto;
import com.example.pedidomanagement.model.ActividadProducto;
import com.example.pedidomanagment.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service


public class ProductoService {
	@Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ActividadProductoService actividadProductoService;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto obtenerProductoPorId(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
        
    }
    
    public void eliminarTodosProductos() {
    	productoRepository.deleteAll();
    }
    

    public Producto actualizarProducto(String id, Producto productoActualizado) {
        Producto producto = obtenerProductoPorId(id);
        if (producto != null) {
            registrarActividad(producto, productoActualizado, "Operador"); // Aquí se asume "Operador" como el nombre del operador
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setImagen(productoActualizado.getImagen());
            producto.setVideos(productoActualizado.getVideos());
            producto.setComentarios(productoActualizado.getComentarios());
            producto.setFechaUltimaActualizacion(new Date());
            return productoRepository.save(producto);
        }
        return null;
    }

    private void registrarActividad(Producto productoAnterior, Producto productoActualizado, String operador) {
        if (productoAnterior.getPrecio() != productoActualizado.getPrecio()) {
            registrarCambio(productoAnterior.getId(), "Precio", String.valueOf(productoAnterior.getPrecio()), String.valueOf(productoActualizado.getPrecio()), operador);
        }
        if (!productoAnterior.getImagen().equals(productoActualizado.getImagen())) {
            registrarCambio(productoAnterior.getId(), "Imagen", productoAnterior.getImagen(), productoActualizado.getImagen(), operador);
        }
        // Se pueden agregar más comparaciones para otros campos
    }
    public double obtenerPrecioProducto(String productoId) {
    	Producto producto = productoRepository.findById(productoId).orElse(null);
        if (producto != null) {
        	return producto.getPrecio();
        } else {
            throw new RuntimeException("Producto no encontrado");
            }
 }


 


    private void registrarCambio(String productoId, String tipoCambio, String valorAnterior, String nuevoValor, String operador) {
        ActividadProducto actividad = new ActividadProducto();
        actividad.setProductoId(productoId);
        actividad.setTipoCambio(tipoCambio);
        actividad.setValorAnterior(valorAnterior);
        actividad.setNuevoValor(nuevoValor);
        actividad.setOperador(operador);
        actividad.setFechaCambio(new Date());
        actividadProductoService.guardarActividad(actividad);
        
}

	


}
