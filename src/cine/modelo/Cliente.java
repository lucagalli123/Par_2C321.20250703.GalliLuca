
package cine.modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
    
    private String nombre;
    private String email;
    private String contrasenia;

    public Cliente(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    //---------------------------------------------------------------
    
    
}
