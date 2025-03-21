package com.example.practica_9;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cargar();

    }
    private void cargar(){
        try {
            FileReader fr = new FileReader("usuarios.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String contrasena = datos[1];
                String fecha = datos[2];
                Usuarios usuario = new Usuarios(nombre, contrasena, fecha);
                usuarios.add(usuario);
            }
            br.close();
        } catch (Exception e) {
            mensaje(false, "Error " + e, "Error");
        }
    }
    @FXML
    private void accion_Registrar(){
        try {

            if (txt_contrasena == null || txt_usuario == null || date_picker.getValue() == null) {

                throw new ExepcionCampoVacio();
            }
            String usuario = txt_usuario.getText();
            String contrasena = txt_contrasena.getText();
            String fecha = date_picker.getValue().toString();
            if(contrasena.length()<6){
                mensaje(false, "La contrasena no puede ser menor que 6 caracteres", "Error");
            }else if (date_picker.getValue().getYear() > 2009){
                mensaje(false,"La fecha no puede ser mayor que 2009", "Error");
            }else{
                boolean bandera = false;
                for (Usuarios usuarios : usuarios) {
                    if(usuario.equals(usuarios.nombre)){
                        bandera = true;
                        break;
                    }
                }
                if(bandera){
                    mensaje(false, "El usuario ya existe", "Error");
                }else{
                    FileWriter fw = new FileWriter("usuarios.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(usuario + "," + contrasena + "," + fecha + "\n");
                    bw.close();
                    Usuarios u = new Usuarios(usuario, contrasena, fecha);
                    usuarios.add(u);
                    mensaje(true, "Usuario registrado", "Info");
                }
            }
        } catch (ExepcionCampoVacio ex) {
            mensaje(false, ex.getMessage(), "Error");
        }catch (Exception e) {
            mensaje(false, "Error " + e, "Error");
        }
    }
    private void mensaje(boolean info,String mensaje, String titulo){
        if(info){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(titulo);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(titulo);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
    }

    ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
    @FXML
    TextField txt_usuario;
    @FXML
    TextField txt_contrasena;
    @FXML
    DatePicker date_picker;


}