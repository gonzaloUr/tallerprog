package com.entrenamosuy.tarea1.view.publicar;

import java.net.URL;

import com.entrenamosuy.core.data.Email;

public class BeanCrearProfesorArgs {

    private String nickname;

    private String nombre;

    private String apellido;

    private Email correo;

    private BeanLocalDate nacimiento;

    private String institucion;

    private String descripcion;

    private String bio;

    private URL link;

    private String password;

    private URL imagen;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Email getCorreo() {
        return correo;
    }

    public void setCorreo(Email correo) {
        this.correo = correo;
    }

    public BeanLocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(BeanLocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public URL getImagen() {
        return imagen;
    }

    public void setImagen(URL imagen) {
        this.imagen = imagen;
    }
}
