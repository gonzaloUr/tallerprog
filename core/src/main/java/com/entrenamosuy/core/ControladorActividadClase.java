package com.entrenamosuy.core;

import java.util.*;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.entrenamosuy.core.exceptions.*;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.model.*;
import com.entrenamosuy.core.util.Pair;
import com.entrenamosuy.core.util.Triple;

public class ControladorActividadClase implements IControladorActividadClase {

    @Override
    public CrearActividadChain crearActividad() {
        return new CrearActividadChain() {

            private String institucion;

            private String nombre;

            private String descripcion;

            private Duration duracion;

            private float costo;

            private LocalDate registro;

            @Override
            public CrearActividadChain setInstitucion(String institucion) {
                this.institucion = institucion;
                return this;
            }

            @Override
            public CrearActividadChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public CrearActividadChain setDescripcion(String descripcion) {
                this.descripcion = descripcion;
                return this;
            }

            @Override
            public CrearActividadChain setDuracion(Duration duracion) {
                this.duracion = duracion;
                return this;
            }

            @Override
            public CrearActividadChain setCosto(float costo) {
                this.costo = costo;
                return this;
            }

            @Override
            public CrearActividadChain setRegistro(LocalDate registro) {
                this.registro = registro;
                return this;
            }

            @Override
            public void invoke() throws ActividadRepetidaException, InstitucionNoEncontradaException {
                Manejador manejador = Manejador.getInstance();
                Map<String, Actividad> actividades = manejador.getActividades();
                Map<String, Institucion> instituciones = manejador.getInstituciones();

                if (actividades.containsKey(nombre))
                    throw new ActividadRepetidaException("La actividad llamada " + nombre + " ya existe.");

                if (!instituciones.containsKey(institucion))
                    throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);

                Institucion inst = instituciones.get(institucion);
                Actividad nuevaActividad = Actividad.builder()
                        .setNombre(nombre)
                        .setDescripcion(descripcion)
                        .setDuracion(duracion)
                        .setFechaRegistro(registro)
                        .setCosto(costo)
                        .build();
                inst.getActividadesOfrecidas().add(nuevaActividad);
                actividades.put(nombre, nuevaActividad);
            }
        };
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
    public CrearClaseChain crearClase() {
        return new CrearClaseChain() {

            private String nombreActividad;

            private String nombre;

            private LocalDateTime inicio;

            private Set<String> nicknameProfesores;

            private int cantMin, cantMax;

            private URL acceso;

            private LocalDate fechaRegistro;

            @Override
            public CrearClaseChain setNombreActividad(String nombreActividad) {
                this.nombreActividad = nombreActividad;
                return this;
            }

            @Override
            public CrearClaseChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public CrearClaseChain setInicio(LocalDateTime inicio) {
                this.inicio = inicio;
                return this;
            }

            @Override
            public CrearClaseChain setNicknameProfesores(Set<String> nicknameProfesores) {
                this.nicknameProfesores = nicknameProfesores;
                return this;
            }

            @Override
            public CrearClaseChain setCantMin(int cantMin) {
                this.cantMin = cantMin;
                return this;
            }

            @Override
            public CrearClaseChain setCantMax(int cantMax) {
                this.cantMax = cantMax;
                return this;
            }

            @Override
            public CrearClaseChain setAcceso(URL acceso) {
                this.acceso = acceso;
                return this;
            }

            @Override
            public CrearClaseChain setFechaRegistro(LocalDate fechaRegistro) {
                this.fechaRegistro = fechaRegistro;
                return this;
            }

            @Override
            public void invoke() throws ClaseInconsistenteException {
                Manejador maneja = Manejador.getInstance();

                Map<String, Actividad> actividades = maneja.getActividades();
                Map<String, Clase> clases = maneja.getClases();
                Map<String, Profesor> profesores = maneja.getProfesores();
                Actividad actividad = actividades.get(nombreActividad);

                if (actividad == null)
                    throw new ActividadNoEncontradaException("No existe actividad con nombre: " + nombreActividad);

                LocalDateTime registroDateTime = LocalDateTime.of(fechaRegistro, LocalTime.of(0, 0));
                LocalDateTime actividadRegistroDateTime = LocalDateTime.of(actividad.getFechaRegistro(), LocalTime.of(0, 0));

                List<ClaseInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

                if (clases.containsKey(nombre))
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.NOMBRE_REPETIDO);

                if (cantMin > cantMax)
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.CANT_MAX_MENOR_MIN);

                if (registroDateTime.isAfter(inicio))
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.INICIO_MENOR_REGISTRO);

                if (actividadRegistroDateTime.isAfter(registroDateTime))
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.REGISTRO_MENOR_REGISTRO_ACTIVIDAD);

                if (!inconsistencias.isEmpty())
                    throw new ClaseInconsistenteException(inconsistencias);

                Set<Profesor> profes = new HashSet<>();
                for (String nickname : nicknameProfesores) {
                    Profesor p = profesores.get(nickname);

                    if (p == null)
                        throw new ProfesorNoEncontradoException("No existe un profesor con nickname: " + nickname);

                    profes.add(p);
                }

                Set<Registro> registros = new HashSet<>();
                Clase nuevaClase = Clase.builder()
                        .setNombre(nombre)
                        .setInicio(inicio)
                        .setCantMin(cantMin)
                        .setCantMax(cantMax)
                        .setAcceso(acceso)
                        .setFechaRegistro(fechaRegistro)
                        .setRegistros(registros)
                        .setProfesores(profes)
                        .setActividad(actividad)
                        .build();

                for (Profesor p : profes) {
                    p.getClasesDictadas().add(nuevaClase);
                    p.getActividad().add(actividad);
                }

                actividad.getClases().add(nuevaClase);
                clases.put(nombre, nuevaClase);
            }
        };
    }

    @Override
    public void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro) throws RegistroInconsistenteException {

        Manejador man = Manejador.getInstance();
        Clase c = man.getClases().get(clase);
        Socio s = man.getSocios().get(socio);

        if (c == null)
            throw new ClaseNoEncontradaException("No existe una clase con nombre: " + clase);

        if (s == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        List<RegistroInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

        if ((c.getCantMax() - c.getRegistros().size()) <= 0)
            inconsistencias.add(RegistroInconsistenteException.Restriccion.CLASE_LLENA);

        if (fechaRegistro.isBefore(c.getFechaRegistro()))
            inconsistencias.add(RegistroInconsistenteException.Restriccion.FECHA_REGISTRO_MENOR_REGISTRO_CLASE);

        if (!inconsistencias.isEmpty())
            throw new RegistroInconsistenteException(inconsistencias);

        c.registrarseSinCuponera(s, fechaRegistro);
    }

    @Override
    public void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro) throws RegistroInconsistenteException {
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

        List<RegistroInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

        if ((c.getCantMax() - c.getRegistros().size()) <= 0)
            inconsistencias.add(RegistroInconsistenteException.Restriccion.CLASE_LLENA);

        if (fechaRegistro.isBefore(c.getFechaRegistro()))
            inconsistencias.add(RegistroInconsistenteException.Restriccion.FECHA_REGISTRO_MENOR_REGISTRO_CLASE);

        if (!inconsistencias.isEmpty())
            throw new RegistroInconsistenteException(inconsistencias);

        c.registrarseConCuponera(s, fechaRegistro, cup);
    }

    @Override
    public Set<Triple<String, String, URL>> obtenerDescInstituciones() {
        Manejador maneja = Manejador.getInstance();
        Set<Triple<String, String, URL>> res = new HashSet<>();
        Map<String, Institucion> inst = maneja.getInstituciones();

        for (Institucion i : inst.values()) {
            Triple<String, String, URL> trip = new Triple<>(i.getNombre(), i.getDescripcion(), i.getUrl());
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
            Pair<String, String> par = new Pair<>(a.getNombre(), a.getDescripcion());
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
        return a.getDataActividad();
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

        return clase.getDataClase();
    }
}
