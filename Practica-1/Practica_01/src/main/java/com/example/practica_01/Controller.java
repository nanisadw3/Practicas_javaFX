package com.example.practica_01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    //Programa 1
    @FXML
    private TextField txt_saldo;
    @FXML
    private TextField txt_cuenta;
    @FXML
    private TextField txt_anualidad;
    @FXML
    private TextField txt_titular;

    @FXML
    private void btn_Capturar(ActionEvent event) {
        try {


        int saldo = Integer.parseInt(txt_saldo.getText());
        String cuenta = txt_cuenta.getText();
        String anualidad = txt_anualidad.getText();
        String titular = txt_titular.getText();
        Cuenta c = new Cuenta(cuenta, anualidad, titular, saldo);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Capturar");
        alert.setHeaderText("Se capturaron los datos de la cuenta" + cuenta);
        alert.setContentText("Cuenta " + cuenta + " Saldo " + saldo + " Anualidad " + anualidad + " Titular " + titular);
        alert.showAndWait();

        }catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Capturar");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    //Programa 2
    @FXML
    private TextField txt_Tiempo;
    @FXML
    private TextField txt_Distancia;
    @FXML
    private void accionCalucularVelocidad(ActionEvent event) {
        try {
            double tiempo = Double.parseDouble(txt_Tiempo.getText());
            double distancia = Double.parseDouble(txt_Distancia.getText());
            double velocidad = distancia / tiempo;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Velocidad");
            alert.setHeaderText("Velocidad " + velocidad);
            alert.setContentText("Para un objeto que se desplaza " + distancia + "m en un tiempo de " + tiempo + "s tiene una velocidad de " + velocidad + "m/s");
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    //Programa 3
    @FXML
    TextField txt_Diastolica = new TextField();
    @FXML
    TextField txt_Sistolica = new TextField();
    @FXML
    private void accionCalucularPrecion(ActionEvent event) {

        try {
            int sistolica = Integer.parseInt(txt_Sistolica.getText());
            int distancia = Integer.parseInt(txt_Diastolica.getText());
            Presion p = new Presion(sistolica, distancia);
            String estado = p.CalcularPrecion();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Precion");
            alert.setHeaderText("Precion " + estado);
            alert.setContentText("Precion " + estado + " Sistolica " + sistolica);
            alert.showAndWait();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }
}