package com.entrenamosuy.tarea1.logic;

import java.util.Map;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import com.entrenamosuy.tarea1.exceptions.ClaseInicioRegistroInvalidoException;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ActividadRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ClaseCantInvalidoException;
import com.entrenamosuy.tarea1.exceptions.ClaseRepetidaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRegistroActividadInvalidaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRegistroInvalidoException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.ClaseLlenaException;
import com.entrenamosuy.tarea1.data.DataActividad;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.util.Pair;
import com.entrenamosuy.tarea1.util.Triple;

public class ControladorActividadClase implements IControladorActividadClase {

    @Override
    public void crearActividad(String institucion, String nombre, String descripcion, Duration duracion, float costo,
                               LocalDate fecha) throws ActividadRepetidaException, InstitucionNoEncontradaException {
        Manejador manejador = Manejador.getInstance();
        Map<String, Actividad> actividades = manejador.getActividades();
        Map<String, Institucion> instituciones = manejador.getInstituciones();

        if (actividades.containsKey(nombre))
            throw new ActividadRepetidaException("La actividad llamada " + nombre + " ya existe.");
        if (!instituciones.containsKey(institucion))
            throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);
        Institucion inst = instituciones.get(institucion);
        Actividad nuevaActividad = new Actividad(nombre, descripcion, duracion, fecha, costo);
        inst.getActividadesOfrecidas().add(nuevaActividad);
        actividades.put(nombre, nuevaActividad);
    }

    @Override
    public void crearInstitucion(String nombre, String descripcion, URL url) throws InstitucionRepetidaException {
        Manejador maneja = Manejador.getInstance();
        Map<String, Institucion> instituciones = maneja.getInstituciones();
        if (instituciones.containsKey(nombre)) {
            throw new InstitucionRepetidaException("La institución llamada " + nombre + " ya existe.");
        }
        Institucion res = new Institucion(nombre, descripcion, url);
        instituciones.put(nombre, res);

    }

    @Override
    public void crearClase(String nombreActividad, String nombre, LocalDateTime inicio, Set<String> nicknameProfesores,
                           int cantMin, int cantMax, URL acceso, LocalDate fechaRegistro) 
                           throws ClaseRepetidaException, ActividadNoEncontradaException, ProfesorNoEncontradoException, 
                                  ClaseInicioRegistroInvalidoException, ClaseCantInvalidoException, ClaseCantInvalidoException,
                                  ClaseRegistroActividadInvalidaException {

        Manejador maneja = Manejador.getInstance();

        Map<String, Actividad> actividades = maneja.getActividades();
        Map<String, Clase> clases = maneja.getClases();
        Map<String, Profesor> profesores = maneja.getProfesores();
        Actividad actividad = actividades.get(nombreActividad);

        if (actividad == null)
            throw new ActividadNoEncontradaException("No existe actividad con nombre: " + nombreActividad);
            
        LocalDateTime x = LocalDateTime.of(fechaRegistro, LocalTime.of(0, 0));
        LocalDateTime y = LocalDateTime.of(actividad.getFechaRegistro(), LocalTime.of(0, 0));

        if (clases.containsKey(nombre))
            throw new ClaseRepetidaException("La clase llamada " + nombre + " ya existe.");
        if (cantMin > cantMax)
            throw new ClaseCantInvalidoException("El minimo deber ser menor al maximo.");
        if (x.isAfter(inicio))
            throw new ClaseInicioRegistroInvalidoException("La fecha de inicio debe ser porsterior a la de registro.");
        if (y.isBefore(x))
            throw new ClaseRegistroActividadInvalidaException("");

        Set<Profesor> profes = new HashSet<>();
        for (String nickname : nicknameProfesores) {
            Profesor p = profesores.get(nickname);

            if (p == null)
                throw new ProfesorNoEncontradoException("No existe un profesor con nickname: " + nickname);

            profes.add(p);
        }
        Set<Registro> registros = new HashSet<>();
        Clase nuevaClase = new Clase(nombre, inicio, cantMin, cantMax, acceso, fechaRegistro, registros, profes, actividad);
        
        for (Profesor p : profes) {
            p.getClasesDictadas().add(nuevaClase);
            p.getActividad().add(actividad);
        }

        actividad.getClases().add(nuevaClase);
        clases.put(nombre, nuevaClase);
    }

    @Override
    public void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro)
        throws ClaseNoEncontradaException, SocioNoEncontradoException, ClaseLlenaException, ClaseRegistroInvalidoException  {

        Manejador man = Manejador.getInstance();
        Clase c = man.getClases().get(clase);
        Socio s = man.getSocios().get(socio);

        if (c == null)
            throw new ClaseNoEncontradaException("No existe una clase con nombre: " + clase);

        if (s == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

         if ((c.getCantMax() - c.getRegistros().size()) <= 0) 
            throw new ClaseLlenaException("La clase esta ya esta llena");
            
        if (fechaRegistro.isBefore(c.getFechaRegistro()))   
            throw new ClaseRegistroInvalidoException("La fecha de registro no puede ser anterior que la fecha de registro de la clase");     

        c.registrarseSinCuponera(s, fechaRegistro);
    }

    @Override
    public void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro) 
        throws CuponeraNoEncontradaException, SocioNoEncontradoException, ClaseLlenaException, 
               ClaseNoEncontradaException, ClaseRegistroInvalidoException {

        Manejador maneja = Manejador.getInstance();
        Clase c = maneja.getClases().get(clase);
        Socio s = maneja.getSocios().get(socio);
        Cuponera cup = maneja.getCuponeras().get(cuponera);

        if (c == null)
            throw new ClaseNoEncontradaException("No existe una clase con nombre: " + clase);

        if (s == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        if (cup == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre: " + cuponera);

        if ((c.getCantMax() - c.getRegistros().size()) <= 0) 
            throw new ClaseLlenaException("La clase esta ya esta llena");
            
        if (fechaRegistro.isBefore(c.getFechaRegistro())) 
            throw new ClaseRegistroInvalidoException("La fecha de registro no puede ser anterior que la fecha de registro de la clase");     

        c.registrarseConCuponera(s, fechaRegistro, cup);
    }

    @Override
    public Set<Triple<String, String, URL>> obtenerDescInstituciones() {
        Manejador maneja = Manejador.getInstance();
        Set<Triple<String, String, URL>> res = new HashSet<>();
        Map<String, Institucion> inst = maneja.getInstituciones();

        for (Institucion i : inst.values()) {
            Triple<String, String, URL> trip = new Triple<String, String, URL>(i.getNombre(), i.getDescripcion(), i.getUrl());
            res.add(trip);
        }
        return res;
    }

    @Override
    public Set<Pair<String, String>> obtenerDescActividades(String institucion) throws InstitucionNoEncontradaException {
        Manejador maneja = Manejador.getInstance();
        Set<Pair<String, String>> res = new HashSet<>();
        Map<String, Institucion> inst = maneja.getInstituciones();
        Institucion i = inst.get(institucion);
        if (i == null) {
            throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);
        }
        Set<Actividad> acts = i.getActividadesOfrecidas();
        for (Actividad a : acts) {
            Pair<String, String> par = new Pair<String, String>(a.getNombre(), a.getDescripcion());
            res.add(par);
        }

        return res;
    }

    @Override
    public DataActividad consultarActividad(String actividad) throws ActividadNoEncontradaException {
        Manejador maneja = Manejador.getInstance();
        Map<String, Actividad> acts = maneja.getActividades();
        if (acts.isEmpty())
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        Actividad a = acts.get(actividad);
        if (a == null) {
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        }
        DataActividad res = a.getDataActividad();
        return res;
    }


    @Override
    public Set<String> obtenerDescClases(String actividad) throws ActividadNoEncontradaException {
        Manejador maneja = Manejador.getInstance();
        Actividad act = maneja.getActividades().get(actividad);
        if (act == null)
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        Set<Clase> clases = act.getClases();
        Set<String> res = new HashSet<>();
        for (Clase clase : clases)
            res.add(clase.getNombre());

        return res;
    }

    @Override
    public DataClase consultarClase(String nombre) throws ClaseNoEncontradaException {
        Manejador maneja = Manejador.getInstance();
        Clase clase = maneja.getClases().get(nombre);
        if (clase == null)
            throw new ClaseNoEncontradaException("No existe clase con nombre:" + nombre);

        DataClase res = clase.getDataClase();
        return res;
    }
}
