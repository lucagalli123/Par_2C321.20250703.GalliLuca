
package cine.persistencia;

import cine.modelo.Cine;
import cine.modelo.Sala;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCine {
    
    private static final String ARCHIVO = "cine.der";
    
    public static void guardarDatos(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO)) ) {
            oos.writeObject(cine);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo. Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static Cine cargarDatos() {        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (Cine) ois.readObject();
        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo no encontrado. Error: " + fnf.getMessage()); 
            Sala sala1 = new Sala(1, "El resplandor", 2, 2);
            Sala sala2 = new Sala(2, "El exorcista", 4, 6);
            Sala sala3 = new Sala(3, "La llamada", 3, 5);
            Sala sala4 = new Sala(4, "Halloween", 2, 4);
            List<Sala> salas = new ArrayList<>();
            salas.add(sala1);
            salas.add(sala2);
            salas.add(sala3);
            salas.add(sala4);
            Cine cine = new Cine();
            cine.agregarSala(sala1);
            cine.agregarSala(sala2);
            cine.agregarSala(sala3);
            cine.agregarSala(sala4);
            return cine;   
        } catch (IOException | ClassNotFoundException ex) {   
            System.out.println("Error al cargar archivo. Error: " + ex.getMessage());       
            Sala sala1 = new Sala(1, "El resplandor", 2, 2);
            Sala sala2 = new Sala(2, "El exorcista", 4, 6);
            Sala sala3 = new Sala(3, "La llamada", 3, 5);
            Sala sala4 = new Sala(4, "Halloween", 2, 4);
            List<Sala> salas = new ArrayList<>();
            salas.add(sala1);
            salas.add(sala2);
            salas.add(sala3);
            salas.add(sala4);
            Cine cine = new Cine();
            cine.agregarSala(sala1);
            cine.agregarSala(sala2);
            cine.agregarSala(sala3);
            cine.agregarSala(sala4);
            return cine;
        }     
    }
    
}
