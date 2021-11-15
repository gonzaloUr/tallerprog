package com.entrenamosuy.tarea1.view.publicar;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.entrenamosuy.core.data.DataActividad;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanActividad {

    private String nombre;

    private String descripcion;

    private int duracion;

    private LocalDate registro;

    private float costo;

    private ArrayList<BeanClase> clases;

    private ArrayList<BeanCuponera> cuponeras;

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

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getRegistro() {
        return this.registro;
    }

    public void setRegistro(LocalDate registro) {
        this.registro = registro;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public ArrayList<BeanClase> getClases() {
        return this.clases;
    }

    public void setClases(ArrayList<BeanClase> clases) {
        this.clases = clases;
    }

    public ArrayList<BeanCuponera> getCuponeras() {
        return this.cuponeras;
    }

    public void setCuponeras(ArrayList<BeanCuponera> cuponeras) {
        this.cuponeras = cuponeras;
    }

    public ArrayList<String> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public void from(DataActividad x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setDuracion((int)x.getDuracion().toMinutes());
        setRegistro(x.getRegistro());
        setCosto(x.getCosto());
        setClases(x.getClases()
            .stream()
            .map(BeanClase::of)
            .collect(Collectors.toCollection(ArrayList::new)));
        setCuponeras(x.getCuponeras()
            .stream()
            .map(BeanCuponera::of)
            .collect(Collectors.toCollection(ArrayList::new)));
        setCategorias(new ArrayList<>(x.getCategorias()));
    }

    public static BeanActividad of(DataActividad x) {
        BeanActividad ret = new BeanActividad();
        ret.from(x);
        return ret;
    }
}
