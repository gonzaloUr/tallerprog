package com.entrenamosuy.tarea1.data;

import java.time.LocalDate;
import java.util.Objects;

public class DataUsuario {
    
    private final String nickname;

    private final String nombre;

    private final String apellido;

    private final Email correo;

    private final LocalDate nacimiento;

    public DataUsuario(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nacimiento = nacimiento;
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

    public Email getCorreo() {
        return correo;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
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
        DataUsuario other = (DataUsuario) obj;
        return apellido.equals(other.apellido) && correo.equals(other.correo) 
                && nacimiento.equals(other.nacimiento) && nickname.equals(other.nickname) 
                && nombre.equals(other.nombre);
    }
}
