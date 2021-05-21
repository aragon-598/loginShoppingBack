package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.enums.RolNombre;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model.Rol;

/**
 * RolRepository
 */
@Repository
public interface RolRepository extends MongoRepository<Rol, String> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}