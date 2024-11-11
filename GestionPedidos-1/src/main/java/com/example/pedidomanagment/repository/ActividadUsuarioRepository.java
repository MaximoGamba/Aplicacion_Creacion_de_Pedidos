package com.example.pedidomanagment.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pedidomanagement.model.ActividadUsuario;

@Repository

public interface ActividadUsuarioRepository extends MongoRepository<ActividadUsuario, String>{

}
