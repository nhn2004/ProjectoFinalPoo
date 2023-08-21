package ec.edu.espol.vehitrade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("inicio"), 800, 550);
        
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        
    }
    
    
    

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    
    
    public static void main(String[] args) {
        launch();
//        Usuario u= new Usuario("Carlos Luis","Galarza Aveces",
//                "ESPOL","clgal@espol.edu.ec","CarlosCarlos2004");
//        Usuario u1= new Usuario("Nahin Jaimito","Cevallos Tomala",
//                "ESPOL","ncevt@espol.edu.ec","JaimitoCev123");
//        Usuario u2= new Usuario("Domenica Amy","Romero Piguave",
//                "ESPOL","damr@espol.edu.ec","DomeDome2001");
//        Usuario u3= new Usuario("Kenneth Josue","Echeverria Morales",
//                "ESPOL","kjecheve@espol.edu.ec","Kjmorales");
//        ArrayList<Usuario> lista= new ArrayList<>();
//        lista.add(u);
//        lista.add(u1);
//        lista.add(u2);
//        lista.add(u3);
//        System.out.println(lista);
//        Usuario.saveListSer(lista);
//        IniciarSesionController controlador= new IniciarSesionController();
//        controlador.setLista(lista);
        
        
    }
        
    
}