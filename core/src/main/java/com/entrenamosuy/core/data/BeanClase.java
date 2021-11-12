package com.entrenamosuy.core.data;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Set;

public class BeanClase {

    private String nombre;

    private LocalDateTime inicio;

    private int cantMin, cantMax;

    private URL accesoURL;

    private DescActividad actividad;

    private Set<DescProfesor> profesores;

    public BeanClase() {}

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getInicio() {
        return this.inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public int getCantMin() {
        return this.cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public int getCantMax() {
        return this.cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public URL getAccesoURL() {
        return this.accesoURL;
    }

    public void setAccesoURL(URL accesoURL) {
        this.accesoURL = accesoURL;
    }

    public DescActividad getActividad() {
        return this.actividad;
    }

    public void setActividad(DescActividad actividad) {
        this.actividad = actividad;
    }

    public Set<DescProfesor> getProfesores() {
        return this.profesores;
    }

    public void setProfesores(Set<DescProfesor> profesores) {
        this.profesores = profesores;
    }

    public void from(DataClase x) {
        setNombre(x.getNombre());
        setInicio(x.getInicio());
        setCantMax(x.getCantMax());
        setAccesoURL(x.getAccesoURL());
        setActividad(x.getActividad());
        setProfesores(x.getProfesores());
    }
}
