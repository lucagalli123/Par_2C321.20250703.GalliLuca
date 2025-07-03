
package cine.controller;

import cine.modelo.Cine;
import cine.modelo.Cliente;

public class RegistroController {

    private Cine cine;
    private Navegacion navegacion;

    public RegistroController(Cine cine, Navegacion navegacion) {
        this.cine = cine;
        this.navegacion = navegacion;
    }
    
    public boolean registrarCliente(String nombre, String email, String contrasenia) {
        Cliente cliente = cine.buscarClientePorNombre(nombre);
        if (cliente == null) {
            cine.registrarCliente(nombre, new Cliente(nombre, email, contrasenia));
            return true;
        }
        return false;
    }
    
    public void mostrarLogin() {
        navegacion.mostrarLogin();
    }
    
}
