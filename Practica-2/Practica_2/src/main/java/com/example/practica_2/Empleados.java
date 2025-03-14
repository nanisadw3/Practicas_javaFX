package com.example.practica_2;

public class Empleados {
    public Empleados(String nombre, String apellidoP, String apellidoM, String clave, int satario) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.clave = clave;
        this.satario = satario;
    }
    public String generarCorreo() {
        correo = nombre.substring(0, 1) + primeraVocal(apellidoP) + nombre + "@empresa.com";
        return correo;

    }
    public static char primeraVocal(String cadena) {
        String vocales = "aeiouAEIOU"; // Definimos las vocales
        for (int i = 0; i < cadena.length(); i++) {
            if (vocales.contains(String.valueOf(cadena.charAt(i)))) {
                return cadena.charAt(i); // Retorna la primera vocal encontrada
            }
        }
        return '-'; // Retorno por defecto si no hay vocales
    }

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String clave;
    private int satario;
    private String correo;
}
