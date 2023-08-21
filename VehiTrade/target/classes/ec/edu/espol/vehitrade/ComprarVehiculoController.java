/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.net.URL;
import java.util.ResourceBundle;
iimport javafx.event.ActionEvent;
import javafx.fxml.FXML;
mport javafx.fxml.Initializable;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author Dom
 */
public class ComprarVehiculoController implements Initializable {


    @FXML
    private ComboBox<?> cbx;
    @FXML
    private CheckBox faño;
    @FXML
    private CheckBox frecorrido;
    @FXML
    private CheckBox fprecio;
    @FXML
    private HBox hvehi;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void cerrarSesion(MouseEvent event) {
    }

    @FXML
    private void regresar(MouseEvent event) {
    }

    @FXML
    private void filtrar(ActionEvent event) {
    }

    @FXML
    private void filtrarFinal(MouseEvent event) {
    }

}
