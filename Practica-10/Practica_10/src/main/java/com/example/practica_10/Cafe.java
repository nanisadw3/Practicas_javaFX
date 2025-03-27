package com.example.practica_10;

public class Cafe extends Bebida{
    @Override
    public String mostrarDescripcion() {
        return "Este es un cafe con una temperatura de " + temperatura;
    }
}
