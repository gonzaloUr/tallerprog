package com.entrenamosuy.tarea1.logic;

public final class Manejador {
    
    private static Manejador instance;

    public static Manejador getInstance() {
        return instance;
    }

    private Manejador() {}
}
