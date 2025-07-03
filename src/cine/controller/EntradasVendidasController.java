
package cine.controller;

import cine.modelo.Cine;
import cine.modelo.Entrada;
import java.util.List;

public class EntradasVendidasController {
    
    private Cine cine;
    private Navegacion navegacion;
    
    public EntradasVendidasController(Cine cine, Navegacion navegacion) {
        this.cine = cine;
        this.navegacion = navegacion;
    }
    
    public List<Entrada> getEntradasVendidas() {
        return cine.getEntradas();
    }

    public void mostrarMenu() {
        navegacion.mostrarMenu();
    }
    
    
}
