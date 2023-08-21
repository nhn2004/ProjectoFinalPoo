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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class RegistroController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField organizacion;
    @FXML
    private TextField correo;
    @FXML
    private TextField contraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ingresarDatos(MouseEvent event) {
        try {
            Usuario.verificarCorreo(correo.getText());
            Usuario usuario = new Usuario(nombre.getText(),apellido.getText(), organizacion.getText(), correo.getText(), contraseña.getText());
            usuario.updateFile();
            SessionManager.getInstance().setUsuarioActual(usuario);
            try {
                App.setRoot("paginaUsuario");
            } catch (IOException ex) {
                
            }
            
            
        } catch (ObjetoExistente ex) {
            this.correo.setText("");
            Alert a= new Alert(Alert.AlertType.ERROR,ex.getMessage());
            a.show();
           
        }
        
        
    }

    @FXML
    private void regresar(MouseEvent event) {
        try {
            App.setRoot("inicio");
        } catch (IOException ex) {
           
        }
    } 
}
