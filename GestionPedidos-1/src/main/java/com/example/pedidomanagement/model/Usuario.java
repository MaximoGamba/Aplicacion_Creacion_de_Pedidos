package com.example.pedidomanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;

@Document(collection = "usuarios")


public class Usuario {
	@Id
    private String id;
    
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @NotEmpty(message = "La dirección no puede estar vacía")
    private String direccion;
    
    @NotEmpty(message = "El documento de identidad no puede estar vacío")
    private String documentoIdentidad;
    
    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;

    private int tiempoConexionDiario;
    private String categoriaUsuario;
    private String fechaUltimaConexion;

    public Usuario() {}

    public Usuario(String nombre, String direccion, String documentoIdentidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.documentoIdentidad = documentoIdentidad;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    public int getTiempoConexionDiario() {
        return tiempoConexionDiario;
    }

    public void setTiempoConexionDiario(int tiempoConexionDiario) {
        this.tiempoConexionDiario = tiempoConexionDiario;
    }

    public String getCategoriaUsuario() {
        return categoriaUsuario;
    }

    public void setCategoriaUsuario(String categoriaUsuario) {
        this.categoriaUsuario = categoriaUsuario;
    }

    public String getFechaUltimaConexion() {
        return fechaUltimaConexion;
    }

    public void setFechaUltimaConexion(String fechaUltimaConexion) {
        this.fechaUltimaConexion = fechaUltimaConexion;
        
}

	 
		

	

}
