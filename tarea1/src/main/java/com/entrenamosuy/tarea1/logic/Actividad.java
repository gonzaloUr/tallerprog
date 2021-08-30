package com.entrenamosuy.tarea1.logic;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Map;

import com.entrenamosuy.tarea1.data.DataActividad;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.data.DescActividad;

public class Actividad {

    private String nombre;

    private String descripcion;

    private Duration duracion;

    private LocalDate fechaRegistro;

    private float costo;

    private Set<Clase> clases;

    public Actividad(String nombre, String descripcion, Duration duracion, LocalDate fechaRegistro, float costo, Set<Clase> clases) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaRegistro = fechaRegistro;
        this.costo = costo;
        this.clases = clases;
    }

    public Actividad(String nombre, String descripcion, Duration duracion, LocalDate fechaRegistro, float costo) {
        this(nombre, descripcion, duracion, fechaRegistro, costo, new HashSet<>());
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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
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

    @Override
    public int hashCode() {
        return Objects.hash(costo, descripcion, duracion, fechaRegistro, nombre);
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

    public DataActividad getDataActividad() {
        Set<DataCuponera> cuponeras = new HashSet<>();
        Manejador man = Manejador.getInstance();
        Map<String, Cuponera> cupos = man.getCuponeras();
        for (Cuponera cupo : cupos.values()) {
            Set<Integra> integs = cupo.getIntegras();
            for (Integra integ : integs) {
                Actividad act = integ.getActividad();
                if (act.getNombre() == this.nombre) {
                    DataCuponera cupoAagregar = cupo.getDataCuponera();
                    cuponeras.add(cupoAagregar);
                }
            }
        }
        Set<DataClase> clases = new HashSet<>();
        Set<Clase> cs = this.clases;
        Iterator<Clase> it = cs.iterator();
        while (it.hasNext()) {
            Clase c = it.next();
            DataClase dc = c.getDataClase();
            clases.add(dc);
        }
        DataActividad res = new DataActividad(this.nombre, this.descripcion, this.duracion, this.fechaRegistro, this.costo, clases, cuponeras);
        return res;
    }

    public DescActividad getDescActividad() {
        DescActividad res = new DescActividad(this.nombre, this.descripcion, this.duracion, this.fechaRegistro, this.costo);
        return res;
    }

    public float calcularPrecioConDescuento(Cuponera cup) {
        int desc = cup.getDescuento();
        float res = costo - (costo * desc);
        return res;
    }
}
