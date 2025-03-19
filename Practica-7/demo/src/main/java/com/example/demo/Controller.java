package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final ArrayList<Alumnos> alumnos = new ArrayList<>();

    @FXML
    private ComboBox<String> combo_Nombres;
    @FXML
    private TextField txt_Fecha;
    @FXML
    private CheckBox chk_Asistio;

    @FXML
    private void mostrar_lista(ActionEvent event) {
        for (Alumnos alumno : alumnos) {
            String asistencia = alumno.asistencia == 1 ? "Asistió" : "Faltó";

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alumnos");
            alert.setHeaderText(null);
            alert.setContentText("El alumno " + alumno.nombre + " " + asistencia);
            alert.showAndWait();
        }
    }

    @FXML
    private void pasar_Lista(ActionEvent event) {
        try {
            String nombre = combo_Nombres.getValue(); // Obtener el nombre seleccionado correctamente
            if (nombre == null || nombre.trim().isEmpty()) {
                mostrarError("Debe seleccionar un nombre.");
                return;
            }

            String fecha = txt_Fecha.getText();
            int asis = chk_Asistio.isSelected() ? 1 : 0;

            Alumnos al = new Alumnos(nombre, fecha, asis);
            alumnos.add(al);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alumnos");
            alert.setHeaderText(null);
            alert.setContentText("Se agregó el alumno: " + nombre);
            alert.showAndWait();

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leer();

        // Obtener la fecha actual en formato dd/MM/yy
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateada = fechaHoy.format(formato);

        txt_Fecha.setText(fechaFormateada);
    }

    private void leer() {
        try (BufferedReader br = new BufferedReader(new FileReader("nombres.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                combo_Nombres.getItems().add(linea);
            }
        } catch (Exception e) {
            mostrarError("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
