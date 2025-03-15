package com.example.practica_5;

public class Guitarra extends Instrumento {
    private int numero_cuerdas;

    public Guitarra(int numero_cuerdas, String nombre, String clave, float precio) {
        super(nombre, clave, precio); // Llamada al constructor de la superclase
        this.numero_cuerdas = numero_cuerdas;
    }

    public int getNumero_cuerdas() {
        return numero_cuerdas;
    }

    @Override
    public float calcularPrecio() { // Debe ser public o protected
        return precio * 1.15f;
    }
}
