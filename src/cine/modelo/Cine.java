
package cine.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cine implements Serializable {
    
    private List<Sala> salas;
    private List<Entrada> entradas;
    private HashMap<String,Cliente> clientes;
    private Sala salaSeleccionada;
    private Cliente clienteEnSesion;

    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.clientes = new HashMap<>();
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public Sala getSalaSeleccionada() {
        return salaSeleccionada;
    }

    public Cliente getClienteEnSesion() {
        return clienteEnSesion;
    }
    
    //-------------------------------------------
    
    public void agregarSala(Sala sala) {
        salas.add(sala);
    }
    
    public Cliente buscarClientePorNombre(String nombre) {
        return clientes.get(nombre);
    }
    
    public void setClienteEnSesion(Cliente cliente) {
        clienteEnSesion = cliente;
    }
    
    public void registrarCliente(String nombre, Cliente estudiante) {
        clientes.put(nombre, estudiante);
    }
    
    public void seleccionarSala(Sala sala) {
        salaSeleccionada = sala;
    }

    public void borrarSalaSeleccionada() {
        salaSeleccionada = null;
    }
    
    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }
    
    public void cerrarSesionCliente() {
        clienteEnSesion = null;
    }
    
    public boolean hayEntradasVendidas() {
        return !entradas.isEmpty();
            
        
    }
    
}
