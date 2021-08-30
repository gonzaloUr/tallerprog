package com.entrenamosuy.tarea1.data;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class DataClase {

    private final String nombre;

    private final LocalDateTime inicio;

    private final int cantMin, cantMax;

    private final URL accesoURL;

    private final DescActividad actividad;

    private final Set<DescProfesor> profesores;

    public DataClase(String nombre, LocalDateTime inicio, int cantMin, int cantMax, URL accesoURL,
	    DescActividad actividad2, Set<DescProfesor> set2) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.accesoURL = accesoURL;
        this.actividad = actividad2;
        this.profesores = set2;
    }

    
    
    public String getNombre() {
        return nombre;
    }



    public LocalDateTime getInicio() {
        return inicio;
    }



    public int getCantMin() {
        return cantMin;
    }



    public int getCantMax() {
        return cantMax;
    }



    public URL getAccesoURL() {
        return accesoURL;
    }



    public DescActividad getActividad() {
        return actividad;
    }



    public Set<DescProfesor> getProfesores() {
        return profesores;
    }



    @Override
    public int hashCode() {
        return Objects.hash(accesoURL, actividad, cantMax, cantMin, inicio, nombre, profesores);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataClase other = (DataClase) obj;
        return accesoURL.equals(other.accesoURL) && actividad.equals(other.actividad)
                && cantMax == other.cantMax && cantMin == other.cantMin && inicio.equals(other.inicio)
                && nombre.equals(other.nombre) && profesores.equals(other.profesores);
    }
}
