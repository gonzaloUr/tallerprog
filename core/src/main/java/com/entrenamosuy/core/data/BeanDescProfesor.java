package com.entrenamosuy.core.data;

import java.net.URL;

public class BeanDescProfesor {

    private String nickname;

    private String nombre;

    private String apellido;

    private URL sitioWeb;

    public BeanDescProfesor() {}

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public URL getSitioWeb() {
        return this.sitioWeb;
    }

    public void setSitioWeb(URL sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public void from(DescProfesor x) {
        setNickname(x.getNickname());
        setNombre(x.getNombre());
        setApellido(x.getApellido());
        setSitioWeb(x.getSitioWeb());
    }
}
