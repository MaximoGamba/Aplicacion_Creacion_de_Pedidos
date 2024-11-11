package com.example.pedidomanagment.service;

import com.example.pedidomanagement.model.Pedido;
import com.example.pedidomanagement.model.Producto;
import com.example.pedidomanagment.repository.PedidoRepository;
import com.example.pedidomanagment.repository.CarritoRepository;
import com.example.pedidomanagement.model.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PedidoService {
	@Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido obtenerPedidoPorId(String id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    public Pedido createOrder(Pedido pedido) {
    	return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(String id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido actualizarPedido(String id, Pedido pedidoActualizado) {
        Pedido pedido = obtenerPedidoPorId(id);
        if (pedido != null) {
            pedido.setProductos(pedidoActualizado.getProductos());
            pedido.setTotal(pedidoActualizado.getTotal());
            pedido.setEstado(pedidoActualizado.getEstado());
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public Pedido convertirCarritoEnPedido(String carritoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElse(null);
        if (carrito != null) {
            Pedido pedido = new Pedido();
            pedido.setUsuarioId(carrito.getUsuarioId());
            pedido.setProductos(carrito.getProductos());
            pedido.setTotal(carrito.getProductos().stream().mapToDouble(Producto::getPrecio).sum());
            pedido.setEstado("Pendiente");
            return pedidoRepository.save(pedido);
        }
        return null;
        
}

	

}
