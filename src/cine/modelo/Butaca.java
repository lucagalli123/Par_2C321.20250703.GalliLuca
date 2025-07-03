
package cine.modelo;

import java.io.Serializable;

public class Butaca implements Serializable {
    
    private int numero;
    private int fila;    
    private boolean ocupada;

    public Butaca(int numero, int fila) {
        this.numero = numero;
        this.fila = fila;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public int getFila() {
        return fila;
    }

    public boolean estaOcupada() {
        return ocupada;
    }
    
    public void ocuparButaca() {
        ocupada = true;
    }
    
    //-------------------------------------

    @Override
    public String toString() {
        return "Butaca: " + numero + "\nFila: " + fila + "\n" + (ocupada?"Ocupada":"Disponible");
    }
    
    
    
}
