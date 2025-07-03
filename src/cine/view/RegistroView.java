
package cine.view;

import cine.controller.RegistroController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegistroView extends VBox {

    private RegistroController registroController;
    
    public RegistroView(RegistroController registroController) {
    
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        
        Label lblNombre = new Label("Nombre:");
        TextField campoNombre = new TextField();
        campoNombre.setMaxWidth(200);
        Label lblEmail = new Label("Email:");
        TextField campoEmail = new TextField();
        campoEmail.setMaxWidth(200);
        Label lblPin = new Label("Pin:");
        TextField campoPin = new TextField();
        campoPin.setMaxWidth(200);
        Button btnRegistrarse = new Button("Registrarse");
        Label lblMensaje = new Label();
        Button btnVolver = new Button("Volver");
    
        btnRegistrarse.setOnAction(e->{
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String pin = campoPin.getText();
            if (nombre.isEmpty() || email.isEmpty() || pin.isEmpty()) {
                lblMensaje.setText("Complete todos los campos*");
            } else {
                boolean registroDeEstudiante = registroController.registrarCliente(nombre, email, pin);
                if (!registroDeEstudiante) {
                    lblMensaje.setText("Ya existe un cliente con ese nombre*");
                } else {
                    lblMensaje.setText("¡Cliente registrado!");
                }
            }
        });
        
        btnVolver.setOnAction(e->{
            registroController.mostrarLogin();
        });
        
        getChildren().addAll(lblNombre, campoNombre, lblEmail, campoEmail, lblPin, campoPin, btnRegistrarse, lblMensaje, btnVolver);
    
    }
    
}
