package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.net.URL;
import java.util.Set;
import java.util.Objects;
//import java.util.Collections;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.data.DescProfesor;
import com.entrenamosuy.tarea1.data.DescActividad;

public class Clase {

    private String nombre;

    private LocalDateTime inicio;

    private int cantMin, cantMax;
    
    private URL acceso;

    private LocalDateTime fechaRegistro;

    private Set<Registro> registros;

    private Set<Profesor> profesores;

    private Actividad actividad;

    public Clase(String nombre, LocalDateTime inicio, int cantMin, int cantMax,
                 URL acceso, LocalDateTime fechaRegistro, Set<Registro> registros, 
                 Set<Profesor> profesores, Actividad actividad) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.acceso = acceso;
        this.fechaRegistro = fechaRegistro;
        this.registros = registros;
        this.profesores = profesores;
        this.actividad = actividad;
    }

/*    public Clase(String nombre, LocalDateTime inicio, int cantMin, int cantMax,
                 URL acceso, LocalDateTime fechaRegistro) {
        this(nombre, inicio, cantMin, cantMax, acceso, fechaRegistro, Collections.emptySet());
    }*/

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

    public Set<Profesor> getProfesores() {
        return profesores;
    }
    

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
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
        Set<DescProfesor> profes = null ;
        DescActividad act = null;
        DataClase res = new DataClase(this.getNombre(), this.getInicio(), this.getCantMin(), this.getCantMax(), this.getAcceso(),
            this.getRegistros(), act, profes);
        return res;


      //  public DataClase(String nombre, LocalDateTime inicio, int cantMin, int cantMax, URL accesoURL,
           // LocalDateTime registro, DescActividad actividad, Set<DescProfesor> profesores)
    }
}
