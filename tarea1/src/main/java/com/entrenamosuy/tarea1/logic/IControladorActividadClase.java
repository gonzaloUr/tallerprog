package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.util.Set;

import com.entrenamosuy.tarea1.exceptions.ActividadRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.util.Triple;

import java.time.Duration;
import java.time.LocalDate;

public interface IControladorActividadClase {

    /**
     * Crea una nueva actividad con los datos ingresados perteneciente a institucion, si ya existe
     * una actividad con el mismo nombre tira {@link ActividadRepetidaException} y si no se encuentra
     * institutcion se tira {@link InstitucionNoEncontradaException}.
     * 
     * @param institucion Institucion al que pertenecera la actividad.
     * @param nombre Nombre unico de la actividad.
     * @param descripcion Descripcion de la actividad.
     * @param duracion Duracion de la actividad.
     * @param costo Costo de la actividad.
     * @param registro Fecha de registro de la actividad
     * @throws ActividadRepetidaException
     * @throws InstitucionNoEncontradaException
     */
    void crearActividad(String institucion, String nombre, String descripcion, Duration duracion, float costo, LocalDate registro) throws ActividadRepetidaException, InstitucionNoEncontradaException;

    void crearInstitucion(String nombre, String descripcion, URL url);

    void crearClase(String nombreActividad, String nombre, LocalDate inicio, Set<String> nombreProfesores, int cantMin, int cantMax, URL acceso, LocalDate fechaRegistro) throws UsuarioRepetidoException;

    void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro);

    void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro);

    /**
     * Retorna el nombre, descripcion y URL de todos los institucion en el sistema.
     * 
     * @return Conjunto de tuplas de la forma (nombre, descripcion, url).
     */
    Set<Triple<String, String, URL>> obtenerDescInstituciones();

    /**
     * Retorna el nombre y la descripcion de todas las actividades en el sistema provistas
     * por el institucion con el nombre pasado.
     * 
     * @param institucion Nombre de un institucion.
     * @return Conjunto de tuplas de la forma (nombre, descripcion).
     */
    Set<Pair<String, String>> obtenerDescActividades(String institucion);

    /**
     * Retorna el nombre de todas las clases en el sistema provistas por la actividad con el
     * nombre pasado.
     * 
     * @param actividad Nombre de una actividad.
     * @return Conjunto de nombres de clases.
     */
    Set<String> obtenerDescClases(String actividad);

    /**
     * Retorna el DataClase asociado al nombre pasado o tira una excepcion si no se
     * encuentra en el sistema.
     * 
     * @param nombre Nombre de la clase.
     * @return El DataClase correspondiente a nombre.
     */
    DataClase consultarClase(String nombre);
}
