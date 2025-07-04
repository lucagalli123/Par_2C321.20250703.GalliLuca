
package cine.app;

import cine.controller.Navegacion;
import cine.modelo.Cine;
import cine.modelo.Sala;
import cine.persistencia.PersistenciaCine;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class CineApp extends Application {

    private Cine cine;
    
    public static void main(String[] args) {
        launch(args);   
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        cine = PersistenciaCine.cargarDatos();        
        
        if (cine == null) {
            Sala sala1 = new Sala(1, "El resplandor", 2, 2);
            Sala sala2 = new Sala(2, "El exorcista", 4, 6);
            Sala sala3 = new Sala(3, "La llamada", 3, 5);
            Sala sala4 = new Sala(4, "Halloween", 2, 4);
            List<Sala> salas = new ArrayList<>();
            salas.add(sala1);
            salas.add(sala2);
            salas.add(sala3);
            salas.add(sala4);
            cine = new Cine();
            cine.agregarSala(sala1);
            cine.agregarSala(sala2);
            cine.agregarSala(sala3);
            cine.agregarSala(sala4);
        }
          
        Navegacion navegacion = new Navegacion(stage, cine);
        navegacion.mostrarLogin();
    
        stage.setTitle("Cine");
        stage.setOnCloseRequest(e-> PersistenciaCine.guardarDatos(cine));
        
        stage.show();
    }
    
    
}
