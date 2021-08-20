package com.entrenamosuy.tarea1.data;

import java.net.URL;
import java.util.Objects;

public class DescProfesor {
    
    private final String nickname;

    private final String nombre;

    private final String apellido;

    private final URL sitioWeb;

    public DescProfesor(String nickname, String nombre, String apellido, URL sitioWeb) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sitioWeb = sitioWeb;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, nickname, nombre, sitioWeb);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DescProfesor other = (DescProfesor) obj;
        return apellido.equals(other.apellido) && nickname.equals(other.nickname)
                && nombre.equals(other.nombre) && sitioWeb.equals(other.sitioWeb);
    }
}
