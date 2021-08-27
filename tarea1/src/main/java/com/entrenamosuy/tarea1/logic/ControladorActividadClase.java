package com.entrenamosuy.tarea1.logic;

import java.util.Map;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import com.entrenamosuy.tarea1.exceptions.ActividadRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.data.DataActividad;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.util.Triple;

public class ControladorActividadClase implements IControladorActividadClase {

    @Override
    public void crearActividad(String institucion, String nombre, String descripcion, Duration duracion, float costo,
            LocalDate fecha) throws ActividadRepetidaException, InstitucionNoEncontradaException {
        Manejador maneja = Manejador.getInstance();
        Map<String, Actividad> actividades = maneja.getActividades(); // Tengo que especificar los tipos del map? Tengo
                                                                      // que importar el paquete map?
        if (actividades.containsKey(nombre)) {
            throw new ActividadRepetidaException("La actividad llamada " + nombre + " ya existe.");
        } else {
            Set<Clase> clases =  new HashSet<>();// SET DE CLASES VACIO. Las actividades ahora ven sus clases.
            Actividad nuevaActividad = new Actividad(nombre, descripcion, duracion, fecha, costo, clases);
            actividades.put(nombre, nuevaActividad);
            // me falta linkear la institucion a la actividad o al reves
        }
    }

    @Override
    public void crearInstitucion(String nombre, String descripcion, URL url) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void crearClase(String nombreActividad, String nombre, LocalDate inicio, Set<String> nicknameProfesores,
            int cantMin, int cantMax, URL acceso, LocalDate fechaRegistro) throws UsuarioRepetidoException {
        Manejador maneja = Manejador.getInstance();
        Map<String, Actividad> actividades = maneja.getActividades();   
        Actividad actividad = actividades.get(nombreActividad);
        Map<String, Clase> clases = maneja.getClases();
        if (clases.containsKey(nombre)){
            throw new UsuarioRepetidoException("La clase llamada " + nombre + " ya existe.");
        }
        else {
            Set<Profesor> profes = new HashSet<>();   // ACA CREAMOS LA CLASE CON LOS PROFESORES
            Map<String, Profesor> profesores = maneja.getProfesores();
            Iterator<String> it = nicknameProfesores.iterator();
            while(it.hasNext()) {
                String nomP = it.next();
                Profesor p = profesores.get(nomP);
                profes.add(p);              
            }                                         // ACA CREAMOS LA CLASE CON LOS PROFESORES
            Set<Registro> registros = new HashSet<>();
            Clase nuevaClase = new Clase(nombre, inicio, cantMin, cantMax, acceso, fechaRegistro, registros, profes, actividad); // TAMBIEN SE HACE EL LINK DE CLASE A ACTIVIDAD
            clases.put(nombre, nuevaClase);
            actividad.agregarClase(nuevaClase); // LINK DE ACTIVIDAD A CLASE 
        }
    }

    @Override
    public void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<Triple<String, String, URL>> obtenerDescInstituciones() { //TODO El throw es que no hay instituciones en el sistema
        Manejador maneja = Manejador.getInstance();
        Set<Triple<String, String, URL>> res = new HashSet<>();
        Map<String,Institucion> inst = maneja.getInstituciones();
        for(Institucion i : inst.values()) {
            Triple<String, String, URL> trip = new Triple<String, String, URL>(i.getDescripcion(), i.getDescripcion(), i.getUrl()); 
            res.add(trip);
        }    
        return res;
    }

    @Override
    public Set<Pair<String, String>> obtenerDescActividades(String institucion) { //TODO No hay actividades en el sistema, no existe institucion con ese nombre
        Manejador maneja = Manejador.getInstance();
        Set<Pair<String, String>> res = new HashSet<>();
        Map<String,Institucion> inst = maneja.getInstituciones();
        Institucion i = inst.get(institucion);
        Set<Actividad> acts = i.getActividadesOfrecidas();
        for(Actividad a : acts) {
            Pair<String, String> par = new Pair<String, String>(a.getNombre(), a.getDescripcion());
            res.add(par);
        }
        return res;
    }

    @Override
    public DataActividad consultarActividad(String actividad) { // TODO El throw es que no existe la actividad
        Manejador maneja = Manejador.getInstance();
        Map<String,Actividad> acts = maneja.getActividades();
        Actividad a = acts.get(actividad);
        DataActividad res = a.getDataActividad();
        return res;
    }    


    @Override
    public Set<String> obtenerDescClases(String actividad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataClase consultarClase(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }
}
