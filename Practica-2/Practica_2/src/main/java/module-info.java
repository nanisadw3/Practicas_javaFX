module com.example.practica_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_2 to javafx.fxml;
    exports com.example.practica_2;
}