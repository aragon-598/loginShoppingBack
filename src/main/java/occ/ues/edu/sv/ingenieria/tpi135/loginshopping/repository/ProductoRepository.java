package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto,String> {
    
}
