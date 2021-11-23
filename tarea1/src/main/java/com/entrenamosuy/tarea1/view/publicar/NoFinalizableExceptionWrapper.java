package com.entrenamosuy.tarea1.view.publicar;
import com.entrenamosuy.core.exceptions.NoFinalizableException;


public class NoFinalizableExceptionWrapper extends Exception {
    public NoFinalizableExceptionWrapper(String msg) {
        super(msg);
    }

    public NoFinalizableExceptionWrapper(NoFinalizableException e) {
        this(e.getMessage());
    }
}




