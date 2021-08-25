package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataUsuario;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.ProfesoresVacioException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SociosVacioException;
import com.entrenamosuy.tarea1.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.tarea1.util.Triple;

public interface IControladorUsuario {
    
    /**
     * Crea un nuevo profesor en el sistema, si ya existe un profesor con el nickname o el
     * correo dado o no se encuentra la institucion pasada en el sistema se tira las excepciones 
     * NombreYaExisteExcepcion y InstitucionNoEncontradaException respectivamente.
     * 
     * @param nickname Nickname del profesor (unico).
     * @param nombre Nombre del profesor.
     * @param apellido Apellido del profesor.
     * @param correo Correo del profesor (unico).
     * @param nacimiento Fecha de nacimiento del profesor.
     * @param institucion Insititucion a la que pertenece el profesor.
     * @param descripcion Descripcion del profesor.
     * @param bio Biografia del profesor.
     * @param link Link a pagina web del profesor.
     * @throws NombreYaExisteException
     * @throws InstitucionNoEncontradaException
     */
    void crearProfesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento, Institucion institucion, 
        String descripcion, String bio, URL link) throws UsuarioRepetidoException, InstitucionNoEncontradaException;

    /**
     * Crea un nuevo socio en el sistema, si nickname o el correo ya estan usados se tira la excepcion
     * NombreYaExisteException.
     * 
     * @param nickname Nickname unico del socio.
     * @param nombre Nombre del socio.
     * @param apellido Apellido del socio.
     * @param correo Correo unico del socio.
     * @param nacimiento Fecha de nacimiento del socio.
     * @throws NombreYaExisteException
     */
    void crearSocio(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento) throws UsuarioRepetidoException;

    /**
     * Se modifica el nombre, apellido y fecha de nacimiento del usuario identificado por el nickname pasado a
     * los valores pasados, si no existe tal usuario en el sistema se tira UsuarioNoEncontradoException.
     * 
     * @param nickname Nickname del usuario a modificar datos de.
     * @param nombre Nuevo nombre para el usuario, si es null no se actualiza.
     * @param apellido Nuevo apellido para el usuario, si es null no se actualiza.
     * @param nacimiento Nueva fecha de nacimiento para el usuario, si es null no se actualiza.
     * @throws UsuarioNoEncontradoException
     */
    void modificarDatosUsuario(String nickname, String nombre, String apellido, LocalDateTime nacimiento) throws UsuarioNoEncontradoException;
        
    /**
     * Retorna el nickname, nombre y apellido de todos los socios en
     * el sistema, si no hay socios tira SociosVacioException.
     * 
     * @return Conjunto de tuplas de la forma (nombre, nickname, apellido).
     * @throws SocioVacioException
     */
    Set<Triple<String, String, String>> obtenerDescSocios() throws SociosVacioException;

    /**
     * Retorna el nickname, nombre y apellido de todos los profesores en
     * el sistema, si no hay profesores tira ProfesoresVacioException.
     * 
     * @return Conjunto de tuplas de la forma (nombre, nickname, apellido).
     * @throwss ProfesoresVacioException
     */
    Set<Triple<String, String, String>> obtenerDescProfesores() throws ProfesoresVacioException;

    /**
     * Retorna el DataUsuario asociado al nombre pasado o tira una excepcion si no
     * se encuentra en el sistema.
     * 
     * @param nombre Nombre del socio.
     * @return El DataUsuario correspondiente a nombre.
     */
    DataUsuario consultarSocio(String nombre) throws SocioNoEncontradoException;

    /**
     * Retorna el DataProfesor asociado al nombre pasado o tira una excepcion si no
     * se encuentra en el sistema.
     * 
     * @param nombre Nombre del profesor.
     * @return El DataProfesor correspondiente a nombre.
     */
    DataProfesor consultarProfesor(String nombre) throws ProfesorNoEncontradoException;
}