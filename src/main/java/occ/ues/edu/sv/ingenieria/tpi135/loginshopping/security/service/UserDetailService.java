package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model.User;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model.UserPrincipal;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = service.getByUserName(username).get();
        
        return UserPrincipal.build(user);
    }
 
    
    
}
