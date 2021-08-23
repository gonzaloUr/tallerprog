package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Cuponera {
    
    private String nombre;

    private String descripcion;
    
    private LocalDateTime inicio, fin;

    private int descuento;

    private float precio;

    private Set<Integra> integras;

    private Set<Registro> registros;

    public Cuponera(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin, int descuento,
            float precio, Set<Integra> integras, Set<Registro> registros) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.descuento = descuento;
        this.precio = precio;
        this.integras = integras;
        this.registros = registros;
    }

    public Cuponera(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin, int descuento,
            float precio) {
        this(nombre, descripcion, inicio, fin, descuento, precio, Collections.emptySet(), Collections.emptySet());
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

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, descuento, fin, inicio, integras, nombre, precio, registros);
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
                && Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
                && Objects.equals(registros, other.registros);
    }
}
