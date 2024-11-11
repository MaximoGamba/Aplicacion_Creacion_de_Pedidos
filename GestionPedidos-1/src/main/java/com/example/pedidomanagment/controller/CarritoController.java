package com.example.pedidomanagment.controller;

import com.example.pedidomanagement.model.Producto;
import com.example.pedidomanagement.model.Carrito;
import com.example.pedidomanagement.model.ItemCarrito;
import com.example.pedidomanagment.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")


public class CarritoController {
	@Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> obtenerTodosLosCarritos() {
        return carritoService.obtenerTodosLosCarritos();
    }

    @PostMapping
    public Carrito guardarCarrito(@RequestBody Carrito carrito) {
        return carritoService.guardarCarrito(carrito);
    }

    @GetMapping("/{id}")
    public Carrito obtenerCarritoPorId(@PathVariable String id) {
        return carritoService.obtenerCarritoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarrito(@PathVariable String id) {
        carritoService.eliminarCarrito(id);
    }

    @PutMapping("/{id}/producto")
    public Carrito agregarProducto(@PathVariable String id, @RequestBody ItemCarrito itemcarrito) {
        return carritoService.agregarProducto(id, itemcarrito);
    }

    @DeleteMapping("/{id}/producto/{productoId}")
    public Carrito eliminarProducto(@PathVariable String id, @PathVariable String productoId) {
        return carritoService.eliminarProducto(id, productoId);
    }

    @PutMapping("/{id}/producto/{productoId}")
    public Carrito actualizarProducto(@PathVariable String id, @PathVariable String productoId, @RequestBody Producto producto) {
        return carritoService.actualizarProducto(id, productoId, producto);
    }

    @PutMapping("/{id}/estado")
    public Carrito actualizarEstado(@PathVariable String id, @RequestParam String estado) {
        return carritoService.actualizarEstado(id, estado);
    }

    @PutMapping("/{id}/revertir")
    public Carrito revertirEstado(@PathVariable String id, @RequestParam String estadoAnterior) {
        return carritoService.revertirEstado(id, estadoAnterior);
        
        }

	

}
