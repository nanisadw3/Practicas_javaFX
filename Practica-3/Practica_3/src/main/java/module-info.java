module com.example.practica_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_3 to javafx.fxml;
    exports com.example.practica_3;
}