package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.Objects;

public class Compra {
    
    private LocalDate fecha;

    private Socio socio;

    private Cuponera cuponera;

    public Compra(LocalDate fecha, Socio socio, Cuponera cuponera) {
        this.fecha = fecha;
        this.socio = socio;
        this.cuponera = cuponera;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Cuponera getCuponera() {
        return cuponera;
    }

    public void setCuponera(Cuponera cuponera) {
        this.cuponera = cuponera;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuponera, fecha, socio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Compra other = (Compra) obj;
        return Objects.equals(cuponera, other.cuponera) && Objects.equals(fecha, other.fecha)
                && Objects.equals(socio, other.socio);
    }
}
