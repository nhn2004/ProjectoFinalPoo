/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dom
 */
public class RegistrarVehiculoController implements Initializable {

    private TextField placa;
    @FXML
    private TextField modelo;
    @FXML
    private TextField marca;
    @FXML
    private TextField tipoMotor;
    private TextField año;
    private TextField recorrido;
    @FXML
    private TextField color;
    @FXML
    private TextField tipoCombustible;
    private TextField precio;
    @FXML
    private TextField añoInicio;
    @FXML
    private TextField recorridoInicio;
    @FXML
    private TextField precioInicio;
    @FXML
    private TextField añoFinal;
    @FXML
    private TextField recorridoFInal;
    @FXML
    private TextField precioFinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void registrarVehiculo(MouseEvent event) {
        Vehiculo v= new Vehiculo(placa.getText(),modelo.getText(),marca.getText(),tipoMotor.getText(),Integer.parseInt(año.getText()),Double.parseDouble(recorrido.getText()),color.getText(),tipoCombustible.getText(),Double.parseDouble(precio.getText()));
        try {
            Vehiculo.verificarPlaca(placa.getText());
            Alert a = new Alert(Alert.AlertType.ERROR, "Este vehiculo ya está registrado");
            a.show();
            
        } catch (DigitosInvalidos ex) {
            Vehiculo.saveVehiculo(v);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Se ha registrado correctamente");
            a.show();       
        }
    }

    @FXML
    private void switchToOpciones(MouseEvent event) throws IOException {
        App.setRoot("opciones");
    }

    @FXML
    private void switchToInicio(MouseEvent event) {
    }

    @FXML
    private void buscarVehiculo(MouseEvent event) {
        ArrayList<Vehiculo> vehiculos = Vehiculo.readListSer();
        ArrayList<Vehiculo> vehFiltrados = Utilitaria.filtrarVehiculos(vehiculos, Double.parseDouble(recorridoInicio.getText()), Double.parseDouble(recorridoFInal.getText()), Integer.parseInt(añoInicio.getText()), Integer.parseInt(añoFinal.getText()), Double.parseDouble(precioInicio.getText()), Double.parseDouble(precioFinal.getText()));
        Alert a = new Alert(Alert.AlertType.INFORMATION, vehFiltrados.toString());
        a.show(); 
    }
    
}
