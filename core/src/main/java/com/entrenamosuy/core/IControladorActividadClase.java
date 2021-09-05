package com.entrenamosuy.core;

import java.net.URL;
import java.util.Set;

import com.entrenamosuy.core.exceptions.*;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.util.Pair;
import com.entrenamosuy.core.util.Triple;
import com.entrenamosuy.core.data.DataActividad;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IControladorActividadClase {

    interface CrearActividadChain {

        CrearActividadChain setInstitucion(String institucion);

        CrearActividadChain setNombre(String nombre);

        CrearActividadChain setDescripcion(String descripcion);

        CrearActividadChain setDuracion(Duration duracion);

        CrearActividadChain setCosto(float costo);

        CrearActividadChain setRegistro(LocalDate registro);

        void invoke() throws ActividadRepetidaException;
    }

    CrearActividadChain crearActividad();

    interface CrearClaseChain {

        CrearClaseChain setNombreActividad(String nombreActividad);

        CrearClaseChain setNombre(String nombre);

        CrearClaseChain setInicio(LocalDateTime inicio);

        CrearClaseChain setNicknameProfesores(Set<String> nicknameProfesores);

        CrearClaseChain setCantMin(int cantMin);

        CrearClaseChain setCantMax(int cantMax);

        CrearClaseChain setAcceso(URL acceso);

        CrearClaseChain setFechaRegistro(LocalDate fechaRegistro);

        void invoke() throws ClaseInconsistenteException;
    }

    CrearClaseChain crearClase();

    /**
     * Crea una nueva institucion con los datos ingresados, si ya existe una con el mismo nombre se tira
     * {@link InstitucionRepetidaException}.
     *
     * @param nombre      El nombre unico de la institucion.
     * @param descripcion La descripcion de la institucion.
     * @param url         El url de la institucion.
     * @throws InstitucionRepetidaException Cuando nombre no es unico.
     */
    void crearInstitucion(String nombre, String descripcion, URL url) throws InstitucionRepetidaException;

    /**
     * Registra a socio en la clase pasada sin el uso de una cuponera
     *
     * @param socio         Nombre del socio que se registrara en una clase.
     * @param clase         Nombre de la clase a registrarse.
     * @param fechaRegistro Fecha del registro
     * @throws SocioNoEncontradoException Cuando no existe un socio con el nombre pasado en el sistema.
     * @throws ClaseNoEncontradaException Cuando no existe una clase con el nombre pasado en el sistema.
     */
    void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro) throws RegistroInconsistenteException;

    /**
     * Registar a socio en la clase pasada con la cuponera dada,
     *
     * @param socio         Nombre del socio que se registrara a clase.
     * @param clase         Clase a registrarse.
     * @param cuponera      Cuponera con la cual registrarse.
     * @param fechaRegistro Fecha del registro.
     * @throws SocioNoEncontradoException    Cuando socio no existe en el sistema.
     * @throws ClaseNoEncontradaException    Cuando clase no existe en el sistema.
     * @throws CuponeraNoEncontradaException Cuando cuponera no existe en el sistema.
     */
    void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro) throws RegistroInconsistenteException;

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
     * @throws InstitucionNoEncontradaException Cuando la institucion pasada no existe en el sistema.
     */
    Set<Pair<String, String>> obtenerDescActividades(String institucion);

    /**
     * Retorna el DataActividad de la actividad pasada.
     *
     * @param actividad Nombre de la actividad.
     * @return El DataActividad correspondiente a actividad.
     * @throws ActividadNoEncontradaException Cuando no existe actividad con ese nombre.
     */
    DataActividad consultarActividad(String actividad);

    /**
     * Retorna el nombre de todas las clases en el sistema provistas por la actividad con el
     * nombre pasado.
     *
     * @param actividad Nombre de una actividad.
     * @return Conjunto de nombres de clases.
     * @throws ActividadNoEncontradaException Cuando la actividad pasada no existe en el sistema.
     */
    Set<String> obtenerDescClases(String actividad);

    /**
     * Retorna el DataClase asociado al nombre pasado o tira una excepcion si no se
     * encuentra en el sistema.
     *
     * @param nombre Nombre de la clase.
     * @return El DataClase correspondiente a nombre.
     * @throws ClaseNoEncontradaException Cuando la clase pasada no existe en el sistema.
     */
    DataClase consultarClase(String nombre);
}
