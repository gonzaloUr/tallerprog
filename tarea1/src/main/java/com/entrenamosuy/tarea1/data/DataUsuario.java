package com.entrenamosuy.tarea1.data;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class DataUsuario {
    
    private final String nickname;

    private final String nombre;

    private final String apellido;

    private final Email correo;

    private final LocalDate nacimiento;

    private final Set<DataActividad> actividades;

    public DataUsuario(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
            Set<DataActividad> actividades) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.actividades = actividades;
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

    public Set<DataActividad> getActividades() {
        return actividades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actividades, apellido, correo, nacimiento, nickname, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataUsuario other = (DataUsuario) obj;
        return actividades.equals(other.actividades) && apellido.equals(other.apellido)
                && correo.equals(other.correo) && nacimiento.equals(other.nacimiento)
                && nickname.equals(other.nickname) && nombre.equals(other.nombre);
    }
}
