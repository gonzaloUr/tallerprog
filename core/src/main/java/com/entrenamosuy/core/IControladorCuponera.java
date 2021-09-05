package com.entrenamosuy.core;

import java.time.LocalDate;
import java.util.Set;

import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.exceptions.CuponeraInconsistenteException;
import com.entrenamosuy.core.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.core.util.Pair;
import com.entrenamosuy.core.data.DataCuponera;

public interface IControladorCuponera {

    /**
     * Interfaz retornada por crearCuponera para hacer method chaining.
     */
    interface CrearCuponeraChain {

        /**
         * Settea el valor del argumento nombre.
         * @param nombre Valor del argumento.
         * @return this.
         */
        CrearCuponeraChain setNombre(String nombre);

        /**
         * Settea el valor del argumento descripcion.
         * @param descripcion Valor del argumento.
         * @return this.
         */
        CrearCuponeraChain setDescripcion(String descripcion);

        /**
         * Settea el valor del argumento inicio.
         * @param inicio Valor del argumento.
         * @return this.
         */
        CrearCuponeraChain setInicio(LocalDate inicio);

        /**
         * Settea el valor del argumento fin.
         * @param fin Valor del argumento.
         * @return this.
         */
        CrearCuponeraChain setFin(LocalDate fin);

        /**
         * Settea el valor del argumento descuento.
         * @param descuento Valor del argumento.
         * @return this.
         */
        CrearCuponeraChain setDescuento(int descuento);

        /**
         * Settea el valor del argumento fechaRegistro.
         * @param fechaRegistro Valor del argumento.
         * @return this.
         */
        CrearCuponeraChain setFechaRegistro(LocalDate fechaRegistro);

        /**
         * Efectivamente invoca el metodo crearCuponera creando una cuponera con los argumentos pasados.
         * @throws CuponeraInconsistenteException Cuando la cuponera a crear no cumple con las restricciones.
         */
        void invoke() throws CuponeraInconsistenteException;
    }

    /**
     * Crea una cuponera,
     * @return retorna la interfaz correspondiente para realizar method chaining.
     */
    CrearCuponeraChain crearCuponera();

    /**
     * Retorna el nombre y descripcion de todas las cuponeras que puede usar socio para registrarse a una clase
     * de actividad.
     *
     * @param actividad Actividad a buscar cuponeras para.
     * @param socio     Socio cuyas cuponeras se quiere utilizar.
     * @return Un set de pares con nombre y descripcion.
     * @throws ActividadNoEncontradaException  Cuando la actividad pasada no existe.
     * @throws SocioNoEncontradoException      Cuando el socio pasado no existe.
     */
    Set<Pair<String, String>> cuponerasUsables(String actividad, String socio);

    /**
     * Retorna el nombre y la descripcion de todas las actividades pertenecientes a institucion las cuales se pueden agregar a esta,
     * es decir las que no pertenecen aun.
     *
     * @param cuponera    Nombre de la cupopnera a agregar actividades de institucion.
     * @param institucion Nombre de la institucion cuyas actividades se quieren agregar a cuponera.
     * @return Conjunto de tuplas de la forma (nombre, descripcion).
     * @throws CuponeraNoEncontradaException        Cuando cuponera no existe en el sistema.
     * @throws InstitucionNoEncontradaException     Cuando institucion no existe en el sistema.
     */
    Set<String> actividadesAgregables(String cuponera, String institucion);

    /**
     * Agrega actividad a cuponera.
     *
     * @param cuponera  Cuponera a agregar actividad.
     * @param actividad Actividad a agregar
     * @throws CuponeraNoEncontradaException  Cuando cuponera no existe en el sistema.
     * @throws ActividadNoEncontradaException Cuando actividad no existe en el sistema.
     */
    void agregarACuponera(String cuponera, String actividad, int cant);

    /**
     * Retorna el nombre y la descripcion de todas las cuponeras en el sistema.
     *
     * @return Conjunto de tuplas de la forma (nombre, desc).
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
    DataCuponera consultarCuponera(String nombre);
}
