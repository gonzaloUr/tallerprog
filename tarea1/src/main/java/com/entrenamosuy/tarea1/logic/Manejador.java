package com.entrenamosuy.tarea1.logic;

import java.util.HashMap;
import java.util.Map;
import com.entrenamosuy.tarea1.data.Email;

public final class Manejador {

    private static Manejador instance;

    public static Manejador getInstance() {
        if (instance == null)
            instance = new Manejador();

        return instance;
    }

    private Map<String, Actividad> actividades = new HashMap<>();

    private Map<String, Clase> clases = new HashMap<>();

    private Map<String, Cuponera> cuponeras = new HashMap<>();

    private Map<String, Institucion> instituciones = new HashMap<>();

    private Map<String, Profesor> profesores = new HashMap<>();
    
    private Map<Email, Profesor> profesoresMail = new HashMap<>();

    private Map<String, Socio> socios = new HashMap<>();
    
    private Map<Email, Socio> sociosMail = new HashMap<>();

    private Manejador() {}

    public static void setInstance(Manejador instance) {
        Manejador.instance = instance;
    }

    public Map<String, Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Map<String, Actividad> actividades) {
        this.actividades = actividades;
    }

    public Map<String, Clase> getClases() {
        return clases;
    }

    public void setClases(Map<String, Clase> clases) {
        this.clases = clases;
    }

    public Map<String, Cuponera> getCuponeras() {
        return cuponeras;
    }

    public void setCuponeras(Map<String, Cuponera> cuponeras) {
        this.cuponeras = cuponeras;
    }

    public Map<String, Institucion> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Map<String, Institucion> instituciones) {
        this.instituciones = instituciones;
    }

    public Map<String, Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Map<String, Profesor> profesores) {
        this.profesores = profesores;
    }

    public Map<Email, Profesor> getProfesoresMail() {
        return profesoresMail;
    }

    public void setProfesoresMail(Map<Email, Profesor> profesores) {
        this.profesoresMail = profesores;
    }

    public Map<String, Socio> getSocios() {
        return socios;
    }

    public void setSocios(Map<String, Socio> socios) {
        this.socios = socios;
    }

    public Map<Email, Socio> getSociosMail() {
        return sociosMail;
    }

    public void setSociosMail(Map<Email, Socio> socios) {
        this.sociosMail = socios;
    }
}
