package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.Objects;

public class Registro {

    private LocalDate fecha;

    private float costo;

    private Clase claseAsociada;

    public Registro(LocalDate fecha, int costo, Clase claseAsociada) {
        this.fecha = fecha;
        this.costo = costo;
        this.claseAsociada = claseAsociada;
    }

    public Clase getClaseAsociada() {
        return claseAsociada;
    }
 
    public void setClaseAsociada(Clase claseAsociada) {
        this.claseAsociada = claseAsociada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Registro other = (Registro) obj;
        return fecha.equals(other.fecha) && costo == other.costo;
    }


    @Override
    public int hashCode() {
        return Objects.hash(fecha, costo, claseAsociada);
    }
}

