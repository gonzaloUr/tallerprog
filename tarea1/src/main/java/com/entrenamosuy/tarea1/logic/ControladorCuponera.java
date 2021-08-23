package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.util.Pair;

public class ControladorCuponera implements IControladorCuponera {

    @Override
    public void crearCuponera(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin,
            int descuento) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<Pair<String, String>> cuponerasUsables(String clase, String socio) {
        // TODO Auto-generated method stub
        return null;
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