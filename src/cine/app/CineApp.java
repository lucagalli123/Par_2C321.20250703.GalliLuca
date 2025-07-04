
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
        
        Navegacion navegacion = new Navegacion(stage, cine);
        navegacion.mostrarLogin();
    
        stage.setTitle("Cine");
        stage.setOnCloseRequest(e-> PersistenciaCine.guardarDatos(cine));
        
        stage.show();
    }
    
    
}
