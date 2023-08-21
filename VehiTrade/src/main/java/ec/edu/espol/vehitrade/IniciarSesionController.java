/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.vehitrade;

import ec.edu.espol.vehitrade.App;
import ec.edu.espol.vehitrade.DigitosInvalidos;
import ec.edu.espol.vehitrade.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private void verificar(MouseEvent event) throws IOException {
        
        try {
            Usuario u = Usuario.verificarUsuario( correo.getText(), contraseña.getText());
//            Alert a= new Alert(Alert.AlertType.INFORMATION,"Usuario Correcto");
//            a.show();
              App.setRoot("opciones");
        } catch (DigitosInvalidos ex) {
            Alert a= new Alert(Alert.AlertType.ERROR,ex.getMessage());
            a.show();
        }
    }

    

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

    @FXML
    private void switchToInicio(MouseEvent event) {
    }
}
