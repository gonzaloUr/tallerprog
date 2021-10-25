package com.entrenamosuy.core.data;

public class MiniUsuario {

    private String nombre;

    private boolean esSocio;

    public MiniUsuario(String nomb, boolean boole){
        esSocio = boole;
        nombre = nomb;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean getEsSocio(){
        return esSocio;
    }

    void setNombre(String nombre){
        this.nombre = nombre;
    }

    void setEsSocio(boolean boole){
        esSocio = boole;
    }
}
