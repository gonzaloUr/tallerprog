package com.entrenamosuy.core.data;

import java.net.URL;
import java.util.Set;

public class BeanProfesor {

    private String descripcion;

    private String biografia;

    private URL sitioWeb;

    private String institucion;

    private Set<DataActividad> actividades;

    private Set<DataClase> clases;

    private Set<DataActividad> aceptadas;

    private Set<DataActividad> sinAceptar;

    public BeanProfesor() {}

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public URL getSitioWeb() {
        return this.sitioWeb;
    }

    public void setSitioWeb(URL sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getInstitucion() {
        return this.institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Set<DataActividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(Set<DataActividad> actividades) {
        this.actividades = actividades;
    }

    public Set<DataClase> getClases() {
        return this.clases;
    }

    public void setClases(Set<DataClase> clases) {
        this.clases = clases;
    }

    public Set<DataActividad> getAceptadas() {
        return this.aceptadas;
    }

    public void setAceptadas(Set<DataActividad> aceptadas) {
        this.aceptadas = aceptadas;
    }

    public Set<DataActividad> getSinAceptar() {
        return this.sinAceptar;
    }

    public void setSinAceptar(Set<DataActividad> sinAceptar) {
        this.sinAceptar = sinAceptar;
    }

    public void from(DataProfesor x) {
        setDescripcion(x.getDescripcion());
        setBiografia(x.getBiografia());
        setSitioWeb(x.getSitioWeb());
        setInstitucion(x.getInstitucion());
        setActividades(x.getActividades());
        setClases(x.getClases());
        setAceptadas(x.getAceptadas());
        setSinAceptar(x.getSinAceptar());
    }
}
