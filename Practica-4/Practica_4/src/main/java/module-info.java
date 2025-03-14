module com.example.practica_4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.practica_4 to javafx.fxml;
    exports com.example.practica_4;
}