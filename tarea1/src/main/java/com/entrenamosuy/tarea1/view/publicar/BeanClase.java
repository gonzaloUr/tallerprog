package com.entrenamosuy.tarea1.view.publicar;

import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.entrenamosuy.core.data.DataClase;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanClase {

    private String nombre;

    private BeanLocalDateTime inicio;

    private int cantMin, cantMax;

    private URL accesoURL;

    private BeanDescActividad actividad;

    private int cantPremios;

    private ArrayList<BeanDescProfesor> profesores;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BeanLocalDateTime getInicio() {
        return this.inicio;
    }

    public void setInicio(BeanLocalDateTime inicio) {
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

    public BeanDescActividad getActividad() {
        return this.actividad;
    }

    public void setActividad(BeanDescActividad actividad) {
        this.actividad = actividad;
    }

    public int getCantPremios(){
        return cantPremios;
    }

    public void setCantPremios(int cantPremios){
        this.cantPremios = cantPremios;
    }

    public ArrayList<BeanDescProfesor> getProfesores() {
        return this.profesores;
    }

    public void setProfesores(ArrayList<BeanDescProfesor> profesores) {
        this.profesores = profesores;
    }

    public void from(DataClase x) {
        setNombre(x.getNombre());
        setInicio(BeanLocalDateTime.of(x.getInicio()));
        setCantMax(x.getCantMax());
        setAccesoURL(x.getAccesoURL());
        setActividad(BeanDescActividad.of(x.getActividad()));
        setCantPremios(x.getCantPremios());
        setProfesores(x.getProfesores()
            .stream()
            .map(BeanDescProfesor::of)
            .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static BeanClase of(DataClase x) {
        BeanClase ret = new BeanClase();
        ret.from(x);
        return ret;
    }
}
