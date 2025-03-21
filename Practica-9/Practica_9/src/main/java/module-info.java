module com.example.practica_9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_9 to javafx.fxml;
    exports com.example.practica_9;
}