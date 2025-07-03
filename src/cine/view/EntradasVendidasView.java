
package cine.view;

import cine.controller.EntradasVendidasController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class EntradasVendidasView extends VBox {

    private EntradasVendidasController entradasVendidasController;

    public EntradasVendidasView(EntradasVendidasController entradasVendidasController) {
        
        setSpacing(40);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        
        Label lblEntradasVendidas = new Label("ENTRADAS VENDIDAS");
        ListView listViewSalas = new ListView<>();
        listViewSalas.getItems().addAll(entradasVendidasController.getEntradasVendidas());
        listViewSalas.setMaxHeight(150);
        Button btnVolver = new Button("Volver");
        
        btnVolver.setOnAction(e->{
            entradasVendidasController.mostrarMenu();
        });
        
        
        getChildren().addAll(lblEntradasVendidas, listViewSalas, btnVolver);
        
    }
    
    
    
    
    
}
