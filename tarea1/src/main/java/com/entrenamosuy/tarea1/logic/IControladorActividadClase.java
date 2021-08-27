package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.util.Set;

import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ActividadRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ActividadVaciaException;
import com.entrenamosuy.tarea1.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ClaseVaciaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraInvalidaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraLlenaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoCompradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionVaciaException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.util.Triple;
import com.entrenamosuy.tarea1.data.DataActividad;

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
     * @throws ActividadRepetidaException Cuando el nombre no es unico.
     * @throws InstitucionNoEncontradaException Cuando la institucion no existe.
     */
    void crearActividad(String institucion, String nombre, String descripcion, Duration duracion, float costo, LocalDate registro) throws ActividadRepetidaException, InstitucionNoEncontradaException;

    /**
     * Crea una nueva institucion con los datos ingresados, si ya existe una con el mismo nombre se tira
     * {@link InstitucionRepetidaException}.
     * 
     * @param nombre El nombre unico de la institucion.
     * @param descripcion La descripcion de la institucion.
     * @param url El url de la institucion.
     * @throws InstitucionRepetidaException Cuando nombre no es unico.
     */
    void crearInstitucion(String nombre, String descripcion, URL url) throws InstitucionRepetidaException;

    /**
     * Crea una nueva clase con los datos pasados perteneciente a la actividad pasada, si ya existe una con 
     * el mismo nombre se tira {@link ClaseRepetidaException} y si no se encuentra la actividad se tira
     * {@link ActividadNoEncontradaException}
     * 
     * @param nombreActividad Nombre de la actividad a la que pertenecera la clase.
     * @param nombre Nombre unico de la clase.
     * @param inicio Fecha de inicio de la clase.
     * @param nombreProfesores Conjunto de profesores que dan la clase.
     * @param cantMin Cantidad minima de socios.
     * @param cantMax Cantidad maxima de socios.
     * @param acceso Link de acceso.
     * @param fechaRegistro Fecha de registro en el sistema.
     * @throws ClaseRepetidaException Cuando el nombre no es unico en el sistema.
     * @throws ActividadNoEncontradaException Cuando existe una actividad con el nombre pasado.
     * @throws ProfesorNoEncontradoException Cuando uno de los profesores pasados no es valido.
     */
    void crearClase(String nombreActividad, String nombre, LocalDate inicio, Set<String> nombreProfesores, 
        int cantMin, int cantMax, URL acceso, LocalDate fechaRegistro) 
        throws ClaseRepetidaException, ActividadNoEncontradaException, ProfesorNoEncontradoException;

    
    /**
     * Registra a socio en la clase pasado sin el uso de una cuponera, si no existen socio o clase en el sistema
     * se tiran {@link SocioNoEncontradoException} y {@link ClaseNoEncontradaException}.
     * 
     * @param socio Nombre del socio que se registrara en una clase.
     * @param clase Nombre de la clase a registrarse.
     * @param fechaRegistro Fecha del registro
     * @throws SocioNoEncontradoException Cuando no existe un socio con el nombre pasado en el sistema.
     * @throws ClaseNoEncontradaException Cuando no existe una clase con el nombre pasado en el sistema.
     */
    void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro) throws SocioNoEncontradoException, ClaseNoEncontradaException;

    /**
     * Registar a socio en la clase pasada con la cuponera dada, si no existe un socio, clase o cuponera se tiran
     * {@link SocioNoEncontradoException}, {@link ClaseNoEncontradaException} y {@link CuponeraNoEncontradaException}.
     * 
     * Ademas si la cuponera pasada no tiene alguna actividad que integre a clase o que la capacidad de esta
     * este llena se tiran {@link CuponeraInvalidaException} y {@link CuponeraInvalidaException} respectivamente.
     * 
     * @param socio Nombre del socio que se registrara a clase.
     * @param clase Clase a registrarse.
     * @param cuponera Cuponera con la cual registrarse.
     * @param fechaRegistro Fecha del registro.
     * @throws SocioNoEncontradoException Cuando socio no existe en el sistema.
     * @throws ClaseNoEncontradaException Cuando clase no existe en el sistema.
     * @throws CuponeraNoEncontradaException Cuando cuponera no existe en el sistema.
     * @throws CuponeraNoCompradaException Cuando el socio pasado no es dueño de la cuponera pasada.
     * @throws CuponeraInvalidaException Cuando cuponera no tiene alguna actividad con clase.
     * @throws CuponeraLlenaException Cuando el limite de la cuponera se alcanzo.
     */
    void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro) 
        throws SocioNoEncontradoException, ClaseNoEncontradaException, CuponeraNoEncontradaException, 
        CuponeraNoCompradaException, CuponeraInvalidaException, CuponeraLlenaException;

    /**
     * Retorna el nombre, descripcion y URL de todos los institucion en el sistema.
     * 
     * @return Conjunto de tuplas de la forma (nombre, descripcion, url).
     * @throws InstitucionVaciaException Cuando no existen instituciones en el sistema.
     */
    Set<Triple<String, String, URL>> obtenerDescInstituciones() throws InstitucionVaciaException;

    /**
     * Retorna el nombre y la descripcion de todas las actividades en el sistema provistas
     * por el institucion con el nombre pasado.
     * 
     * @param institucion Nombre de un institucion.
     * @return Conjunto de tuplas de la forma (nombre, descripcion).
     * @throws InstitucionNoEncontradaException Cuando la institucion pasada no existe en el sistema.
     * @throws ActividadVaciaException Cuando no hay ninguna actividad asociada a la institucion pasada.
     */
    Set<Pair<String, String>> obtenerDescActividades(String institucion) throws InstitucionNoEncontradaException, ActividadVaciaException;

    /**
     * Retorna el DataActividad de la actividad pasada.
     * 
     * @param actividad Nombre de la actividad.
     * @return El DataActividad correspondiente a actividad.
     * @throws ActividadNoEncontradaException Cuando no existe actividad con ese nombre.
     */
    DataActividad consultarActividad(String actividad) throws ActividadNoEncontradaException;
    
    /**
     * Retorna el nombre de todas las clases en el sistema provistas por la actividad con el
     * nombre pasado.
     * 
     * @param actividad Nombre de una actividad.
     * @return Conjunto de nombres de clases.
     * @throws ActividadNoEncontradaException Cuando la actividad pasada no existe en el sistema.
     * @throws ClaseVaciaException Cuando no hay ninguna clase asociada a la actividad pasada.
     */
    Set<String> obtenerDescClases(String actividad) throws ActividadNoEncontradaException, ClaseVaciaException;

    /**
     * Retorna el DataClase asociado al nombre pasado o tira una excepcion si no se
     * encuentra en el sistema.
     * 
     * @param nombre Nombre de la clase.
     * @return El DataClase correspondiente a nombre.
     * @throws ClaseNoEncontradaException Cuando la clase pasada no existe en el sistema.
     */
    DataClase consultarClase(String nombre) throws ClaseNoEncontradaException;
}
