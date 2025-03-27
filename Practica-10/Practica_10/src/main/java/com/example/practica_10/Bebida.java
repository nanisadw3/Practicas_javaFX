package com.example.practica_10;

public abstract class Bebida {
    public int temperatura = 13;
    public abstract String mostrarDescripcion();
    public void calentar(int temperatura) {
        this.temperatura += temperatura;
    }
}
