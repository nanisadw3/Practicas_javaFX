package com.example.practica_5;

public class Instrumento {
    public String clave;
    public String nombre;
    public float precio;

    public Instrumento(String nombre, String clave, float precio) {
        this.nombre = nombre;
        this.clave = clave;
        this.precio = precio;
    }

    public float calcularPrecio() {
        return precio;
    }
}
