
package cine.controller;

import cine.modelo.Cine;
import cine.view.ButacasView;
import cine.view.CompraView;
import cine.view.EntradasVendidasView;
import cine.view.LoginView;
import cine.view.MenuView;
import cine.view.RegistroView;
import cine.view.SalasView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navegacion {
    
    private Cine cine;
    private Stage stage;

    public Navegacion(Stage stage, Cine cine) {
        this.stage = stage;
        this.cine = cine;
    }
    
    public void mostrarLogin() {
        LoginController loginController = new LoginController(cine, this);
        LoginView loginView = new LoginView(loginController);
        stage.setScene(new Scene(loginView, 650, 700));
    }
    
    public void mostrarRegistrarse() {
        RegistroController registroController = new RegistroController(cine, this);
        RegistroView registroView = new RegistroView(registroController);
        stage.setScene(new Scene(registroView, 650, 700));
    }
    
    public void mostrarMenu() {
        MenuController menuController = new MenuController(cine, this);
        MenuView menuView = new MenuView(menuController);
        stage.setScene(new Scene(menuView, 650, 700));
    }
    
    public void mostrarSalas() {
        SalasController salasController = new SalasController(cine, this);
        SalasView salasView = new SalasView(salasController);
        stage.setScene(new Scene(salasView, 650, 700));
    }

    public void mostrarButacas() {
        ButacasController butacasController = new ButacasController(cine, this);
        ButacasView butacasView = new ButacasView(butacasController);
        stage.setScene(new Scene(butacasView, 650, 700));
    }
    
    public void mostrarCompra() {
        CompraController compraController = new CompraController(cine, this);
        CompraView compraView = new CompraView(compraController);
        stage.setScene(new Scene(compraView, 650, 700));
    }

    void mostrarEntradasVendidas() {
        EntradasVendidasController entradasVendidasController = new EntradasVendidasController(cine, this);
        EntradasVendidasView entradasVendidasView = new EntradasVendidasView(entradasVendidasController);
        stage.setScene(new Scene(entradasVendidasView, 650, 700));
    }
    
    
}
