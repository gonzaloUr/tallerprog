package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.util.Objects;

import com.entrenamosuy.tarea1.data.Email;

public abstract class Usuario {

    private String nickname;

    private String nombre;

    private String apellido;

    private Email correo;

    private LocalDateTime nacimiento;

    public Usuario(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nacimiento = nacimiento;
    }

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

    public LocalDateTime getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDateTime nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, correo, nacimiento, nickname, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(apellido, other.apellido) && Objects.equals(correo, other.correo)
                && Objects.equals(nacimiento, other.nacimiento) && Objects.equals(nickname, other.nickname)
                && Objects.equals(nombre, other.nombre);
    }
}