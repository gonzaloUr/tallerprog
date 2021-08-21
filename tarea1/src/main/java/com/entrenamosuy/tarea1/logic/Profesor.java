package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDateTime;

import com.entrenamosuy.tarea1.data.Email;

public class Profesor extends Usuario {

    private String descripcion;

    private String biografia;

    private URL sitioWeb;

    public Profesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            String descripcion, String biografia, URL sitioWeb) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(URL sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
}
