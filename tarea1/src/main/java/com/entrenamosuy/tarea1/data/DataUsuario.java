package com.entrenamosuy.tarea1.data;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class DataUsuario {
    
    private final String nickname;

    private final String nombre;

    private final String apellido;

    private final Email correo;

    private final LocalDateTime nacimiento;

    public DataUsuario(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento2) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nacimiento = nacimiento2;
    }

   // public DataUsuario(String nickname2, String nombre2, String apellido2, Email correo2, LocalDateTime localDateTime) {
   // }

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

    public LocalDateTime getNacimiento() {
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
