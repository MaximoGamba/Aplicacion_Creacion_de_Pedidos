package com.example.pedidomanagment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.pedidomanagement.model.Usuario;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
