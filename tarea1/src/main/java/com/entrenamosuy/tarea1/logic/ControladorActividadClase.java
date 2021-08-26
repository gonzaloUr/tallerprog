package com.entrenamosuy.tarea1.logic;

import java.util.Map;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import com.entrenamosuy.tarea1.exceptions.ActividadRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.util.Triple;

public class ControladorActividadClase implements IControladorActividadClase {

    @Override
    public void crearActividad(String institucion, String nombre, String descripcion, Duration duracion, float costo,
            LocalDateTime fecha) throws ActividadRepetidaException, InstitucionNoEncontradaException {
        Manejador maneja = Manejador.getInstance();
        Map<String, Actividad> actividades = maneja.getActividades(); // Tengo que especificar los tipos del map? Tengo
                                                                      // que importar el paquete map?
        if (actividades.containsKey(nombre)) {
            throw new ActividadRepetidaException("La actividad llamada " + nombre + " ya existe.");
        } else {
            Actividad nuevaActividad = new Actividad(nombre, descripcion, duracion, fecha, costo);
            actividades.put(nombre, nuevaActividad);
            // me falta linkear la institucion a la actividad o al reves
        }
    }

    @Override
    public void crearInstitucion(String nombre, String descripcion, URL url) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void crearClase(String nombreActividad, String nombre, LocalDateTime inicio, Set<String> nombreProfesores,
            int cantMin, int cantMax, URL acceso, LocalDateTime fechaRegistro) throws UsuarioRepetidoException {
        Manejador maneja = Manejador.getInstance();
        Map<String, Actividad> actividades = maneja.getActividades();   
        Actividad actividad = actividades.get(nombreActividad);
        Map<String, Clase> clases = maneja.getClases();
        if (clases.containsKey(nombre)){
            throw new UsuarioRepetidoException("La clase llamada " + nombre + " ya existe.");
        }
        else {
            Clase nuevaClase = new Clase(nombre, inicio, cantMin, cantMax, acceso, fechaRegistro);
            clases.put(nombre, nuevaClase);
            //falta linkear la clase a actividad o viceversa
        }
    }

    @Override
    public void registarseSinCuponera(String socio, String clase, LocalDateTime fechaRegistro) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registraseConCuponera(String socio, String clase, String cuponera, LocalDateTime fechaRegistro) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<Triple<String, String, URL>> obtenerDescInstituciones() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Pair<String, String>> obtenerDescActividades(String institucion) {
        // TODO Auto-generated method stub
        return null;
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
