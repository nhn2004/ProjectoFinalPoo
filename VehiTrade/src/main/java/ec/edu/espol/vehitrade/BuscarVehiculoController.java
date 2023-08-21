/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.vehitrade;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Dom
 */
public class BuscarVehiculoController implements Initializable {
    @FXML
   
    private ComboBox<String> cbx;
    @FXML
    private CheckBox faño;
    @FXML
    private HBox hvehi;
    @FXML
    private CheckBox frecorrido;
    @FXML
    private CheckBox fprecio;
    
    private ArrayList<Vehiculo> vehiculos;
    private double maxAno;
    private double minAno;
    private double maxRecorrido;
    private double minRecorrido;
    private double maxPrecio;
    private double minPrecio;
    private String tipoVehiculoSeleccionado;
    
    private Usuario usuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuario=SessionManager.getInstance().getUsuarioActual();
        vehiculos = Vehiculo.readListSer();
        // TODO
        faño.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mostrarDialogoRango("Año", minAno, maxAno, (min, max) -> {
                    minAno = min;
                    maxAno = max;
                });
            }
        });

        frecorrido.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mostrarDialogoRango("Recorrido", minRecorrido, maxRecorrido, (min, max) -> {
                    minRecorrido = min;
                    maxRecorrido = max;
                });
            }
        });
        
        fprecio.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                mostrarDialogoRango("Precio", minPrecio, maxPrecio, (min, max) -> {
                    minPrecio = min;
                    maxPrecio = max;
                });
            }
        });
        String[] categorias = {"Auto","Moto","Camioneta","Todos"};
        
        cbx.getItems().addAll(categorias);
//        mostrarVehiculos(vehiculos);
    }    

//    @FXML
//    private void cerrarSesion(MouseEvent event) {
//        Stage stage = (Stage) cbx.getScene().getWindow();
//        stage.setHeight(550);
//        usuario.updateFile();
//        SessionManager.getInstance().cerrarSesion();
//        
//        try {
//            
//            App.setRoot("iniciarSesion");
//        } catch (IOException ex) {
//           
//        }
//    }

    @FXML
    private void regresar(MouseEvent event) {
        Stage stage = (Stage) cbx.getScene().getWindow();
        stage.setHeight(550);
        try {
            
            App.setRoot("paginaUsuario");
        } catch (IOException ex) {
           
        }
    
    }

    @FXML
    private void filtrar(ActionEvent event) {
        ComboBox cb = (ComboBox)event.getSource();
        tipoVehiculoSeleccionado = (String)cb.getValue();
    }

    @FXML
    private void filtrarFinal(MouseEvent event) {
        ArrayList<Vehiculo> veh = vehiculos;
        if(cbx.getValue() != null && !cbx.getValue().equals("Todos"))
            veh = Utilitaria.filtrarTipoVehiculo(veh, tipoVehiculoSeleccionado);
        else if (faño.isSelected())
            veh = Utilitaria.filtrarAño(veh, minAno, maxAno);
        else if (frecorrido.isSelected())
            veh = Utilitaria.filtrarRecorrido(veh, minRecorrido, maxRecorrido);
        else if (fprecio.isSelected())
            veh = Utilitaria.filtrarPrecio(veh, minPrecio, maxPrecio);
        mostrarVehiculos(veh);
    }
    private void mostrarDialogoRango(String titulo, double valorMinimoActual, double valorMaximoActual, BiConsumer<Double, Double> callback) {
        // Crear el cuadro de diálogo
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Filtrar por " + titulo);
        dialog.setHeaderText("Ingrese el rango para " + titulo);

        // Define los botones
        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType);

        // Crea los campos de texto y las etiquetas
        TextField minTextField = new TextField();
        minTextField.setPromptText(String.valueOf(valorMinimoActual));
        TextField maxTextField = new TextField();
        maxTextField.setPromptText(String.valueOf(valorMaximoActual));

        GridPane grid = new GridPane();
        grid.add(new Label("Min:"), 0, 0);
        grid.add(minTextField, 1, 0);
        grid.add(new Label("Max:"), 0, 1);
        grid.add(maxTextField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        // Obtiene los valores cuando se presiona "OK"
        dialog.setResultConverter(dialogButton -> new Pair<>(minTextField.getText(), maxTextField.getText()));

        // Muestra el cuadro de diálogo y procesa la respuesta
        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            try {
                double min = Double.parseDouble(pair.getKey());
                double max = Double.parseDouble(pair.getValue());
                callback.accept(min, max);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Valores inválidos");
                alert.show();
            }
        });
    }
    
//    private void mostrarDialogoRango(String titulo, double valorMinimoActual, double valorMaximoActual, BiConsumer<Double, Double> callback) {
//        // Crear el cuadro de diálogo...
//        TextInputDialog dialog = new TextInputDialog(valorMinimoActual + "-" + valorMaximoActual);
//        dialog.setTitle("Filtrar por " + titulo);
//        dialog.setHeaderText("Ingrese el rango para " + titulo);
//        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//
//        // Setea los botones al cuadro de diálogo
//        dialog.getDialogPane().getButtonTypes().addAll(okButtonType);
//
//        // Crear los campos de texto para min y max
//        TextField minTextField = new TextField(String.valueOf(valorMinimoActual));
//        TextField maxTextField = new TextField(String.valueOf(valorMaximoActual));
//
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.add(new Label("Mínimo:"), 0, 0);
//        grid.add(minTextField, 1, 0);
//        grid.add(new Label("Máximo:"), 0, 1);
//        grid.add(maxTextField, 1, 1);
//
//        dialog.getDialogPane().setContent(grid);
//
//        // Convertir la entrada del usuario en un par de strings
//        dialog.setResultConverter(dialogButton -> {
//            if (dialogButton == okButtonType) {
//                return new Pair<>(minTextField.getText(), maxTextField.getText());
//            }
//            return null;
//        });
//
//        dialog.getDialogPane().setContent(grid);
//
//        // Obtiene los valores cuando se presiona "OK"
//        dialog.setResultConverter(dialogButton -> {
//            return new Pair<>(minTextField.getText(), maxTextField.getText());
//        });
//
//        // Muestra el cuadro de diálogo y procesa la respuesta
//        Optional<Pair<String, String>> result = dialog.showAndWait();
//
//        result.ifPresent(pair -> {
//            System.out.println("Min: " + pair.getKey() + ", Max: " + pair.getValue());
//            // Aquí puedes asignar los valores obtenidos a tus atributos minAño y maxAño, por ejemplo:
//            minAño = Integer.parseInt(pair.getKey());
//            maxAño = Integer.parseInt(pair.getValue());
//        });
////        
////        dialog.setContentText("Min:");
////        dialog.setContentText("Max:");
////
////        Optional<String> result = dialog.showAndWait();
////        result.ifPresent(rango -> {
////            String[] valores = rango.split("-");
////            if (valores.length == 2) {
////                try {
////                    double min = Double.parseDouble(valores[0].trim());
////                    double max = Double.parseDouble(valores[1].trim());
////                    callback.accept(min, max);
////                } catch (NumberFormatException e) {
////                    Alert alert = new Alert(Alert.AlertType.ERROR, "Valores inválidos");
////                    alert.show();
////                }
////            }
////        });
//    }

//    private void mostrarVehiculos(ArrayList<Vehiculo> vehiculos) {
//        hvehi.getChildren().clear();
//    
//        if (vehiculos == null || vehiculos.isEmpty()) {
//            Text t = new Text("No hay vehiculos :(");
//            t.setWrappingWidth(500);
//            t.setTextAlignment(TextAlignment.LEFT);
//            hvehi.getChildren().add(t);
//        } else {
//            for (Vehiculo v : vehiculos) {
//                
//                hvehi.getChildren().add(crearVBoxVehiculo(v));
//            }
//        }
//    }
//
//    private VBox crearVBoxVehiculo(Vehiculo v) {
//        VBox cuadro = new VBox();
//        cuadro.setSpacing(10);
//        cuadro.setAlignment(Pos.CENTER);
//        cuadro.setMinWidth(VBox.USE_PREF_SIZE);
//        cuadro.setMaxWidth(VBox.USE_PREF_SIZE);
//        cuadro.setMaxHeight(60);
//
//        Image im = new Image(getClass().getResource("/ec/edu/espol/vehitrade/imagenes/"+v.getTipoVehiculo()+".png").toString());
//        ImageView img = new ImageView(im);
//        img.setFitHeight(200);
//        img.setFitWidth(250);
//        
//        
//        Text datos = new Text("Marca: " + v.getMarca() + "\nModelo: " + v.getModelo() + "\nPlaca: " + v.getPlaca());
//        datos.setWrappingWidth(300);
//        datos.setTextAlignment(TextAlignment.CENTER);
//
//        Button aceptar = new Button("Seleccionar");
//                aceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
//                    SessionManager.getInstance().setVehiculoSeleccionado(v);
//                    Stage stage = (Stage) cbx.getScene().getWindow();
//                    stage.setHeight(620);
//                    try {
//                        App.setRoot("generarOferta");
//                    } catch (IOException ex) {
//                    }
//                });
//
//        cuadro.getChildren().addAll(img, datos,aceptar);
//
//        return cuadro;
//    }
//    
    
}
