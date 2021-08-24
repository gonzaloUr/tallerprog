package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.NoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.util.Pair;

public class ControladorCuponera implements IControladorCuponera {

    @Override
    public void crearCuponera(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin,
            int descuento) {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<Pair<String, String>> cuponerasUsables(String clase, String actividad, String socio) throws NoEncontradoException {
        // Obtener instancia de manejador.
        Manejador manejador = Manejador.getInstance();

        // Intentar obtener socio, clase y actividad del manejador.
        Socio s = manejador.getSocios().get(socio);
        Clase c = manejador.getClases().get(clase);
        Actividad a = manejador.getActividades().get(actividad);

        // Si alguno no se encontro tirar excepcion.
        if (c == null)
            throw new ClaseNoEncontradaException(clase);

        if (s == null)
            throw new SocioNoEncontradoException(socio);

        if (a == null)
            throw new ActividadNoEncontradaException(actividad);

        // Buscar cuponeras validas de socio s para clase c de actividad a.
        return s.cuponerasValidas(c, a);
    }

    @Override
    public Set<Pair<String, String>> actividadesAgregables(String cuponera, String institucion) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void agregarACuponera(String cuponera, String actividad) {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<Pair<String, String>> obtenerDescCuponeras() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataCuponera consultarCuponera(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }
}
