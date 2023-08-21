/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class MisVehiculosController implements Initializable {

    @FXML
    private ComboBox<String> cbx;
    
    private Usuario usuario;
    @FXML
    private HBox hvehi;
    
    private ArrayList<Vehiculo> vehiculos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        usuario=SessionManager.getInstance().getUsuarioActual();
        vehiculos = SessionManager.getInstance().getUsuarioActual().getVehiculos();
        String[] categorias = {"Auto","Moto","Camioneta","Todos"};
        
        cbx.getItems().addAll(categorias);
        mostrarVehiculos(vehiculos);
        
        
    }    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario u) {
        
        usuario = u;
        
        vehiculos = u.getVehiculos();
        
        
    }
    
    private void mostrarVehiculos(ArrayList<Vehiculo> vehiculos) {
        hvehi.getChildren().clear();
    
        if (vehiculos == null || vehiculos.isEmpty()) {
            Text t = new Text("No hay vehiculos :(");
            t.setWrappingWidth(500);
            t.setTextAlignment(TextAlignment.LEFT);
            hvehi.getChildren().add(t);
        } else {
            for (Vehiculo v : vehiculos) {
                hvehi.getChildren().add(crearVBoxVehiculo(v));
            }
        }
    }

    private VBox crearVBoxVehiculo(Vehiculo v) {
        VBox cuadro = new VBox();
        cuadro.setSpacing(10);
        cuadro.setAlignment(Pos.CENTER);
        cuadro.setMinWidth(VBox.USE_PREF_SIZE);
        cuadro.setMaxWidth(VBox.USE_PREF_SIZE);
        cuadro.setMaxHeight(60);
        
        
        

        Image im = new Image(getClass().getResource("/ec/edu/espol/vehitrade/imagenes/"+v.getTipoVehiculo()+".png").toString());
        ImageView img = new ImageView(im);
        img.setFitHeight(200);
        img.setFitWidth(250);
        img.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION, v.toString());
            a.show();
        });

        Text datos = new Text("Marca: " + v.getMarca() + "\nModelo: " + v.getModelo() + "\nPlaca: " + v.getPlaca());
        datos.setWrappingWidth(300);
        datos.setTextAlignment(TextAlignment.CENTER);
        if (v.getOfertas().size()>0){
            Button aceptar = new Button(""+v.getOfertas().size()+" Ofertas");
            aceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
                SessionManager.getInstance().setVehiculoSeleccionado(v);
                    
                try {
                    App.setRoot("ofertasVehiculos");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            cuadro.getChildren().addAll(aceptar,img, datos);
                
        }
        else
            cuadro.getChildren().addAll(img, datos);

        return cuadro;
    }


    @FXML
    private void cerrarSesion(MouseEvent event) {
        usuario.updateFile();
        SessionManager.getInstance().cerrarSesion();
        try {  
            App.setRoot("iniciarSesion");
        } catch (IOException ex) {
           
        }
    }

    @FXML
    private void regresar(MouseEvent event) {
        try {
            App.setRoot("paginaUsuario");
        } catch (IOException ex) { 
        }
    }

    @FXML
    private void registrarNuevoVehiculo(MouseEvent event) {
        try {
            
            App.setRoot("registronuevoVehiculo");
        } catch (IOException ex) {
           
        }
    }

    @FXML
    private void filtrar(ActionEvent event) {
        ComboBox cb = (ComboBox)event.getSource();
        String s = (String)cb.getValue();
        ArrayList<Vehiculo> veh = new ArrayList<>();
        if (s.equals("Todos"))
            mostrarVehiculos(vehiculos);
        else{
        for (Vehiculo v : vehiculos){
            if(v.getTipoVehiculo().equals(s))
                veh.add(v);
        }
        mostrarVehiculos(veh);
        }
    }
    
}
