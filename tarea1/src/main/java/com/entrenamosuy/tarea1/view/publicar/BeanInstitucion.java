package com.entrenamosuy.tarea1.view.publicar;

import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.entrenamosuy.core.data.DataInstitucion;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanInstitucion {

    private String nombre;

    private String descripcion;

    private URL url;

    private ArrayList<BeanActividad> actividadesOfrecidas;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public ArrayList<BeanActividad> getActividadesOfrecidas() {
        return this.actividadesOfrecidas;
    }

    public void setActividadesOfrecidas(ArrayList<BeanActividad> actividadesOfrecidas) {
        this.actividadesOfrecidas = actividadesOfrecidas;
    }

    public void from(DataInstitucion x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setUrl(x.getUrl());
        setActividadesOfrecidas(x.getActividadesOfrecidas()
            .stream()
            .map(BeanActividad::of)
            .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static BeanInstitucion of(DataInstitucion x) {
        BeanInstitucion ret = new BeanInstitucion();
        ret.from(x);
        return ret;
    }
}
