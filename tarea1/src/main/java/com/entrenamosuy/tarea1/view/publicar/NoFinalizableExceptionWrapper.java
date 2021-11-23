package com.entrenamosuy.tarea1.view.publicar;
import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;


public class NoFinalizableExceptionWrapper extends Exception {
    public NoFinalizableExceptionWrapper(String msg) {
        super(msg);
    }

    public NoFinalizableExceptionWrapper(UsuarioNoEncontradoException e) {
        this(e.getMessage());
    }
}




