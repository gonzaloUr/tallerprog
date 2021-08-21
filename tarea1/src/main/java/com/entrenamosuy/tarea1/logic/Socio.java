package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;

import com.entrenamosuy.tarea1.data.Email;

public class Socio extends Usuario {

    public Socio(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento) {
        super(nickname, nombre, apellido, correo, nacimiento);
    }
}
