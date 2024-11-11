package com.example.pedidomanagement.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "actividadesProducto")

public class ActividadProducto {
	@Id
    private String id;
    private String productoId;
    private String tipoCambio; // Precio, Imagen, Video, etc.
    private String valorAnterior;
    private String nuevoValor;
    private String operador;
    private Date fechaCambio;
	public String getProductoId() {
		return productoId;
	}
	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}
	public String getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public String getNuevoValor() {
		return nuevoValor;
	}
	public void setNuevoValor(String nuevoValor) {
		this.nuevoValor = nuevoValor;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public Date getFechaCambio() {
		return fechaCambio;
	}
	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}
	public String getValorAnterior() {
		return valorAnterior;
	}
	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

    // Getters y Setters


}
