package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.enums.RolNombre;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model.Rol;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.repository.RolRepository;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository repository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return repository.findByRolNombre(rolNombre);
    }
    
}
