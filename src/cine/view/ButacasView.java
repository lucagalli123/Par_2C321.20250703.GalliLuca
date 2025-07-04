
package cine.view;

import cine.controller.ButacasController;
import cine.modelo.Butaca;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ButacasView extends VBox {

    private ButacasController butacasController;
    
    public ButacasView(ButacasController butacasController) {
 
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
    
        VBox vboxSuperior = new VBox();
        vboxSuperior.setSpacing(15);
        vboxSuperior.setPadding(new Insets(10));
        vboxSuperior.setAlignment(Pos.CENTER);
        Label lblPantalla = new Label("----------------  PANTALLA  ----------------");
        vboxSuperior.getChildren().addAll(lblPantalla);
      
        GridPane gridPaneMedio = new GridPane();
        gridPaneMedio.setVgap(20);
        gridPaneMedio.setHgap(20);
        gridPaneMedio.setAlignment(Pos.CENTER);
        
        Butaca[][] butacas = butacasController.getButacas();
        
        for (int fila = 0; fila < butacas.length; fila++) {
            for (int columna = 0; columna < butacas[fila].length; columna++) {
                Label lblButaca = new Label(butacas[fila][columna].toString());
                if (butacas[fila][columna].estaOcupada()) {
                    lblButaca.setBackground(new Background(new BackgroundFill(Color.rgb(250, 100, 100), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    lblButaca.setMaxSize(120, 120);
                    lblButaca.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                }
                gridPaneMedio.add(lblButaca, columna, fila);
            }
        }
        
        //------------------------------------------------------
        
        HBox hboxIngresoButaca = new HBox();
        hboxIngresoButaca.setSpacing(15);
        hboxIngresoButaca.setPadding(new Insets(10));
        hboxIngresoButaca.setAlignment(Pos.CENTER);
        Label lblIngresoButaca = new Label("Ingrese numero de butaca:");
        TextField campoIngresoButaca = new TextField();
        campoIngresoButaca.setMaxWidth(50);
        hboxIngresoButaca.getChildren().addAll(lblIngresoButaca, campoIngresoButaca);
        
        //------------------------------------------------------
        
        HBox hboxBotones = new HBox();
        hboxBotones.setSpacing(30);
        hboxBotones.setPadding(new Insets(10));
        hboxBotones.setAlignment(Pos.CENTER);
        Button btnAceptar = new Button("Aceptar");
        btnAceptar.setMaxWidth(80);
        Button btnVolver = new Button("Volver");
        btnVolver.setMaxWidth(80);
        hboxBotones.getChildren().addAll(btnAceptar, btnVolver);

        //------------------------------------------------------
        
        VBox vboxMensajeButaca = new VBox();
        vboxMensajeButaca.setSpacing(15);
        vboxMensajeButaca.setPadding(new Insets(10));
        vboxMensajeButaca.setAlignment(Pos.CENTER);
        Label lblMensajeButaca = new Label();
        vboxMensajeButaca.getChildren().addAll(lblMensajeButaca);
         
        VBox vboxBotonComprar = new VBox();
        vboxBotonComprar.setSpacing(15);
        vboxBotonComprar.setPadding(new Insets(10));
        vboxBotonComprar.setAlignment(Pos.CENTER);
        Button btnComprar = new Button("Comprar");
        btnComprar.setMaxWidth(110);
        vboxBotonComprar.getChildren().addAll(btnComprar);
        
        btnAceptar.setOnAction(e->{
            try {
                String numeroButacaString = campoIngresoButaca.getText();
                if (!numeroButacaString.isEmpty()) {
                    int numeroButaca = Integer.parseInt(numeroButacaString);
                    if (numeroButaca < 1 || numeroButaca > butacasController.getNumeroDeButacas()) {
                        lblMensajeButaca.setText("Fuera de rango*");
                    } else {
                        if (!butacasController.butacaOcupada(numeroButaca)) {
                            butacasController.seleccionarButaca(numeroButaca);
                            lblMensajeButaca.setText("Ha seleccionado la butaca " + butacasController.getSalaSeleccionada().getButacaSeleccionada().getNumero());    
                        } else {
                            lblMensajeButaca.setText("Butaca " + numeroButacaString + " ocupada*");
                        }
                    }
                } else {
                    lblMensajeButaca.setText("Ingrese un numero*");
                }
            } catch (NumberFormatException nfe) {
                lblMensajeButaca.setText("Formato invalido*");
            }
        });
        
        btnComprar.setOnAction(e->{
            if (butacasController.hayButacaSeleccionada()) {
                butacasController.mostrarCompra();
            }
        });
        
        btnVolver.setOnAction(e->{
            butacasController.borrarButacaSeleccionada();
            butacasController.mostrarSalas();
        });
        
        getChildren().addAll(vboxSuperior, gridPaneMedio, hboxIngresoButaca, vboxMensajeButaca, hboxBotones, vboxBotonComprar);
    }
}
