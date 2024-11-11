package com.example.pedidomanagment.controller;

import com.example.pedidomanagement.model.Pago;
import com.example.pedidomanagment.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {
	@Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> obtenerTodosLosPagos() {
        return pagoService.obtenerTodosLosPagos();
    }

    @PostMapping
    public Pago guardarPago(@RequestBody Pago pago) {
        return pagoService.guardarPago(pago);
    }

    @GetMapping("/{id}")
    public Pago obtenerPagoPorId(@PathVariable String id) {
        return pagoService.obtenerPagoPorId(id);
    }

    @PutMapping("/{id}")
    public Pago actualizarPago(@PathVariable String id, @RequestBody Pago pago) {
        return pagoService.actualizarPago(id, pago);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable String id) {
        pagoService.eliminarPago(id);
        
}
}
