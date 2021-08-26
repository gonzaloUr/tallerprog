package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.Set;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.exceptions.NoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.CuponeraRepetidaException;

public interface IControladorCuponera {

    /**
     * Crea una nueva cuponera, si nombre no esta disponible tira CuponeraRepetidaException.
     * 
     * @param nombre Nombre unico de la cuponera.
     * @param descripcion Descripcion de la cuponera.
     * @param inicio Comienzo de validez.
     * @param fin Fin de validez.
     * @param descuento Porcentaje de descuento.
     * @throws CuponeraRepetidaException
     */
    void crearCuponera(String nombre, String descripcion, LocalDate inicio, LocalDate fin, int descuento) throws CuponeraRepetidaException;

    /**
     * Retorna el nombre y la descripcion de todas las cuponeras en el sistema las cuales tienen a actividad
     * compuesta por clase y le pertenecen a socio.
     *
     * @param clase Clase a buscar cuponeras para.
     * @param activida Actividad a buscar cuponeras para.
     * @param socio Socio cuyas cuponeras se quieren utilizar.
     * @return Un  set de pares de la forma (nombre, descripcion).
     */
    Set<Pair<String, String>> cuponerasUsables(String clase, String actividad, String socio) throws NoEncontradoException;

    Set<Pair<String, String>> actividadesAgregables(String cuponera, String institucion);

    void agregarACuponera(String cuponera, String actividad);

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
     */
    DataCuponera consultarCuponera(String nombre);
}
