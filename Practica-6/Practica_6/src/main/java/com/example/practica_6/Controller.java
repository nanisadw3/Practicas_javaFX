package com.example.practica_6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();

    @FXML
    private TextField txt_Usuario;
    @FXML
    private TextField txt_Contrasena;
    @FXML
    private DatePicker date_picker;

    @FXML
    private void accion_Registrar(ActionEvent event) {
        try {
            String usuario = txt_Usuario.getText().trim();
            String contrasena = txt_Contrasena.getText().trim();
            LocalDate fecha = date_picker.getValue();

            if (usuario.isEmpty() || contrasena.isEmpty() || fecha == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Los datos no pueden estar vacíos");
            } else if (contrasena.length() < 6) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "La contraseña no puede tener menos de 6 caracteres");
            } else if (fecha.getYear() > 2012) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "El año debe ser menor que 2012");
            } else {
                Usuario u = new Usuario(usuario, contrasena, fecha.toString());
                usuarios.add(u);
                escribir();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Registro exitoso", usuario + " - " + contrasena + " se registró con éxito");
            }
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Se ha producido un error en el registro.");
        }
    }

    private void escribir() {
        try (BufferedWriter r = new BufferedWriter(new FileWriter("Usuarios.txt", true))) {
            for (Usuario u : usuarios) {
                r.write(u.toString() + "\n");
            }
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error en la creación y escritura de los datos.");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
