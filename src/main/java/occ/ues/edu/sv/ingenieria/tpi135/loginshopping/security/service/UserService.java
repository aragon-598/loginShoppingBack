package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model.User;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.repository.UserRepository;

/**
 * UserService
 */
@Service
@Transactional
public class UserService  {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public boolean existByUserName(String username){
        return userRepository.existsByUserName(username);
    }

    public void save(User user){
        userRepository.save(user);
    }

    
}