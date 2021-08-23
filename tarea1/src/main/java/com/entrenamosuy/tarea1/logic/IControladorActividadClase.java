package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.util.Triple;

import java.time.Duration;
import java.time.LocalDateTime;

public interface IControladorActividadClase {

    void crearActividad(String institucion, String nombre, String descripcion, Duration duracion, float costo, LocalDateTime fecha);

    void crearInstitucion(String nombre, String descripcion, URL url);

    void crearClase(String nombreActividad, String nombre, LocalDateTime inicio, Set<String> nombreProfesores, int cantMin, int cantMax, URL acceso, LocalDateTime fechaRegistro);

    void registarseSinCuponera(String socio, String clase, LocalDateTime fechaRegistro);

    void registraseConCuponera(String socio, String clase, String cuponera, LocalDateTime fechaRegistro);

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
