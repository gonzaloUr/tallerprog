package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.util.Set;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.data.DataCuponera;

public interface IControladorCuponera {
    
    void crearCuponera(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin, int descuento);

    Set<Pair<String, String>> cuponerasUsables(String clase, String socio);

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
