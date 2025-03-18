package com.example.practica_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {//para implementar el metodo inicial para nuestro spinner
    ArrayList<Guitarra> guitarras = new ArrayList<Guitarra>();
    @FXML
    TextField txt_Clave;
    @FXML
    TextField txt_Nombre;
    @FXML
    TextField txt_Precio;
    @FXML
    Spinner<Integer> spn_Ncuerdas;
    //configuracion del spinner
    @FXML
    TextArea txt_Inf;
    //condiciones iniciales para nuestros componentes
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txt_Inf.setDisable(true);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(4, 6, 1);
        valueFactory.setValue(5);
        spn_Ncuerdas.setValueFactory(valueFactory);
    }
    @FXML
    private void accionRegistrar(ActionEvent event) {
        try {
            String clave = txt_Clave.getText();
            String nombre = txt_Nombre.getText();
            float precio = Float.parseFloat(txt_Precio.getText());
            int num_cuerdas = Integer.parseInt(spn_Ncuerdas.getValue().toString());

            if (clave.equals("")||nombre.equals("")||txt_Precio.getText().equals("")) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("Debe llenar los campos");
                alerta.showAndWait();
            } else if (precio < 0) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("El precio no puede ser negativo");
                alerta.showAndWait();
            }else{
                Guitarra g = new Guitarra(num_cuerdas, nombre,clave,precio);
                guitarras.add(g);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Registro");
                alerta.setHeaderText(null);
                alerta.setContentText("Registro guardado");
                alerta.showAndWait();
                txt_Clave.clear();
                txt_Nombre.clear();
                txt_Precio.clear();

            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

    @FXML
    private void accionActualizar(ActionEvent event) {
        txt_Inf.clear();
        if (guitarras.size() <= 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("No hay guitarras guardadas");
            alerta.showAndWait();
        }else{
            String info ="";
            for (var guitarra : guitarras) {
                info += "Nombre: " + guitarra.nombre + " Precio " + guitarra.calcularPrecio() + " Numero de cuerdas " + guitarra.getNumero_cuerdas() +"\n";
            }
            txt_Inf.setText(info);
        }
    }
}