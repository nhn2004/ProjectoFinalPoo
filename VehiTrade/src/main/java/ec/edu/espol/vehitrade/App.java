package ec.edu.espol.vehitrade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

//    private static Scene scene;
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("inicio"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }
    private static Scene scene;
    private static Stage st;

    @Override
    public void start(Stage stage) throws IOException {
        st = stage;
        scene = new Scene(loadFXML("cartelera").load(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }
    
    public static void setScene(Scene sc) throws IOException {
        st.setScene(sc);
    }

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    
    public static void main(String[] args) {
        launch();
        Usuario u= new Usuario("Carlos Luis","Galarza Aveces",
                "ESPOL","clgal@espol.edu.ec","CarlosCarlos2004");
        Usuario u1= new Usuario("Nahin Jaimito","Cevallos Tomala",
                "ESPOL","ncevt@espol.edu.ec","JaimitoCev123");
        Usuario u2= new Usuario("Domenica Amy","Romero Piguave",
                "ESPOL","damr@espol.edu.ec","DomeDome2001");
        Usuario u3= new Usuario("Kenneth Josue","Echeverria Morales",
                "ESPOL","kjecheve@espol.edu.ec","Kjmorales");
        ArrayList<Usuario> lista= new ArrayList<>();
        lista.add(u);
        lista.add(u1);
        lista.add(u2);
        lista.add(u3);
        System.out.println(lista);
        Usuario.saveListSer(lista);
       // System.out.println(Usuario.readListSer());
//        IniciarSesionController controlador= new IniciarSesionController();
//        controlador.setLista(lista);
        Vehiculo v = new Vehiculo("GBO-8618","Aveo","Chevrolet","Grande",2001,2880.2,"Amarillo","Diesel", 10564.3);
        Vehiculo v2 = new Vehiculo("GSI-4423","Grand Vitara","Suzuki","MuyGrande",2020,3430.2,"Vino","Diesel", 90564.3);
        ArrayList<Vehiculo> vvv = new ArrayList<>();
        vvv.add(v);
        vvv.add(v2);
        Vehiculo.saveListSer(vvv);
        Vehiculo.saveVehiculo(v2);
        ArrayList<Vehiculo> listaV=Vehiculo.readListSer();
        System.out.println(listaV);
        
    }
        
    
}