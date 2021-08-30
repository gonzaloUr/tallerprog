package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.Set;

import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;

public interface IControladorCuponera {

    /**
     * Crea una nueva cuponera, si nombre no esta disponible tira CuponeraRepetidaException.
     *
     * @param nombre      Nombre unico de la cuponera.
     * @param descripcion Descripcion de la cuponera.
     * @param inicio      Comienzo de validez.
     * @param fin         Fin de validez.
     * @param descuento   Porcentaje de descuento.
     * @throws CuponeraRepetidaException Cuando el nombre no es unico.
     */
    void crearCuponera(String nombre, String descripcion, LocalDate inicio, LocalDate fin, int descuento, LocalDate fRegistro) throws CuponeraRepetidaException;

    /**
     * Retorna el nombre y la descripcion de todas las cuponeras en el sistema las cuales se pueden usar por socio
     * para registrarse a una clase de actividad.
     *
     * @param actividad Actividad a buscar cuponeras para.
     * @param socio     Socio cuyas cuponeras se quieren utilizar.
     * @return Un  set de pares de la forma (nombre, descripcion).
     * @throws ActividadNoEncontradaException  Cuando la actividad pasada no existe.
     * @throws SocioNoEncontradoException      Cuando el socio pasado no existe.
     * @throws CuponerasUsablesVaciasException Cuando no hay cuponeras usables para el socio y activdad pasadas.
     */
    Set<Pair<String, String>> cuponerasUsables(String actividad, String socio)
            throws ActividadNoEncontradaException, SocioNoEncontradoException;

    /**
     * Retorna el nombre y la descripcion de todas las actividades pertenecientes a institucion las cuales se pueden agregar a esta,
     * es decir las que no pertenecen aun.
     *
     * @param cuponera    Nombre de la cupopnera a agregar actividades de institucion.
     * @param institucion Nombre de la institucion cuyas actividades se quieren agregar a cuponera.
     * @return Conjunto de tuplas de la forma (nombre, descripcion).
     * @throws CuponeraNoEncontradaException        Cuando cuponera no existe en el sistema.
     * @throws InstitucionNoEncontradaException     Cuando institucion no existe en el sistema.
     * @throws ActividadesAgregablesVaciasException Cuando no hay actividades a agregar.
     */
    Set<String> actividadesAgregables(String cuponera, String institucion)
            throws CuponeraNoEncontradaException, InstitucionNoEncontradaException;

    /**
     * Agrega actividad a cuponera.
     *
     * @param cuponera  Cuponera a agregar actividad.
     * @param actividad Actividad a agregar
     * @throws CuponeraNoEncontradaException  Cuando cuponera no existe en el sistema.
     * @throws ActividadNoEncontradaException Cuando actividad no existe en el sistema.
     */
    void agregarACuponera(String cuponera, String actividad, int cant) throws CuponeraNoEncontradaException, ActividadNoEncontradaException;

    /**
     * Retorna el nombre y la descripcion de todas las cuponeras en el sistema.
     *
     * @return Conjunto de tuplas de la forma (nombre, desc).
     * @throws CuponeraVaciaException Cuando no hay cuponeras en el sistema.
     */
    Set<Pair<String, String>> obtenerDescCuponeras();

    /**
     * Retorna el DataCuponera asociado al nombre pasado o tira una excepcion si no se
     * encuentra en el sistema.
     *
     * @param nombre Nombre de la cuponera.
     * @return El DataCuponera correspondiente a nombre.
     * @throws CuponeraNoEncontradaException Cuando no existe una cuponera con el nombre pasado en el sistema.
     */
    DataCuponera consultarCuponera(String nombre) throws CuponeraNoEncontradaException;
}
