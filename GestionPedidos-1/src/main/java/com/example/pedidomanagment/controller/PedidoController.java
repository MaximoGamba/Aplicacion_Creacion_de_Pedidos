package com.example.pedidomanagment.controller;

import com.example.pedidomanagement.model.Pedido;
import com.example.pedidomanagment.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")


public class PedidoController {
	@Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @PostMapping
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable String id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable String id, @RequestBody Pedido pedido) {
        return pedidoService.actualizarPedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable String id) {
        pedidoService.eliminarPedido(id);
    }

    @PostMapping("/convertir/{carritoId}")
    public Pedido convertirCarritoEnPedido(@PathVariable String carritoId) {
        return pedidoService.convertirCarritoEnPedido(carritoId);
       
}

	

}
