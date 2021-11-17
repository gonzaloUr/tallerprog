package com.entrenamosuy.tarea1.view.publicar;

import java.time.Duration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.entrenamosuy.core.data.DescActividad;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDescActividad {

    private String nombre;

    private String descripcion;

    private Duration duracion;

    private BeanLocalDate registro;

    private float costo;

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

    public Duration getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public BeanLocalDate getRegistro() {
        return this.registro;
    }

    public void setRegistro(BeanLocalDate registro) {
        this.registro = registro;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void from(DescActividad x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setDuracion(x.getDuracion());
        setRegistro(BeanLocalDate.of(x.getRegistro()));
        setCosto(x.getCosto());
    }

    public static BeanDescActividad of(DescActividad x) {
        BeanDescActividad ret = new BeanDescActividad();
        ret.from(x);
        return ret;
    }
}
