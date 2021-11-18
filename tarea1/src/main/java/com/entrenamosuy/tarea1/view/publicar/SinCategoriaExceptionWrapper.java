package com.entrenamosuy.tarea1.view.publicar;

import com.entrenamosuy.core.exceptions.SinCategoriaException;

public class SinCategoriaExceptionWrapper extends Exception {

    public SinCategoriaExceptionWrapper(String msg) {
        super(msg);
    }

    public SinCategoriaExceptionWrapper(SinCategoriaException e) {
        this(e.getMessage());
    }
}
