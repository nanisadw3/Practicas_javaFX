package com.example.practica_9;

import javafx.stage.Stage;

public class ExepcionCampoVacio extends Exception{
    public ExepcionCampoVacio() {
        super("Llena todos los campos");
    }
}
