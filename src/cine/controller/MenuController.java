
package cine.controller;

import cine.modelo.Cine;
import cine.modelo.Cliente;
import cine.modelo.Entrada;
import java.util.List;

public class MenuController {

    private Cine cine;
    private Navegacion navegacion;
    
    public MenuController(Cine cine, Navegacion navegacion) {
        this.cine = cine;
        this.navegacion = navegacion;
    }

    public void mostrarSalas() {
        navegacion.mostrarSalas();
    }
    
    public void borrarDatosDeSesion() {
        try {
            cine.getSalaSeleccionada().borrarButacaSeleccionada();
        } catch (NullPointerException npe) {
        }
        cine.borrarSalaSeleccionada();
        cine.cerrarSesionCliente();
    }
    
    public void mostrarLogin() {
        navegacion.mostrarLogin();
    }
    
    public void mostrarEntradasVendidas() {
        navegacion.mostrarEntradasVendidas();
    }
    
    public boolean hayEntradasVendidas() {
        return cine.hayEntradasVendidas();
    }
}