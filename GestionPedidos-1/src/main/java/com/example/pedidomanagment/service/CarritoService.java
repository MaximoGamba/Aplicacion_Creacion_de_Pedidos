package com.example.pedidomanagment.service;

import com.example.pedidomanagement.model.Carrito;
import com.example.pedidomanagement.model.ItemCarrito;
import com.example.pedidomanagement.model.Producto;
import com.example.pedidomanagment.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CarritoService {
	@Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoService productoService;

    public List<Carrito> obtenerTodosLosCarritos() {
        return carritoRepository.findAll();
    }

    public Carrito guardarCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Carrito obtenerCarritoPorId(String id) {
        return carritoRepository.findById(id).orElse(null);
    }

    public Optional<Carrito> obtenerCarritoPorUsuarioId(String usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId);
    }

    public void eliminarCarrito(String id) {
        carritoRepository.deleteById(id);
    }

    public Carrito agregarProducto(String usuarioId, ItemCarrito itemCarrito) {
        Carrito carrito = obtenerCarritoPorUsuarioId(usuarioId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        Producto producto = productoService.obtenerProductoPorId(itemCarrito.getProductoId());
        
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado");
        }

        // Clonar el producto y ajustar la cantidad
        Producto productoEnCarrito = new Producto();
        productoEnCarrito.setId(producto.getId());
        productoEnCarrito.setNombre(producto.getNombre());
        productoEnCarrito.setDescripcion(producto.getDescripcion());
        productoEnCarrito.setPrecio(producto.getPrecio());
        productoEnCarrito.setImagen(producto.getImagen());
        productoEnCarrito.setVideos(producto.getVideos());
        productoEnCarrito.setComentarios(producto.getComentarios());
        productoEnCarrito.setFechaUltimaActualizacion(producto.getFechaUltimaActualizacion());
        productoEnCarrito.setCantidad(itemCarrito.getCantidad());
        
        if (carrito.getProductos() == null) {
        	ArrayList<Producto> productos = new ArrayList<Producto>();
        	productos.add(productoEnCarrito);
        	carrito.setProductos(productos);
        	return carritoRepository.save(carrito);
        }
        else {
        	
        	carrito.getProductos().add(productoEnCarrito);
        	return carritoRepository.save(carrito);
        }
    }

    public Carrito eliminarProducto(String id, String productoId) {
        Carrito carrito = obtenerCarritoPorId(id);
        if (carrito != null) {
            carrito.getProductos().removeIf(p -> p.getId().equals(productoId));
            return carritoRepository.save(carrito);
        }
        return null;
    }

    public Carrito actualizarProducto(String id, String productoId, Producto productoActualizado) {
        Carrito carrito = obtenerCarritoPorId(id);
        if (carrito != null) {
            carrito.getProductos().removeIf(p -> p.getId().equals(productoId));
            carrito.getProductos().add(productoActualizado);
            return carritoRepository.save(carrito);
        }
        return null;
    }

    public Carrito actualizarEstado(String id, String estado) {
        Carrito carrito = obtenerCarritoPorId(id);
        if (carrito != null) {
            carrito.setEstado(estado);
            return carritoRepository.save(carrito);
        }
        return null;
    }

    public Carrito revertirEstado(String id, String estadoAnterior) {
        Carrito carrito = obtenerCarritoPorId(id);
        if (carrito != null) {
            carrito.setEstado(estadoAnterior);
            return carritoRepository.save(carrito);
        }
        return null;
    }

    public Carrito actualizarCantidadProducto(String usuarioId, String productoId, int cantidad) {
        Optional<Carrito> optionalCarrito = obtenerCarritoPorUsuarioId(usuarioId);
        if (optionalCarrito.isPresent()) {
            Carrito carrito = optionalCarrito.get();
            for (Producto producto : carrito.getProductos()) {
                if (producto.getId().equals(productoId)) {
                    producto.setCantidad(cantidad);
                    break;
                }
            }
            return carritoRepository.save(carrito);
        }
        return null;
}
}

	

	 
