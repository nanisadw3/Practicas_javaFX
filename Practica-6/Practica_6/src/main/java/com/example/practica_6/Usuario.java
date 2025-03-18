package com.example.practica_6;

public class Usuario {
    String nombre;
    String contrasena;
    String fecha;

    @Override
    public String toString() {
        return "Usuario " +
                "nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", fecha='" + fecha + '\'';
    }

    public Usuario(String nombre, String contrasena, String fecha) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fecha = fecha;
    }
}
