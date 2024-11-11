package com.example.pedidomanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "pagos")

public class Pago {
	@Id
    private String id;

    @NotEmpty(message = "El ID de la factura no puede estar vacío")
    private String facturaId;

    @NotEmpty(message = "La forma de pago no puede estar vacía")
    private String formaPago;

    @NotNull(message = "El monto no puede ser nulo")
    private double monto;

    @NotNull(message = "La fecha no puede ser nula")
    private Date fecha;

    @NotEmpty(message = "El ID del usuario no puede estar vacío")
    private String usuarioId;

    private String estado;

    // Getters y Setters
    public String getId() {
    	return id;
    }
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        
}

	

}
