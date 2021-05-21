package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    Optional<User> findByUsername(String username);

    boolean existsByUserName(String username);

}
