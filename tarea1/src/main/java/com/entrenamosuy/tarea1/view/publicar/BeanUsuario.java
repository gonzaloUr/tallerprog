package com.entrenamosuy.tarea1.view.publicar;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.entrenamosuy.core.data.DataUsuario;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanUsuario {

    private String nickname;

    private String nombre;

    private String apellido;

    private BeanEmail correo;

    private BeanLocalDate nacimiento;

    private ArrayList<String> seguidores;

    private ArrayList<String> seguidos;

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public BeanEmail getCorreo() {
        return correo;
    }

    public BeanLocalDate getNacimiento() {
        return nacimiento;
    }

    public ArrayList<String> getSeguidores() {
        return seguidores;
    }

    public ArrayList<String> getSeguidos() {
        return seguidos;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(BeanEmail correo) {
        this.correo = correo;
    }

    public void setNacimiento(BeanLocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setSeguidores(ArrayList<String> seguidores) {
        this.seguidores = seguidores;
    }

    public void setSeguidos(ArrayList<String> seguidos) {
        this.seguidos = seguidos;
    }

    public void from(DataUsuario x) {
        setNickname(x.getNickname());
        setNombre(x.getNombre());
        setApellido(x.getApellido());
        setCorreo(BeanEmail.of(x.getCorreo()));
        setNacimiento(BeanLocalDate.of(x.getNacimiento()));
        setSeguidores(new ArrayList<>(x.getSeguidores()));
        setSeguidos(new ArrayList<>(x.getSeguidores()));
    }

    public static BeanUsuario of(DataUsuario x) {
        BeanUsuario ret = new BeanUsuario();
        ret.from(x);
        return ret;
    }
}
