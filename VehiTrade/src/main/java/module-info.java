module ec.edu.espol.vehitrade {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.vehitrade to javafx.fxml;
    exports ec.edu.espol.vehitrade;
}
