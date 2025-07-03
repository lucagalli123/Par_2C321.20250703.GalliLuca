
package cine.view;

import cine.controller.CompraController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CompraView extends VBox {
    
    private CompraController compraController;

    public CompraView(CompraController compraController) {
        
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        
        VBox vboxPrevisualizacion = new VBox();
        vboxPrevisualizacion.setSpacing(20);
        vboxPrevisualizacion.setPadding(new Insets(20));
        vboxPrevisualizacion.setAlignment(Pos.CENTER);
        Label lblPrevisualizacion = new Label("PREVISUALIZACION");
        Label lblEntradaDatos = new Label(compraController.previsualizarEntrada());
        Button btnConfirmarCompra = new Button("Confirmar compra");
        vboxPrevisualizacion.getChildren().addAll(lblPrevisualizacion, lblEntradaDatos);
        
        HBox hboxBotones = new HBox();
        hboxBotones.setSpacing(20);
        hboxBotones.setPadding(new Insets(20));
        hboxBotones.setAlignment(Pos.CENTER);
        Button btnConfirmar = new Button("Confirmar");
        Button btnCancelar = new Button("Cancelar");
        hboxBotones.getChildren().addAll(btnConfirmar, btnCancelar);
        
        btnConfirmar.setOnAction(e->{
            compraController.realizarCompra();            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, "¡COMPRA COMFIRMADA!\n\n" + compraController.previsualizarEntrada());
            alerta.showAndWait();
            compraController.borrarDatosDeSesion();         
            compraController.mostrarMenu();
        });
        
        btnCancelar.setOnAction(e->{           
            compraController.borrarDatosDeSesion();           
            compraController.mostrarMenu();
        });
        
        getChildren().addAll(vboxPrevisualizacion, hboxBotones);
        
        
    }
    
    
    
}
