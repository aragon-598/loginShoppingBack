package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.enums.RolNombre;

@Document
public class Rol {

    @Id
    private String id;

    private RolNombre rolNombre;


    public Rol() {
    }


    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return this.rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
}
