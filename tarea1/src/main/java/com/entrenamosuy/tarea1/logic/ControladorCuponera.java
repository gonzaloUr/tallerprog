package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraVaciaException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException; 

import com.entrenamosuy.tarea1.util.Pair;

public class ControladorCuponera implements IControladorCuponera {

    @Override
    public void crearCuponera(String nombre, String descripcion, LocalDate inicio, LocalDate fin,
            int descuento) {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<Pair<String, String>> cuponerasUsables(String actividad, String socio) throws ActividadNoEncontradaException, SocioNoEncontradoException {
        // Obtener instancia de manejador.
        Manejador manejador = Manejador.getInstance();

        // Intentar obtener socio, clase y actividad del manejador.
        Socio s = manejador.getSocios().get(socio);
        Actividad a = manejador.getActividades().get(actividad);

        // Si alguno no se encontro tirar excepcion.
        if (s == null)
            throw new SocioNoEncontradoException(socio);

        if (a == null)
            throw new ActividadNoEncontradaException(actividad);

        // Buscar cuponeras validas de socio s para clase c de actividad a.
        return s.cuponerasUsables(a);
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
    public Set<Pair<String, String>> obtenerDescCuponeras() throws CuponeraVaciaException {
        Manejador manejador = Manejador.getInstance();
        Map<String, Cuponera> cuponeras = manejador.getCuponeras();

        if (cuponeras.isEmpty())
            throw new CuponeraVaciaException("No hay cuponeras en el sistema");

        Set<Pair<String, String>> ret = new HashSet<>();

        for (Cuponera cup : cuponeras.values())
            ret.add(new Pair<>(cup.getNombre(), cup.getDescripcion()));

        return ret;
    }

    @Override
    public DataCuponera consultarCuponera(String nombre) throws CuponeraNoEncontradaException{
        Manejador manejador = Manejador.getInstance();
        Cuponera c = manejador.getCuponeras().get(nombre);

        if (c == null)
            throw new CuponeraNoEncontradaException(nombre);

        return c.getDataCuponera();
    }
}
