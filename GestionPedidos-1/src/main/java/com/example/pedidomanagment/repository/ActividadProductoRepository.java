package com.example.pedidomanagment.repository;
import com.example.pedidomanagement.model.ActividadProducto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface ActividadProductoRepository extends MongoRepository<ActividadProducto, String>{

}
