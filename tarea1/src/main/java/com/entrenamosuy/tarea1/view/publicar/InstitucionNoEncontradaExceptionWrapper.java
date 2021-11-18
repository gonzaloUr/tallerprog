package com.entrenamosuy.tarea1.view.publicar;

import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;

public class InstitucionNoEncontradaExceptionWrapper extends Exception {

    public InstitucionNoEncontradaExceptionWrapper(String msg) {
        super(msg);
    }

    public InstitucionNoEncontradaExceptionWrapper(InstitucionNoEncontradaException e) {
        this(e.getMessage());
    }
}
