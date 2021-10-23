package com.entrenamosuy.core;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;

import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.SinCategoriaException;
import com.entrenamosuy.core.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.core.exceptions.RegistroInconsistenteException;
import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.core.exceptions.CategoriaNoEncontradaException;
import com.entrenamosuy.core.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.core.exceptions.CategoriaRepetidaException;
import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;


import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;

import com.entrenamosuy.core.model.ActividadEstado;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Categoria;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.model.Clase;
import com.entrenamosuy.core.model.Socio;
import com.entrenamosuy.core.model.Cuponera;

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

            private File imagen;

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
            public CrearActividadChain setImagen(File imagen) {
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

                if (creador!=null&&!profes.containsKey(creador)){
                    throw new UsuarioNoEncontradoException("No existe un profesor de nombre " + creador);
                }

                if (actividades.containsKey(nombre))
                    throw new ActividadRepetidaException("La actividad llamada " + nombre + " ya existe.");

                if (!instituciones.containsKey(institucion))
                    throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);

                Institucion inst = instituciones.get(institucion);

                Set<Categoria> categoriasActiv = new HashSet<>();
                if (categoriasString==null||categoriasString.isEmpty()) {
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
                for (Categoria cat : categoriasActiv){
                    cat.agregarActividad(nuevaActividad);
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

        Clase clas = getRegistry().getClases().get(clase);
        Socio soci = getRegistry().getSocios().get(socio);

        if (clas == null)
            throw new ClaseNoEncontradaException("No existe una clase con nombre: " + clase);

        if (soci == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        List<RegistroInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

        Set<DataClase> clasesDeSocio = soci.getDataSocio().getClases();
        for (DataClase c: clasesDeSocio){
            if (c.getNombre().equals(clase)){
                inconsistencias.add(RegistroInconsistenteException.Restriccion.YA_REGISTRADO_A_CLASE);
                break;
            }
        }

        if ((clas.getCantMax() - clas.getRegistros().size()) <= 0)
            inconsistencias.add(RegistroInconsistenteException.Restriccion.CLASE_LLENA);

        if (fechaRegistro.isBefore(clas.getFechaRegistro()))
            inconsistencias.add(RegistroInconsistenteException.Restriccion.FECHA_REGISTRO_MENOR_REGISTRO_CLASE);

        if (!inconsistencias.isEmpty())
            throw new RegistroInconsistenteException(inconsistencias);

        clas.registrarseSinCuponera(soci, fechaRegistro);
    }

    @Override
    public void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro)
        throws RegistroInconsistenteException {

        Clase clas = getRegistry().getClases().get(clase);
        Socio soci = getRegistry().getSocios().get(socio);
        Cuponera cup = getRegistry().getCuponeras().get(cuponera);

        if (clas == null)
            throw new ClaseNoEncontradaException("No existe una clase con nombre: " + clase);

        if (soci == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        if (cup == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre: " + cuponera);

        List<RegistroInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

        Set<DataClase> clasesDeSocio = soci.getDataSocio().getClases();
        for (DataClase c: clasesDeSocio) {
            if (c.getNombre().equals(clase)){
                inconsistencias.add(RegistroInconsistenteException.Restriccion.YA_REGISTRADO_A_CLASE);
                break;
            }
        }

        if ((clas.getCantMax() - clas.getRegistros().size()) <= 0)
            inconsistencias.add(RegistroInconsistenteException.Restriccion.CLASE_LLENA);

        if (fechaRegistro.isBefore(clas.getFechaRegistro()))
            inconsistencias.add(RegistroInconsistenteException.Restriccion.FECHA_REGISTRO_MENOR_REGISTRO_CLASE);

        if (!inconsistencias.isEmpty())
            throw new RegistroInconsistenteException(inconsistencias);

        clas.registrarseConCuponera(soci, fechaRegistro, cup);
    }

    @Override
    public Set<String> getActividadesDeInstitucion(String institucion) throws InstitucionNoEncontradaException {
        Set<String> res = new HashSet<>();
        Map<String, Institucion> inst = getRegistry().getInstituciones();

        Institucion ins = inst.get(institucion);
        if (ins == null) {
            throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);
        }
        Set<Actividad> acts = ins.getActividadesOfrecidas();
        for (Actividad activ : acts){
            if (activ.getEstado()==ActividadEstado.ACEPTADA)
                res.add(activ.getNombre());
        }
        return res;
    }

    @Override
    public DataActividad getDataActividad(String actividad) throws ActividadNoEncontradaException {
        Map<String, Actividad> acts = getRegistry().getActividades();
        if (acts.isEmpty())
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        Actividad activ = acts.get(actividad);
        if (activ == null) {
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        }
        return activ.getDataActividad();
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
            if (act.getEstado()==ActividadEstado.ACEPTADA){
                ret.add(act.getNombre());
            }
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
        categorias.put(nombre, cat);
    }
    @Override
    public Set<DataActividad> listarActividadesIngresadas(){
        Map<String, Actividad> actividades = getRegistry().getActividades();
        Set<DataActividad> ret = new HashSet<>();
        for (Map.Entry<String, Actividad> activ : actividades.entrySet()){
            if (activ.getValue().getEstado()==ActividadEstado.INGRESADA)
                ret.add(activ.getValue().getDataActividad());
        }
        return ret;
    }

    @Override
    public Set<DataActividad> listarActividadesAceptadas(){
        Map<String, Actividad> actividades = getRegistry().getActividades();
        Set<DataActividad> ret = new HashSet<>();
        for (Map.Entry<String, Actividad> activ : actividades.entrySet()){
            if (activ.getValue().getEstado()==ActividadEstado.ACEPTADA)
                ret.add(activ.getValue().getDataActividad());
        }
        return ret;
    }

    @Override
    public void aceptarActividad(String actividad){
        Actividad activ = getRegistry().getActividades().get(actividad);
        activ.setEstado(ActividadEstado.ACEPTADA);
    }

    @Override
    public void rechazarActividad(String actividad){
        Actividad activ = getRegistry().getActividades().get(actividad);
        activ.setEstado(ActividadEstado.RECHAZADA);
    }

    @Override
    public File getImagenActividad(String id) {
        Actividad actividad = getRegistry().getActividades().get(id);
        return actividad.getImagen();
    }
}
