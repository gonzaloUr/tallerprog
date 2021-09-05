package com.entrenamosuy.core;

import java.net.URL;
import java.time.LocalDate;
import java.util.Set;

import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.core.util.Triple;

public interface IControladorUsuario {

    interface CrearProfesorChain {

        CrearProfesorChain setNickname(String nickname);

        CrearProfesorChain setNombre(String nombre);

        CrearProfesorChain setApellido(String apellido);

        CrearProfesorChain setCorreo(Email correo);

        CrearProfesorChain setNacimiento(LocalDate nacimiento);

        CrearProfesorChain setInstitucion(String institucion);

        CrearProfesorChain setDescripcion(String descripcion);

        CrearProfesorChain setBiografia(String bio);

        CrearProfesorChain setLink(URL link);

        void invoke() throws UsuarioRepetidoException;
    }

    CrearProfesorChain crearProfesor();

    interface CrearSocioChain {

        CrearSocioChain setNickname(String nickname);

        CrearSocioChain setNombre(String nombre);

        CrearSocioChain setApellido(String apellido);

        CrearSocioChain setCorreo(Email correo);

        CrearSocioChain setNacimiento(LocalDate nacimiento);

        void invoke() throws UsuarioRepetidoException;
    }

    CrearSocioChain crearSocio();

    /**
     * Se modifica el nombre, apellido y fecha de nacimiento del socio identificado por el nickname pasado a
     * los valores pasados, si no existe tal usuario en el sistema se tira UsuarioNoEncontradoException.
     *
     * @param nickname   Nickname del usuario a modificar datos de.
     * @param nombre     Nuevo nombre para el usuario, si es null no se actualiza.
     * @param apellido   Nuevo apellido para el usuario, si es null no se actualiza.
     * @param nacimiento Nueva fecha de nacimiento para el usuario, si es null no se actualiza.
     * @throws UsuarioNoEncontradoException Cuando no existe un usuario con el nickname pasado.
     */
    void modificarDatosSocio(String nickname, String nombre, String apellido, LocalDate nacimiento);

    interface ModificarDatosProfesorChain {

        ModificarDatosProfesorChain setNickname(String nickname);

        ModificarDatosProfesorChain setNombre(String nombre);

        ModificarDatosProfesorChain setApellido(String apellido);

        ModificarDatosProfesorChain setNacimiento(LocalDate nacimiento);

        ModificarDatosProfesorChain setDescripcion(String descripcion);

        ModificarDatosProfesorChain setBiografia(String biografia);

        ModificarDatosProfesorChain setSitioWeb(URL sitioWeb);

        void invoke() throws ProfesorNoEncontradoException;
    }

    ModificarDatosProfesorChain modificarDatosProfesor();

    /**
     * Retorna el nickname, nombre y apellido de todos los socios en
     * el sistema, si no hay socios tira SociosVacioException.
     *
     * @return Conjunto de tuplas de la forma (nombre, nickname, apellido).
     */
    Set<Triple<String, String, String>> obtenerDescSocios();

    /**
     * Retorna el nickname, nombre y apellido de todos los profesores en
     * el sistema, si no hay profesores tira ProfesoresVacioException.
     *
     * @return Conjunto de tuplas de la forma (nombre, nickname, apellido).
     */
    Set<Triple<String, String, String>> obtenerDescProfesores();

    /**
     * Retorna el nickname, nombre y apellido de todos los profesores en institucion.
     *
     * @param institucion Institucion con profesores a obtener.
     * @return Set de tuplas de la forma (nickname, nombre, apellido).
     * @throws InstitucionNoEncontradaException Cuando institucion no existe en el sistema.
     */
    Set<Triple<String, String, String>> obtenerDescProfesoresDe(String institucion);

    /**
     * Retorna el DataSocio asociado al nombre pasado o tira una excepcion si no
     * se encuentra en el sistema.
     *
     * @param nombre Nombre del socio.
     * @return El DataUsuario correspondiente a nombre.
     * @throws SocioNoEncontradoException Cuando no exist un socio con el nombre pasado.
     */
    DataSocio consultarSocio(String nombre);

    /**
     * Retorna el DataProfesor asociado al nombre pasado o tira una excepcion si no
     * se encuentra en el sistema.
     *
     * @param nombre Nombre del profesor.
     * @return El DataProfesor correspondiente a nombre.
     * @throws ProfesorNoEncontradoException Cuando no existe un profesor con el nombre pasado.
     */
    DataProfesor consultarProfesor(String nombre);
}
