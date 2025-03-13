module com.example.practica_01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_01 to javafx.fxml;
    exports com.example.practica_01;
}