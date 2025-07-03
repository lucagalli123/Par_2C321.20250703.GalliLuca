
package cine.view;

import cine.controller.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {
 
    private LoginController loginController;

    public LoginView(LoginController loginController) {
    
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        
        VBox vboxSuperior = new VBox();
        vboxSuperior.setSpacing(15);
        vboxSuperior.setPadding(new Insets(15));
        vboxSuperior.setAlignment(Pos.CENTER);
        Label lblNombre = new Label("Cliente:");
        TextField campoNombre = new TextField();
        campoNombre.setMaxWidth(200);
        Label lblContrasenia = new Label("Contraseña:");
        PasswordField campoContrasenia = new PasswordField();
        campoContrasenia.setMaxWidth(200);
        Label lblMensaje = new Label("");
        vboxSuperior.getChildren().addAll(lblNombre, campoNombre, lblContrasenia, campoContrasenia, lblMensaje);
        
        HBox hboxInferior = new HBox();
        hboxInferior.setSpacing(43);
        hboxInferior.setPadding(new Insets(20));
        hboxInferior.setAlignment(Pos.CENTER);
        Button btnIniciarSesion = new Button("Iniciar sesion");
        Button btnRegistrarse = new Button("Registrarse");
        hboxInferior.getChildren().addAll(btnIniciarSesion, btnRegistrarse);
        
        btnIniciarSesion.setOnAction(e->{
            String cliente = campoNombre.getText();
            String contrasenia = campoContrasenia.getText();
            if (cliente.isEmpty() || contrasenia.isEmpty()) {
                lblMensaje.setText("Complete todos los campos*");
            } else {
                boolean inicioDeSesion = loginController.iniciarSesion(cliente, contrasenia);
                if (!inicioDeSesion) {
                    lblMensaje.setText("Cliente o pin incorrecto*");
                }
            }
        });
        
        btnRegistrarse.setOnAction(e->{
            loginController.mostrarRegistrarse();
        });
        
        getChildren().addAll(vboxSuperior, hboxInferior);
    }
}
