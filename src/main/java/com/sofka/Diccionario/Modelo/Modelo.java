package com.sofka.Diccionario.Modelo;

import java.io.FileWriter;

public class Modelo {
    String espanol;
    String ingles;

    public Modelo() {

    }

    public Modelo(String espanol, String ingles) {
        this.espanol = espanol;
        this.ingles = ingles;
    }

    public Modelo(FileWriter fl) {

    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getEspanol() {
        return espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public void setCompleta() {

        //return {"key":getEspanol(),"value":getIngles()};
    }
}
