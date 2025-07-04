
package cine.modelo;

import java.io.Serializable;

public class Sala implements Serializable {
    
    private int numero;
    private String pelicula;
    private Butaca[][] butacas;
    private int cantButacas;
    private Butaca butacaSeleccionada;
    private boolean disponible;

    public Sala(int numero, String pelicula, int filas, int columnas) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.butacas = new Butaca[filas][columnas];
        this.cantButacas = (filas*columnas);
        this.disponible = true;
        inicializarSala();
    }

    public int getNumero() {
        return numero;
    }

    public boolean salaDisponible() {
        for (int fila = 0; fila < butacas.length; fila++) {
            for (int columna = 0; columna < butacas[fila].length; columna++) {
                Butaca butaca = butacas[fila][columna];
                if (!butaca.estaOcupada()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String getPelicula() {
        return pelicula;
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    public Butaca getButacaSeleccionada() {
        return butacaSeleccionada;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public int getCantButacas() {
        return cantButacas;
    }

    //----------------------------------------
    
    private void inicializarSala() {
        int contador = 1;
        for (int fila = 0; fila < butacas.length; fila++) {
            for (int col = 0; col < butacas[fila].length; col++) {
                butacas[fila][col] = new Butaca(contador, fila);
                contador++;  
            }
        }
        cantButacas = contador-1;
    }

    @Override
    public String toString() {
        return "Sala " + numero + ", pelicula: \"" + pelicula + "\"";
    }
    
//    public String toString(boolean verDisponibilidad) {
//        String texto;
//        if (estaDisponible()) {
//            texto = "DISPONIBLE";
//        } else {
//            texto = "NO DISPONIBLE";
//        }
//        return ("\" , " + "Sala " + numero + ", pelicula: \"" + pelicula + (verDisponibilidad?texto:""));
//    }

    public void seleccionarButaca(int numero) {
        for (int fila = 0; fila < butacas.length; fila++) {
            for (int columna = 0; columna < butacas[fila].length; columna++) {
                Butaca butaca = butacas[fila][columna];
                if (butaca.getNumero() == numero) {
                    butacaSeleccionada = butaca;                    
                }
            }
        }
    }
    
    public boolean butacaOcupada(int numero) {
        for (int fila = 0; fila < butacas.length; fila++) {
            for (int columna = 0; columna < butacas[fila].length; columna++) {
                Butaca butaca = butacas[fila][columna];
                if (butaca.getNumero() == numero && butaca.estaOcupada()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void borrarButacaSeleccionada() {
        butacaSeleccionada = null;
    }
    
//    public void ocuparUnaButaca() {
//        cantButacas--;
//        if (cantButacas == 0) {
//            disponible = false;
//        }
//    }

    public boolean hayButacaSeleccionada() {
        return butacaSeleccionada != null;
    }

}
