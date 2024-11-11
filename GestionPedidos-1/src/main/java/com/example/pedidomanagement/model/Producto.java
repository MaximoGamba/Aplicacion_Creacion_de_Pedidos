package com.example.pedidomanagement.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Document(collection = "productos")
public class Producto {
	@Id
    private String id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "La descripción no puede estar vacía")
    private String descripcion;

    private double precio;
    private String imagen;
    private List<String> videos;
    private List<String> comentarios;
    private Date fechaUltimaActualizacion;
    private int cantidad; // Agregar el campo cantidad
    
    public Producto(String nombre, String descripcion, double precio, String imagen, List<String> videos, List<String> comentarios, Date fechaUltimaActualizacion, int cantidad) {
    	this.nombre = nombre;
    	this.descripcion = descripcion;
    	this.precio = precio;
    	this.comentarios = comentarios;
    	this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    	this.videos = videos;
    	this.cantidad = cantidad;
    	this.imagen = imagen;
    }
    
    public Producto() {
    	
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
}
}

    
