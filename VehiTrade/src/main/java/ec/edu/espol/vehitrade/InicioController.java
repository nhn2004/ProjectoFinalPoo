/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class InicioController implements Initializable {

    @FXML
    private Button registro;
    @FXML
    private Button iniciarSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registro(MouseEvent event) {
    }

    @FXML
    private void iniciarSesion(MouseEvent event) {
    }

    @FXML
    private void switchToRegistro(ActionEvent event) throws IOException {
        App.setRoot("registro");
    }

    @FXML
    private void switchToIniciarSesion(ActionEvent event) throws IOException {
        App.setRoot("iniciarSesion");
    }
    
}
