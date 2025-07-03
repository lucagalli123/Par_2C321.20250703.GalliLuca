
package cine.controller;

import cine.modelo.Butaca;
import cine.modelo.Cine;
import cine.modelo.Cliente;
import cine.modelo.Entrada;
import cine.modelo.Sala;

public class CompraController {
    
    private Cine cine;
    private Navegacion navegacion;

    public CompraController(Cine cine, Navegacion navegacion) {
        this.cine = cine;
        this.navegacion = navegacion;
    }
    
    public String previsualizarEntrada() {
        String cliente = cine.getClienteEnSesion().getNombre();
        String pelicula = cine.getSalaSeleccionada().getPelicula();
        int sala = cine.getSalaSeleccionada().getNumero();
        int butaca = cine.getSalaSeleccionada().getButacaSeleccionada().getNumero();
        String texto = "Cliente: " + cliente + "\nPelicula: " + pelicula + "\nSala: " + sala + "\nButaca: " + butaca;
        return texto;
    }
    
    public void borrarDatosDeSesion() {
        cine.getSalaSeleccionada().borrarButacaSeleccionada();
        cine.borrarSalaSeleccionada();
    }
    
    public void mostrarMenu() {
        navegacion.mostrarMenu();
    }
    
    public void realizarCompra() {
        Cliente cliente = cine.getClienteEnSesion();
        Sala sala = cine.getSalaSeleccionada();
        Butaca butaca = cine.getSalaSeleccionada().getButacaSeleccionada();
        Entrada entrada = new Entrada(cliente, sala, butaca);
        cine.getSalaSeleccionada().getButacaSeleccionada().ocuparButaca();
        cine.agregarEntrada(entrada);
    }
    
    public Sala getSalaSeleccionada() {
        return cine.getSalaSeleccionada();
    }
}
