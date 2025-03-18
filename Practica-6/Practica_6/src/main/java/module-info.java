module com.example.practica_6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.practica_6 to javafx.fxml;
    exports com.example.practica_6;
}