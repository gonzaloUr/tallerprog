package com.entrenamosuy.tarea1.view.publicar;

import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;

public class UsuarioNoEncontradoExceptionWrapper extends Exception {

    public UsuarioNoEncontradoExceptionWrapper(String msg) {
        super(msg);
    }

    public UsuarioNoEncontradoExceptionWrapper(UsuarioNoEncontradoException e) {
        this(e.getMessage());
    }
}
