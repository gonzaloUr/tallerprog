package com.entrenamosuy.tarea1.logic;

import java.util.Map;

public final class Manejador {
    
    private static Manejador instance;

    public static Manejador getInstance() {
        if (instance == null)
            instance = new Manejador();

        return instance;
    }

    private Map<String, Actividad> actividades;

    private Map<String, Clase> clases;

    private Map<String, Cuponera> cuponeras;

    private Map<String, Institucion> instituciones;

    private Map<String, Profesor> profesores;

    private Map<String, Socio> socios;

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

    public Map<String, Socio> getSocios() {
        return socios;
    }

    public void setSocios(Map<String, Socio> socios) {
        this.socios = socios;
    }
}
