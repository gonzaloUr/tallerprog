package com.entrenamosuy.core.data;

public class BeanMiniUsuario {

    private String nombre;

    private boolean esSocio;

    public BeanMiniUsuario() {}

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEsSocio() {
        return this.esSocio;
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }

    public void from(MiniUsuario x) {
        setNombre(x.getNombre());
        setEsSocio(x.getEsSocio());
    }
}