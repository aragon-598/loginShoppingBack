package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.model.Compra;

public interface CompraRepository extends MongoRepository<Compra, String>{
    
}
