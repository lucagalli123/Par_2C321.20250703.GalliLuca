
package cine.controller;

import cine.modelo.Cine;
import cine.modelo.Cliente;

public class LoginController {

    private Cine cine;
    private Navegacion navegacion;
    
    public LoginController(Cine cine, Navegacion navegacion) {
        this.cine = cine;
        this.navegacion = navegacion;
    }
    
    public boolean iniciarSesion(String nombre, String contrasenia) {
        Cliente cliente = cine.buscarClientePorNombre(nombre);
        if (cliente != null && cliente.getContrasenia().equals(contrasenia)) {
            cine.setClienteEnSesion(cliente);
            navegacion.mostrarMenu();
            return true;
        }
        return false;
    }
    
    public void mostrarRegistrarse() {
        navegacion.mostrarRegistrarse();
    }
    
}
