package com.example.pedidomanagment.service;
import com.example.pedidomanagement.model.Factura;
import com.example.pedidomanagement.model.Pago;
import com.example.pedidomanagment.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class FacturaService {
	@Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura obtenerFacturaPorId(String id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public void eliminarFactura(String id) {
        facturaRepository.deleteById(id);
    }

    public Factura actualizarFactura(String id, Factura facturaActualizada) {
        Factura factura = obtenerFacturaPorId(id);
        if (factura != null) {
            factura.setMonto(facturaActualizada.getMonto());
            factura.setFecha(facturaActualizada.getFecha());
            factura.setEstado(facturaActualizada.getEstado());
            factura.setDetalle(facturaActualizada.getDetalle());
            return facturaRepository.save(factura);
        }
        return null;
    }

    public Factura registrarPago(String id, Pago pago) {
        Factura factura = obtenerFacturaPorId(id);
        if (factura != null) {
            // Suponiendo que Factura tiene un campo de lista de pagos
            factura.getPagos().add(pago);
            return facturaRepository.save(factura);
        }
        return null;
        
}

	
}
