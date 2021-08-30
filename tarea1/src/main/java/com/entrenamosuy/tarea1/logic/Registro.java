package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.Objects;

public class Registro {

    private LocalDate fecha;

    private float costo;

    private Clase claseAsociada;

    private Socio socio;

    private Cuponera cuponera;

    public Registro(LocalDate fecha, float costo, Clase claseAsociada, Socio socio, Cuponera cuponera) {
        this.fecha = fecha;
        this.costo = costo;
        this.claseAsociada = claseAsociada;
        this.socio = socio;
        this.cuponera = cuponera;
    }

    public Registro(LocalDate fecha, float costo, Clase claseAsociada, Socio socio) {
        this(fecha, costo, claseAsociada, socio, null);
    }

    public Cuponera getCuponera() {
        return cuponera;
    }

    public void setCuponera(Cuponera cup) {
        this.cuponera = cup;
    }

    public Clase getClaseAsociada() {
        return claseAsociada;
    }

    public void setClaseAsociada(Clase claseAsociada) {
        this.claseAsociada = claseAsociada;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
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
    public int hashCode() {
        return Objects.hash(costo, cuponera, fecha);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Registro other = (Registro) obj;
        return Objects.equals(claseAsociada, other.claseAsociada)
                && Float.floatToIntBits(costo) == Float.floatToIntBits(other.costo)
                && Objects.equals(cuponera, other.cuponera) && Objects.equals(fecha, other.fecha);
    }
}

