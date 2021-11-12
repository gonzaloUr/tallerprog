package com.entrenamosuy.tarea1.view.publicar;

import java.net.URL;

import com.entrenamosuy.core.data.DescProfesor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDescProfesor {

    private String nickname;

    private String nombre;

    private String apellido;

    private URL sitioWeb;

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

    public static BeanDescProfesor of(DescProfesor x) {
        BeanDescProfesor ret = new BeanDescProfesor();
        ret.from(x);
        return ret;
    }
}
