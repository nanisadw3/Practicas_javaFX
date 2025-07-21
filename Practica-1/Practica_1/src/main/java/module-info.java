module com.example.practica_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_1 to javafx.fxml;
    exports com.example.practica_1;
}