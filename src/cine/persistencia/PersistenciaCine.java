
package cine.persistencia;

import cine.modelo.Cine;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
        } catch (IOException | ClassNotFoundException ex) {   
            System.out.println("Error al cargar archivo. Error: " + ex.getMessage());           
        }
        return null;
    }
    
}
