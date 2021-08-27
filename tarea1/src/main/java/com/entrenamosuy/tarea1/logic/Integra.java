package com.entrenamosuy.tarea1.logic;

import java.util.Objects;

public class Integra {

    private int cantClases;

    private Actividad actividad;

    public Integra(int cantClases, Actividad actividad) {
        this.cantClases = cantClases;
        this.actividad = actividad;
    }

    public int getCantClases() {
        return cantClases;
    }

    public void setCantClases(int cantClases) {
        this.cantClases = cantClases;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad (Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantClases, actividad);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Integra other = (Integra) obj;
        return cantClases == other.cantClases && actividad.equals(other.actividad);
    }
}
