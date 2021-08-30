package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataCuponera;
import com.entrenamosuy.tarea1.data.DescActividad;

public class Cuponera {

    private String nombre;

    private String descripcion;

    private LocalDate inicio, fin, fRegistro;

    private int descuento;

    //private float precio;

    private Set<Integra> integras;

    private Set<Registro> registros;

    public Cuponera(String nombre, String descripcion, LocalDate inicio, LocalDate fin, int descuento,
                    LocalDate fRegistro, Set<Integra> integras, Set<Registro> registros) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.descuento = descuento;
        //this.precio = precio;
        this.integras = integras;
        this.registros = registros;
        this.fRegistro = fRegistro;
    }

    public Cuponera(String nombre, String descripcion, LocalDate inicio, LocalDate fin, int descuento,
                    LocalDate fRegistro) {
        this(nombre, descripcion, inicio, fin, descuento, fRegistro, new HashSet<>(), new HashSet<>());
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

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    //public float getPrecio() {
    //    return precio;
    //}

    //public void setPrecio(float precio) {
    //    this.precio = precio;
    //}

    public Set<Integra> getIntegras() {
        return integras;
    }

    public void setIntegras(Set<Integra> integras) {
        this.integras = integras;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<Registro> registros) {
        this.registros = registros;
    }

    public DataCuponera getDataCuponera() {
        Set<Integra> intes = this.integras;
        Set<DescActividad> acts = new HashSet<>();
        for (Integra inte : intes) {
            Actividad act = inte.getActividad();
            DescActividad DA = act.getDescActividad();
            acts.add(DA);
        }
        DataCuponera res = new DataCuponera(this.nombre, this.descripcion, acts);
        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, descuento, fin, inicio, integras, nombre, registros);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cuponera other = (Cuponera) obj;
        return Objects.equals(descripcion, other.descripcion) && descuento == other.descuento
                && Objects.equals(fin, other.fin) && Objects.equals(inicio, other.inicio)
                && Objects.equals(integras, other.integras) && Objects.equals(nombre, other.nombre)
                //&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
                && Objects.equals(registros, other.registros);
    }

    public Integra getIntegra(Actividad a) {
        for (Integra integra : integras)
            if (integra.getActividad().equals(a))
                return integra;

        return null;
    }

    public boolean tieneActividad(Actividad act) { //Null pointer si le pasa una actividad que no tiene
        boolean ret = false;
        for (Integra integ : integras) {
            if (act.equals(integ.getActividad())) {
                ret = true;
                break;
            }
        }
        return ret;
    }
}
