
package cine.view;

import cine.controller.MenuController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class MenuView extends VBox {
    
    private MenuController menuController;

    public MenuView(MenuController menuController) {
    
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        
        Label lblBienvenidos = new Label("MENU PRINCIPAL");
        Button btnSalas = new Button("Salas");
        btnSalas.setMaxWidth(150); 
        Button btnEntradasVendidas = new Button("Entradas vendidas");
        btnEntradasVendidas.setMaxWidth(150);
        Button btnCerrarSesion = new Button("Cerrar sesion");
        btnCerrarSesion.setMaxWidth(150);
        
        btnSalas.setOnAction(e->{
            menuController.mostrarSalas();
        });
        
        btnEntradasVendidas.setOnAction(e->{
            if (menuController.hayEntradasVendidas()) {
                menuController.mostrarEntradasVendidas();
            } else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION, "NO HAY ENTRADAS VENDIDAS");
                alerta.showAndWait();
            }
        });
        
        btnCerrarSesion.setOnAction(e->{
            menuController.borrarDatosDeSesion();
            menuController.mostrarLogin();           
        });
        
        getChildren().addAll(lblBienvenidos, btnSalas, btnEntradasVendidas, btnCerrarSesion);
        
        
    }
}
