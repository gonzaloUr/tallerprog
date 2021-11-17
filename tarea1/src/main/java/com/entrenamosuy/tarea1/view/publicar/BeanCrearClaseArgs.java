package com.entrenamosuy.tarea1.view.publicar;

import java.net.URL;
import java.util.ArrayList;

public class BeanCrearClaseArgs {

    private String actividad;

    private String nombre;

    private BeanLocalDateTime inicio;

    private ArrayList<String> nicknameProfesores;

    private int cantMin;

    private int cantMax;

    private URL acceso;

    private BeanLocalDate registro;

    private byte[] imagen;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BeanLocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(BeanLocalDateTime inicio) {
        this.inicio = inicio;
    }

    public ArrayList<String> getNicknameProfesores() {
        return nicknameProfesores;
    }

    public void setNicknameProfesores(ArrayList<String> nicknameProfesores) {
        this.nicknameProfesores = nicknameProfesores;
    }

    public int getCantMin() {
        return cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public URL getAcceso() {
        return acceso;
    }

    public void setAcceso(URL acceso) {
        this.acceso = acceso;
    }

    public BeanLocalDate getRegistro() {
        return registro;
    }

    public void setRegistro(BeanLocalDate registro) {
        this.registro = registro;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
