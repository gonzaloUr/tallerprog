package com.entrenamosuy.tarea1.view.publicar;

import java.util.ArrayList;
import java.util.List;

import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;

public class ClaseInconsistenteExceptionWrapper extends Exception {

    private List<String> inconsistencias = new ArrayList<>();

    public ClaseInconsistenteExceptionWrapper() {}

    public ClaseInconsistenteExceptionWrapper(ClaseInconsistenteException e) {
        for (ClaseInconsistenteException.Restriccion r : e.getInconsistencias())
            inconsistencias.add(r.name());
    }

    public List<String> getInconsistencias() {
        return inconsistencias;
    }

    public void setInconsistencias(List<String> inconsistencias) {
        this.inconsistencias = inconsistencias;
    }
}
