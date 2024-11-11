package com.example.pedidomanagment.service;


import com.example.pedidomanagement.model.Pago;
import com.example.pedidomanagment.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class PagoService {
	@Autowired
    private PagoRepository pagoRepository;

    public List<Pago> obtenerTodosLosPagos() {
        return pagoRepository.findAll();
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago obtenerPagoPorId(String id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public void eliminarPago(String id) {
        pagoRepository.deleteById(id);
    }

    public Pago actualizarPago(String id, Pago pagoActualizado) {
        Pago pago = obtenerPagoPorId(id);
        if (pago != null) {
            pago.setMonto(pagoActualizado.getMonto());
            pago.setFormaPago(pagoActualizado.getFormaPago());
            pago.setFecha(pagoActualizado.getFecha());
            pago.setEstado(pagoActualizado.getEstado());
            return pagoRepository.save(pago);
        }
        return null;
        
}

	

}
