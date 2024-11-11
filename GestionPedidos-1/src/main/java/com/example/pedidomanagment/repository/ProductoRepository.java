package com.example.pedidomanagment.repository;
import com.example.pedidomanagement.model.Producto;
 
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductoRepository extends MongoRepository<Producto, String>{

}
