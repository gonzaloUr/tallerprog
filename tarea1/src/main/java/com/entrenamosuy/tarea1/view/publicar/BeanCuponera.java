package com.entrenamosuy.tarea1.view.publicar;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.entrenamosuy.core.data.DataCuponera;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanCuponera {

    private String nombre;

    private String descripcion;

    private ArrayList<BeanDescActividad> actividades;

    private ArrayList<String> categorias;

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

    public ArrayList<BeanDescActividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(ArrayList<BeanDescActividad> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<String> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public void from(DataCuponera x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setActividades(x.getActividades()
            .stream()
            .map(BeanDescActividad::of)
            .collect(Collectors.toCollection(ArrayList::new)));
        setCategorias(new ArrayList<>(x.getCategorias()));
    }

    public static BeanCuponera of(DataCuponera x) {
        BeanCuponera ret = new BeanCuponera();
        ret.from(x);
        return ret;
    }
}
