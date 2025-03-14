package com.example.practica_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    ArrayList<Almacen> almacenes = new ArrayList<Almacen>();
    @FXML
    private TextField txt_Clave;
    @FXML
    private TextField txt_Nombre;
    @FXML
    private TextField txt_Ubicacion;
    @FXML
    private TextField txt_Cantidad;

    @FXML
    private void accionAgregar(ActionEvent event) {
        try {
            String clave = txt_Clave.getText();
            String nombre = txt_Nombre.getText();
            String ubicacion = txt_Ubicacion.getText();
            int cantidad = Integer.parseInt(txt_Cantidad.getText());

            if (clave.equals("")||nombre.equals("")||ubicacion.equals("")||txt_Cantidad.getText().equals("")) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Llena los campos");
            alerta.showAndWait();
            } else if (cantidad < 0) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("La cantidad debe ser mayor que 0");
                alerta.showAndWait();
            }else{
                Almacen a = new Almacen(clave, nombre, ubicacion, cantidad);
                almacenes.add(a);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Informacion");
                alerta.setHeaderText(null);
                alerta.setContentText("Se registro con exito el " + nombre);
                alerta.showAndWait();
                txt_Clave.setText("");
                txt_Nombre.setText("");
                txt_Ubicacion.setText("");
                txt_Cantidad.setText("");

            }
        }catch (Exception e){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(e.getMessage());
        alerta.showAndWait();
        }

    }
    @FXML
    private TextField txt_buscar;
    @FXML
    private void accionBuscar(ActionEvent event) {
        String buscar = txt_buscar.getText();
        boolean bandera = false;
        String clave = "";
        String nombre = "";
        int cantidad = 0;
        for (Almacen a : almacenes) {
            if (buscar.equals(a.ubicacion)){
                bandera = true;
                clave = a.clave;
                nombre = a.nombre;
                cantidad = a.cantidad;
                break;

            }
        }
        if (bandera) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informacion");
        alerta.setHeaderText(null);
        alerta.setContentText("Se encontro el " + nombre + " con " + clave + " una cantidad de " + cantidad);
        alerta.showAndWait();
        }else{
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro nada en la uvicacion");
            alerta.showAndWait();
        }
    }
}