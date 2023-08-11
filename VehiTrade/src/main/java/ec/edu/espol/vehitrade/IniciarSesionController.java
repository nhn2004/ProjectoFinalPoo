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
public class IniciarSesionController implements Initializable {

    @FXML
    private TextField correo;
    @FXML
    private TextField contraseña;
    @FXML
    private Button ingresar;
    @FXML
    private Button regresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verificar(MouseEvent event) {
    }

    @FXML
    private void switchToPaginaPrincipal(ActionEvent event) throws IOException {
        App.setRoot("inicio");
    }

    @FXML
    private void ingresarDatos(MouseEvent event) {
    }

    @FXML
    private void switchToInicio(ActionEvent event) throws IOException {
        App.setRoot("inicio");
    }
    
}
