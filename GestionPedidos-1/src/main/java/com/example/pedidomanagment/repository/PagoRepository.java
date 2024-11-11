package com.example.pedidomanagment.repository;
import com.example.pedidomanagement.model.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PagoRepository extends MongoRepository<Pago, String>{

}
