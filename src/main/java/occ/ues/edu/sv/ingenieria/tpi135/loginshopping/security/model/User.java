package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String id_user;

    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private Set<Rol> roles = new HashSet<>();


    public User() {
    }


    public User(String nombre, String apellido, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
    }

    public String getId_user() {
        return this.id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}
