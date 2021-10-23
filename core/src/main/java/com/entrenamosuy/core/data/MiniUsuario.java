package com.entrenamosuy.core.data;

public class MiniUsuario {

    private String nombre;
    private boolean esSocio;

    public MiniUsuario(String n, boolean b){
        esSocio = b;
        nombre = n;
    }

    public String getNombre(){ return nombre; }
    public boolean getEsSocio(){ return esSocio; }

    void setNombre(String nombre){ this.nombre = nombre; }
    void setEsSocio(boolean b){ esSocio = b; }
}