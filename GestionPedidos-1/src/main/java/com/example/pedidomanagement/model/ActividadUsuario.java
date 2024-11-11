package com.example.pedidomanagement.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "actividadesUsuario")

public class ActividadUsuario {
	 @Id
	    private String id;
	    private String usuarioId;
	    private int minutosConectado;
	    private String categoriaUsuario;
		public String getCategoriaUsuario() {
			return categoriaUsuario;
		}
		public void setCategoriaUsuario(String categoriaUsuario) {
			this.categoriaUsuario = categoriaUsuario;
		}
		public int getMinutosConectado() {
			return minutosConectado;
		}
		public void setMinutosConectado(int minutosConectado) {
			this.minutosConectado = minutosConectado;
		}
		public String getUsuarioId() {
			return usuarioId;
		}
		public void setUsuarioId(String usuarioId) {
			this.usuarioId = usuarioId;
		}

	    


}
