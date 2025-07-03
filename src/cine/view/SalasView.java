
package cine.view;

import cine.controller.SalasController;
import cine.modelo.Sala;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SalasView extends VBox {

    private SalasController salasController;
    private Sala salaSeleccionada;
      
    public SalasView(SalasController salasController) {
    
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
    
        VBox vboxSuperior = new VBox();
        vboxSuperior.setSpacing(15);
        vboxSuperior.setPadding(new Insets(10));
        vboxSuperior.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER);
        Label lblSeleccionSala = new Label("Seleccione una sala:");
        ListView listViewSalas = new ListView<>();
        listViewSalas.getItems().addAll(salasController.getSalas());
        listViewSalas.setMaxHeight(150);
        vboxSuperior.getChildren().addAll(lblSeleccionSala, listViewSalas);
        
        HBox hboxInferior = new HBox();
        hboxInferior.setSpacing(15);
        hboxInferior.setPadding(new Insets(10));
        hboxInferior.setAlignment(Pos.CENTER);
        Button btbutacas = new Button("Butacas");
        Button btnVolver = new Button("Volver");
        Label lblMensaje = new Label();
        hboxInferior.getChildren().addAll(btbutacas, btnVolver);
        
        listViewSalas.setOnMouseClicked(e->{
            salaSeleccionada = (Sala) listViewSalas.getSelectionModel().getSelectedItem();
            lblMensaje.setText("Ha seleccionado: \n" + salaSeleccionada);
        });
        
        btbutacas.setOnAction(e->{
            if (salaSeleccionada != null) {
                salasController.seleccionarSala(salaSeleccionada);               
                salasController.mostrarButacas();
            } else {
                lblMensaje.setText("No selecciono una sala");
            }
        });
        
        btnVolver.setOnAction(e->{
            salasController.borrarSalaSeleccionada();
            salasController.mostrarMenu();
        });

        getChildren().addAll(vboxSuperior, hboxInferior, lblMensaje);
        
        
    
    }
    
}
