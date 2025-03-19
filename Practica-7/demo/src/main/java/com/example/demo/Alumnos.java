package com.example.demo;

public class Alumnos extends Persona {
    String fecha;
    int asistencia;

    public Alumnos(String nombre, String fecha, int asistencia) {
        super(nombre); // Se pasa 'nombre' a la superclase Persona
        this.fecha = fecha;
        this.asistencia = asistencia;
    }
}
