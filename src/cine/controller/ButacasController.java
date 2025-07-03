
package cine.controller;

import cine.modelo.Butaca;
import cine.modelo.Cine;
import cine.modelo.Sala;

 public class ButacasController {

    private Cine cine;
    private Navegacion navegacion;

    public ButacasController(Cine cine, Navegacion navegacion) {
        this.cine = cine;
        this.navegacion = navegacion;
    }
    
    public Butaca[][] getButacas() {
        return cine.getSalaSeleccionada().getButacas();
    }
    
    public Sala getSalaSeleccionada() {
        return cine.getSalaSeleccionada();
    }
    
    public boolean seleccionarButaca(int numeroButaca) {
        if (cine.getSalaSeleccionada().butacaOcupada(numeroButaca)) {
            return false;
        } else {
            cine.getSalaSeleccionada().seleccionarButaca(numeroButaca);
            return true;
        }
    }
    
    public int getNumeroDeButacas() {
        return cine.getSalaSeleccionada().getCantButacas();
    }
    
    public void borrarButacaSeleccionada() {
        cine.getSalaSeleccionada().borrarButacaSeleccionada();
    }
    
    public void mostrarSalas() {
        navegacion.mostrarSalas();
    }
    
    public void mostrarCompra() {
        navegacion.mostrarCompra();
    }
    
    public boolean butacaOcupada(int numero) {
        return cine.getSalaSeleccionada().butacaOcupada(numero);
    }
      
}
