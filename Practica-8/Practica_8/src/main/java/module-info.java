module com.example.practica_8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_8 to javafx.fxml;
    exports com.example.practica_8;
}