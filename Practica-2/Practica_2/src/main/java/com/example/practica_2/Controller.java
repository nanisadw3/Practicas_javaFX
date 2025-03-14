package com.example.practica_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField txt_clave = new TextField();
    @FXML
    TextField txt_nombre = new TextField();
    @FXML
    TextField txt_apellidoP = new TextField();
    @FXML
    TextField txt_apellidoM = new TextField();
    @FXML
    TextField txt_salario = new TextField();
    @FXML
    private void accionAgregar(ActionEvent event) {
        try {
            String nombre = txt_nombre.getText();
            String apellidoP = txt_apellidoP.getText();
            String apellidoM = txt_apellidoM.getText();
            String clave = txt_clave.getText();
            int satario = Integer.parseInt(txt_salario.getText());
            Empleados e = new Empleados(nombre, apellidoP, apellidoM, clave, satario);
            String correo = e.generarCorreo();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Empleado Agregado");
            alerta.setHeaderText("El correo es: " + correo);
            alerta.setContentText(e.toString());
            alerta.showAndWait();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }
}