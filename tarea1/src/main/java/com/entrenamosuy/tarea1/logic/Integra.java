package com.entrenamosuy.tarea1.logic;

import java.util.Objects;
import java.util.Set;

public class Integra {

    private int cantClases;

    private Set<Actividad> actividades;

    public Integra(int cantClases, Set<Actividad> actividades) {
        this.cantClases = cantClases;
        this.actividades = actividades;
    }

    public int getCantClases() {
        return cantClases;
    }

    public void setCantClases(int cantClases) {
        this.cantClases = cantClases;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantClases, actividades);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Integra other = (Integra) obj;
        return cantClases == other.cantClases && actividades.equals(other.actividades);
    }
}
