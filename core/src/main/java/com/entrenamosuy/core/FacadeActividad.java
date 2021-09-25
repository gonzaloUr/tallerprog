package com.entrenamosuy.core;

import java.util.*;

import javax.xml.crypto.Data;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.LocalDate;

import com.entrenamosuy.core.exceptions.*;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.model.*;

public class FacadeActividad extends AbstractFacadeActividad {

    @Override
    public CrearActividadChain crearActividad() {
        return new CrearActividadChain() {

            private String institucion;

            private String nombre;

            private String descripcion;

            private Duration duracion;

            private float costo;

            private LocalDate registro;

            private ByteBuffer imagen;

            private Set<String> categoriasString = new HashSet<>();

            private ActividadEstado estado = ActividadEstado.INGRESADA;

            private String creador = null;

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
            public CrearActividadChain setImagen(ByteBuffer imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public CrearActividadChain setCategorias(Set<String> categorias) {
                this.categoriasString = categorias;
                return this;
            }

            @Override
            public CrearActividadChain setEstado(ActividadEstado estado) {
                this.estado = estado;
                return this;
            }

            @Override
            public CrearActividadChain setCreador(String creador) {
                this.creador = creador;
                return this;
            }


            @Override
            public void invoke() throws ActividadRepetidaException, InstitucionNoEncontradaException, SinCategoriaException {
                Map<String, Actividad> actividades = getRegistry().getActividades();
                Map<String, Institucion> instituciones = getRegistry().getInstituciones();
                Map<String, Categoria> categorias = getRegistry().getCategorias();
                Map<String, Profesor> profes = getRegistry().getProfesores();
                Profesor profe;

                if ((creador!=null)&&(!profes.containsKey(creador))){
                    throw new UsuarioNoEncontradoException("No existe un profesor de nombre " + creador);
                }

                if (actividades.containsKey(nombre))
                    throw new ActividadRepetidaException("La actividad llamada " + nombre + " ya existe.");

                if (!instituciones.containsKey(institucion))
                    throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);

                Institucion inst = instituciones.get(institucion);

                Set<Categoria> categoriasActiv = new HashSet<>();
                if ((categoriasString==null)||(categoriasString.isEmpty())) {
                    throw new SinCategoriaException("No fueron seleccionadas categorias a asociar.");
                }
                for (String nombre : categoriasString) {
                    Categoria cat = categorias.get(nombre);
                    if (cat == null)
                        throw new CategoriaNoEncontradaException("No existe una categoria con nombre: " + nombre);
                    categoriasActiv.add(cat);
                }
                   
                Actividad nuevaActividad = Actividad.builder()
                        .setNombre(nombre)
                        .setDescripcion(descripcion)
                        .setDuracion(duracion)
                        .setFechaRegistro(registro)
                        .setCosto(costo)
                        .setImagen(imagen)
                        .setCategorias(categoriasActiv)
                        .setEstado(estado)
                        .build();
                inst.getActividadesOfrecidas().add(nuevaActividad);
                actividades.put(nombre, nuevaActividad);
                for(Categoria c : categoriasActiv){
                    c.agregarActividad(nuevaActividad);
                }
                if (creador != null){
                    profe = profes.get(creador);
                    profe.agregarActividadRegistrada(nuevaActividad);
                }
            }
        };
    }

    @Override
    public void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro) throws RegistroInconsistenteException {

        Clase c = getRegistry().getClases().get(clase);
        Socio s = getRegistry().getSocios().get(socio);

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
    public void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro)
        throws RegistroInconsistenteException {

        Clase c = getRegistry().getClases().get(clase);
        Socio s = getRegistry().getSocios().get(socio);
        Cuponera cup = getRegistry().getCuponeras().get(cuponera);

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
    public Set<String> getActividadesDeInstitucion(String institucion) throws InstitucionNoEncontradaException {
        Set<String> res = new HashSet<>();
        Map<String, Institucion> inst = getRegistry().getInstituciones();

        Institucion i = inst.get(institucion);
        if (i == null) {
            throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);
        }
        Set<Actividad> acts = i.getActividadesOfrecidas();
        for (Actividad a : acts){
            if (a.getEstado()==ActividadEstado.ACEPTADA)
                res.add(a.getNombre());
        }
        return res;
    }

    @Override
    public DataActividad getDataActividad(String actividad) throws ActividadNoEncontradaException {
        Map<String, Actividad> acts = getRegistry().getActividades();
        if (acts.isEmpty())
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        Actividad a = acts.get(actividad);
        if (a == null) {
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        }
        return a.getDataActividad();
    }

    @Override
    public Set<String> getCategorias() {
        Map<String, Categoria> categorias = getRegistry().getCategorias();

        Set<String> ret = new HashSet<>();

        for (Categoria cat : categorias.values())
            ret.add(cat.getNombre());

        return ret;
    }

    @Override
    public Set<String> getActividadesDeCategoria(String categoria){
        Map<String, Categoria> categorias = getRegistry().getCategorias();
        Set<Actividad> actividades = categorias.get(categoria).getActividades();
        Set<String> ret = new HashSet<>();
        for (Actividad act : actividades)
            ret.add(act.getNombre());
        return ret;
    }

    @Override
    public void crearCategoria(String nombre) 
        throws CategoriaRepetidaException{
        Map<String, Categoria> categorias = getRegistry().getCategorias();
        Set<Actividad> actividades = new HashSet<>();
        Set<Cuponera> cuponeras = new HashSet<>();
        if (categorias.containsKey(nombre))
            throw new CategoriaRepetidaException("La categoria de nombre " + nombre + " ya existe.");
        Categoria cat = new Categoria(nombre, actividades, cuponeras);
        categorias.put(nombre,cat);
    }
    @Override
    public Set<DataActividad> listaractividadesRegistradas(){
        Map<String,Actividad> actividades = getRegistry().getActividades();
        Set<DataActividad> ret = new HashSet<>();
        for (Map.Entry<String,Actividad> a : actividades.entrySet()){
            if (a.getValue().getEstado()==ActividadEstado.INGRESADA)
                ret.add(a.getValue().getDataActividad());
        }
        return ret;
    }

    @Override
    public void aceptarActividad(String actividad){
        Actividad a = getRegistry().getActividades().get(actividad);
        a.setEstado(ActividadEstado.ACEPTADA);
    }

    @Override
    public void rechazarActividad(String actividad){
        Actividad a = getRegistry().getActividades().get(actividad);
        a.setEstado(ActividadEstado.RECHAZADA);
    }
}
