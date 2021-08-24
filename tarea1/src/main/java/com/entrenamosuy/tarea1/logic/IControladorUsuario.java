package com.entrenamosuy.tarea1.logic;

import java.net.URL;

import java.util.Set;
import java.time.LocalDateTime;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataUsuario;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.util.Triple;
import com.entrenamosuy.tarea1.exceptions.NombreYaExisteException;

public interface IControladorUsuario {
    
    void crearProfesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento, Institucion institucion, String descripcion, String bio, URL link) throws NombreYaExisteException;

    void crearSocio(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento) throws NombreYaExisteException;

    void modificarDatosUsuario(String nombre, String apellido, LocalDateTime nacimiento);
        
    /**
     * Retorna el nickname, nombre y apellido de todos los socios en
     * el sistema.
     * 
     * @return Conjunto de tuplas de la forma (nombre, nickname, apellido).
     */
    Set<Triple<String, String, String>> obtenerDescSocios();

    /**
     * Retorna el nickname, nombre y apellido de todos los profesores en
     * el sistema.
     * 
     * @return Conjunto de tuplas de la forma (nombre, nickname, apellido).
     */
    Set<Triple<String, String, String>> obtenerDescProfesores();

    /**
     * Retorna el DataUsuario asociado al nombre pasado o tira una excepcion si no
     * se encuentra en el sistema.
     * 
     * @param nombre Nombre del socio.
     * @return El DataUsuario correspondiente a nombre.
     */
    DataUsuario consultarSocio(String nombre);

    /**
     * Retorna el DataProfesor asociado al nombre pasado o tira una excepcion si no
     * se encuentra en el sistema.
     * 
     * @param nombre Nombre del profesor.
     * @return El DataProfesor correspondiente a nombre.
     */
    DataProfesor consultarProfesor(String nombre);
}