
package cine.controller;

import cine.modelo.Cine;
import cine.modelo.Sala;
import java.util.List;

public class SalasController {

    private Cine cine;
    private Navegacion navegacion;

    public SalasController(Cine cine, Navegacion navegacion) {
        this.cine = cine;
        this.navegacion = navegacion;
    }
    
    public List<Sala> getSalas() {
        return cine.getSalas();
    }
    
    public void seleccionarSala(Sala sala) {
        cine.seleccionarSala(sala);
    }
 
    public void borrarSalaSeleccionada() {
        cine.borrarSalaSeleccionada();
    }
    
    public void mostrarMenu() {
        navegacion.mostrarMenu();
    }

    public void mostrarButacas() {
        navegacion.mostrarButacas();
    }
    
    public Sala getSalaSeleccionada() {
        return cine.getSalaSeleccionada();
    }
    
    public boolean salaDisponible(Sala sala) {
        return sala.salaDisponible();
    }
    
}
