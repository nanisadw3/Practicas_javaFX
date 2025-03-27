package com.example.practica_10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    TextField txt_calentar;

    @FXML
    Button btn_Preparar;

    @FXML
    RadioButton radio_te;

    @FXML
    private RadioButton radio_cafe;

    private ToggleGroup bebidaGroup;

    @FXML
    public void initialize() {
        bebidaGroup = new ToggleGroup();
        radio_te.setToggleGroup(bebidaGroup);
        radio_cafe.setToggleGroup(bebidaGroup);

        // Opcional: deseleccionar ambos al inicio
        bebidaGroup.selectToggle(null);
    }
    @FXML
    public void accionbtn_Preparar(ActionEvent event) {
    try {
        int calentar = Integer.parseInt(txt_calentar.getText());
        if(radio_te.isSelected()) {
            Te te = new Te();
            te.calentar(calentar);
            String mensaje = te.mostrarDescripcion();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }else if(radio_cafe.isSelected()) {
            Cafe cafe = new Cafe();
            cafe.calentar(calentar);
            String mensaje = cafe.mostrarDescripcion();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Selecciona alguna bebida");
            alert.showAndWait();
        }
    } catch (Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
    }
}