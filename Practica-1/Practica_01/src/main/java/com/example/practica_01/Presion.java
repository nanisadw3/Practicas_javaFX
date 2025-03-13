package com.example.practica_01;

public class Presion {

    private int Sistolica;
    private int Diastolica;

    public Presion(int sistolica, int diastolica) {
        this.Sistolica = sistolica;
        this.Diastolica = diastolica;
    }

    public String CalcularPrecion() {
        if (Sistolica < 120 && Diastolica < 80) {
            return "Normal";
        } else if (Sistolica >= 120 && Sistolica <= 129 && Diastolica <= 80) {
            return "Elevada";
        } else if (Sistolica > 129 && Sistolica <= 139 && Diastolica >= 80 && Diastolica <= 89) {
            return "Hipertensión 1";
        } else if (Sistolica > 139 && Sistolica <= 180 && Diastolica > 90 && Diastolica <= 120) {
            return "Hipertensión 1";
        } else if (Sistolica > 180 && Diastolica > 120) {
            return "Crisis Hipertensiva";
        } else {
            return "Error";
        }
    }
}