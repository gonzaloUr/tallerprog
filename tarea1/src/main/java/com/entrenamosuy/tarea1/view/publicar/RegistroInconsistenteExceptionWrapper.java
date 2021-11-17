package com.entrenamosuy.tarea1.view.publicar;

import java.util.ArrayList;
import java.util.List;

import com.entrenamosuy.core.exceptions.RegistroInconsistenteException;

public class RegistroInconsistenteExceptionWrapper extends Exception {

    private List<String> inconsistencias = new ArrayList<>();

    public RegistroInconsistenteExceptionWrapper() {}

    public RegistroInconsistenteExceptionWrapper(RegistroInconsistenteException exception) {
        for (RegistroInconsistenteException.Restriccion r : exception.getInconsistencias())
            inconsistencias.add(r.name());
    }

    public List<String> getInconsistencias() {
        return inconsistencias;
    }

    public void setInconsistencias(List<String> inconsistencias) {
        this.inconsistencias = inconsistencias;
    }
}
