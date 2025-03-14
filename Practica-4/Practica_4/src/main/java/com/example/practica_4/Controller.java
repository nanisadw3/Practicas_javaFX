package com.example.practica_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    ArrayList<Alumnos>list = new ArrayList<>();
    @FXML
    private TextField txt_cuenta;
    @FXML
    private TextField txt_nombre;

    @FXML
    private void accionAgregar(ActionEvent event) {
        try {
            String cuenta = txt_cuenta.getText();
            String nombre = txt_nombre.getText();
            if(cuenta.equals("") || nombre.equals("")) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Llena todos los campos");
                alert.showAndWait();
            }else{
                Alumnos alumno = new Alumnos(nombre, cuenta);
                list.add(alumno);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Agregar Alumno");
                alert.setHeaderText("Alumno " + nombre + " registrado");
                alert.setContentText(null);
                alert.showAndWait();
                txt_cuenta.clear();
                txt_nombre.clear();
            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }
    }
    @FXML
    private void accionMostrar(ActionEvent event) {
        try {
            if (list.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("No existe ningun alumno");
                alert.showAndWait();

            }else{
                for (Alumnos alumno : list) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alumno");
                    alert.setHeaderText("Alumno " + alumno.nombre);
                    alert.setContentText(null);
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}