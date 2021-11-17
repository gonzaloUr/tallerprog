package com.entrenamosuy.tarea1.view.publicar;

import java.util.ArrayList;

public class BeanCrearActividadArgs {

    private String nombre;

    private String descripcion;

    private String institucion;

    private int duracion;

    private float costo;

    private BeanLocalDate registro;

    private ArrayList<String> categorias;

    private String creadorNickname;

    private byte[] imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public BeanLocalDate getRegistro() {
        return registro;
    }

    public void setRegistro(BeanLocalDate registro) {
        this.registro = registro;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public String getCreadorNickname() {
        return creadorNickname;
    }

    public void setCreadorNickname(String creadorNickname) {
        this.creadorNickname = creadorNickname;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
