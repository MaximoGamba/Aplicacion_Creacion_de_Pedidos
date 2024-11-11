package com.example.pedidomanagment.repository;
import com.example.pedidomanagement.model.Factura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FacturaRepository extends MongoRepository<Factura, String>{

}
