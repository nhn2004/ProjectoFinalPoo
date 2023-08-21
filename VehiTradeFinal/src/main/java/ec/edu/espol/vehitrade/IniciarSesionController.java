/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verificar(MouseEvent event) {
        try {
            
            Usuario u = Usuario.verificarUsuario( correo.getText(), contraseña.getText());
            
            SessionManager.getInstance().setUsuarioActual(u);
//            try {
//                App.setRoot("paginaUsuario");
//            } catch (IOException ex) {
//            }
//            try {
//                FXMLLoader loader = App.loadFXMM("misVehiculos");
//                Parent root = loader.load();
//                MisVehiculosController controller = loader.getController();
//                controller.setUsuario(u);
//                App.setScene(new Scene(root, 640, 480));
//            } catch (IOException ex) {
//                Alert b= new Alert(Alert.AlertType.INFORMATION,"ocurrio algo");
//                b.show();
//            }
            try {
                App.setRoot("paginaUsuario");
            } catch (IOException ex) {
           
            }
            
            
        } catch (DigitosInvalidos ex) {
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