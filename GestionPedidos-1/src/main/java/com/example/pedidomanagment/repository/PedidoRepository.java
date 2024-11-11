package com.example.pedidomanagment.repository;

import com.example.pedidomanagement.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PedidoRepository extends MongoRepository<Pedido, String> {

}
