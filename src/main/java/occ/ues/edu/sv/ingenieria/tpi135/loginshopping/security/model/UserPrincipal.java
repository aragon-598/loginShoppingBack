package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Se implementan los métodos abstractos al implementar UserDetails de spring
 */
public class UserPrincipal implements UserDetails {
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    /**
     * Sustituimos los roles por las autorizaciones
     */
    private Collection<? extends GrantedAuthority> authorities;


    public UserPrincipal(String nombre, String apellido, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal build(User user){
        /**
         * Convierto los roles en una lista de authorities
         */
        List<GrantedAuthority> authorities = user.getRoles().
        stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).
        collect(Collectors.toList()); 
        return new UserPrincipal(user.getNombre(), user.getApellido(), user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
