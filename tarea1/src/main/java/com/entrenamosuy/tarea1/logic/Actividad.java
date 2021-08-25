package com.entrenamosuy.tarea1.logic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataActividad;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.data.DescActividad;

public class Actividad {

    private String nombre;

    private String descripcion;

    private Duration duracion;

    private LocalDateTime fechaRegistro;

    private float costo;

    private Set<Clase> clases;

    public Actividad(String nombre, String descripcion, Duration duracion, LocalDateTime fechaRegistro, float costo, Set<Clase> clases) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaRegistro = fechaRegistro;
        this.costo = costo;
        this.clases = clases;
    }

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

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Set<Clase> getClases() {
        return clases;
    }

    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }

    public DataActividad getDataActividad() { 
        Set<DataCuponera> cuponeras = new HashSet<>();//TODO Hacer



        Set<DataClase> clases = new HashSet<>();
        Set<Clase> cs = this.clases;
        Iterator<Clase> it = cs.iterator();
        while(it.hasNext()) {
            Clase c = it.next();
            DataClase dc = c.getDataClase();
            clases.add(dc);              
        }
        DataActividad res = new DataActividad(this.nombre, this.descripcion, this.duracion,this.fechaRegistro, this.costo, clases, cuponeras);
        return res;
    }

    public DescActividad getDescActividad() {
        DescActividad res = new DescActividad(this.nombre, this.descripcion, this.duracion, this.fechaRegistro, this.costo);
        return res;
    }

    public void agregarClase(Clase cl) {
        this.clases.add(cl);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(costo, descripcion, duracion, fechaRegistro, nombre, clases);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Actividad other = (Actividad) obj;
        return costo == other.costo && Objects.equals(descripcion, other.descripcion)
                && Objects.equals(duracion, other.duracion) && Objects.equals(fechaRegistro, other.fechaRegistro)
                && Objects.equals(nombre, other.nombre);
    }
}
