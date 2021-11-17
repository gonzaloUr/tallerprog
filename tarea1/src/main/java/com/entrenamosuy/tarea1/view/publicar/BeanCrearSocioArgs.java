package com.entrenamosuy.tarea1.view.publicar;

public class BeanCrearSocioArgs {

    private String nickname;

    private String nombre;

    private String apellido;

    private BeanEmail correo;

    private BeanLocalDate nacimiento;

    private String password;

    private byte[] imagen;

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

    public BeanEmail getCorreo() {
        return correo;
    }

    public void setCorreo(BeanEmail correo) {
        this.correo = correo;
    }

    public BeanLocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(BeanLocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
