package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.net.URL;
import java.util.Set;
import java.util.Objects;
import java.util.Collections;
import com.entrenamosuy.tarea1.data.DataClase;

public class Clase {

    private String nombre;

    private LocalDateTime inicio;

    private int cantMin, cantMax;
    
    private URL acceso;

    private LocalDateTime fechaRegistro;

    private Set<Registro> registros;

    public Clase(String nombre, LocalDateTime inicio, int cantMin, int cantMax,
                 URL acceso, LocalDateTime fechaRegistro, Set<Registro> registros) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.acceso = acceso;
        this.fechaRegistro = fechaRegistro;
        this.registros = registros;
    }

    public Clase(String nombre, LocalDateTime inicio, int cantMin, int cantMax,
                 URL acceso, LocalDateTime fechaRegistro) {
        this(nombre, inicio, cantMin, cantMax, acceso, fechaRegistro, Collections.emptySet());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public int getCantMin() {
        return cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public URL getAcceso() {
        return acceso;
    }

    public void setAcceso(URL acceso) {
        this.acceso = acceso;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<Registro> registros) {
        this.registros = registros;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceso, cantMax, cantMin, fechaRegistro, inicio, nombre, registros);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Clase other = (Clase) obj;
        return Objects.equals(acceso, other.acceso) && cantMax == other.cantMax && cantMin == other.cantMin
                && Objects.equals(fechaRegistro, other.fechaRegistro) && Objects.equals(inicio, other.inicio)
                && Objects.equals(nombre, other.nombre) && Objects.equals(registros, other.registros);
    }

    public DataClase getDataClase() {
        return null;
    }
}
