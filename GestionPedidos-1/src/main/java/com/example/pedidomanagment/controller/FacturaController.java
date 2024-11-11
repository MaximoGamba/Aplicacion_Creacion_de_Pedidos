package com.example.pedidomanagment.controller;

import com.example.pedidomanagement.model.Factura;
import com.example.pedidomanagment.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pedidomanagement.model.Pago;
import java.util.List;

@RestController
@RequestMapping("/facturas")


public class FacturaController {
	@Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaService.obtenerTodasLasFacturas();
    }

    @PostMapping
    public Factura guardarFactura(@RequestBody Factura factura) {
        return facturaService.guardarFactura(factura);
    }

    @GetMapping("/{id}")
    public Factura obtenerFacturaPorId(@PathVariable String id) {
        return facturaService.obtenerFacturaPorId(id);
    }

    @PutMapping("/{id}")
    public Factura actualizarFactura(@PathVariable String id, @RequestBody Factura factura) {
        return facturaService.actualizarFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable String id) {
        facturaService.eliminarFactura(id);
    }

    @PostMapping("/{id}/pago")
    public Factura registrarPago(@PathVariable String id, @RequestBody Pago pago) {
        return facturaService.registrarPago(id, pago);
        
}


}
