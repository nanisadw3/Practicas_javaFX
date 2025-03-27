module com.example.practica_10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.practica_10 to javafx.fxml;
    exports com.example.practica_10;
}