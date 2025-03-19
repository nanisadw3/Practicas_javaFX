package com.example.practica_8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> estatus = new ArrayList<>();
        estatus.add("Preparando");
        estatus.add("Entregando");
        estatus.add("Horneando");
        combo_Estatus.getItems().addAll(estatus);
        leer();

    }
    private void leer(){
        try {
            FileReader fileReader = new FileReader("Entregas.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while((linea = bufferedReader.readLine()) != null){
            String[] datos = linea.split("\\|");
            String calave = datos[0];
            combo_Clave.getItems().add(calave);
            String estatus = datos[1];
            String repartidor = "";

            if (datos.length > 2 && !datos[2].isEmpty()) {//si el arreglo datos es mayor a 2 y la 3ra parte no esta vacia
                repartidor = datos[2];
            } else {
                repartidor = "Sin asignar";
            }
            Entregas e = new Entregas(calave, estatus, repartidor);
            listaEntregas.add(e);

            }
            bufferedReader.close();
        } catch (Exception e) {
            mensaje("error", "Error", e.getMessage());
        }
    }
    @FXML
    private void accion_clave(ActionEvent event) {
        String calave = combo_Clave.getSelectionModel().getSelectedItem();
        String repartidor = "";
        String status = "";
        boolean bandera = false;
        for (Entregas e : listaEntregas) {
            if (calave == e.clave){
                bandera = true;
                repartidor = e.repartidor;
                status = e.status;
                break;
            }
        }
        if (bandera){
            txt_Repartidor.setText(repartidor);
            combo_Estatus.getSelectionModel().select(status);

            if (combo_Estatus.getSelectionModel().getSelectedItem().equals("Preparando") || combo_Estatus.getSelectionModel().getSelectedItem().equals("Horneando")){
                txt_Repartidor.setDisable(true);
            }else{
                txt_Repartidor.setDisable(false);
            }
        }else{
            mensaje("error", "Error", "No se encontro el registro");
        }
    }
    @FXML
    private void accion_estatus(ActionEvent event) {
        if (combo_Estatus.getSelectionModel().getSelectedItem().equals("Preparando") || combo_Estatus.getSelectionModel().getSelectedItem().equals("Horneando")){
            txt_Repartidor.setDisable(true);
        }else{
            txt_Repartidor.setDisable(false);
        }
    }
    @FXML
    private void accion_Actualizar(ActionEvent event) {
        if (combo_Estatus.getSelectionModel().getSelectedItem()==null || combo_Estatus.getSelectionModel().getSelectedItem()==null){
            mensaje("error", "Error", "Llena todos los campos");
        }else{
            String calave = combo_Clave.getSelectionModel().getSelectedItem();
            String estatus = combo_Estatus.getSelectionModel().getSelectedItem();
            String repartidor = txt_Repartidor.getText();
            boolean bandera = false;
            for (Entregas e : listaEntregas) {
                if (calave == e.clave){
                    e.repartidor = repartidor;
                    e.status = estatus;
                    bandera = true;
                    break;
                }
            }
            if (bandera){
                mensaje("inf", "Informacion", "Modificacion echa");
            }else{
                mensaje("error", "Error", "No se encontro el registro");
            }
        }
        try {
            FileWriter fileWriter = new FileWriter("Entregas.dat",false);//Para sobre escrivir la informacion
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Entregas e : listaEntregas) {
                bufferedWriter.write(e.clave + "|" + e.status + "|" + e.repartidor +"\n");
            }
            bufferedWriter.close();
            mensaje("inf", "Informacion", "Actualizado registrada");

        } catch (Exception e) {
            mensaje("error", "Error", e.getMessage());
        }

    }
    private void mensaje(String tipo, String titulo, String mensaje){
        if(tipo.equals("inf")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(titulo);
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(titulo);
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }

    }

    ArrayList<Entregas> listaEntregas = new ArrayList<>();
    @FXML
    ComboBox<String> combo_Clave;
    @FXML
    ComboBox<String> combo_Estatus;
    @FXML
    TextField txt_Repartidor;


}