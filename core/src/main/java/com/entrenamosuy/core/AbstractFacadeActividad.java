package com.entrenamosuy.core;

import java.io.File;
import java.util.Set;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.CategoriaRepetidaException;
import com.entrenamosuy.core.exceptions.RegistroInconsistenteException;
import com.entrenamosuy.core.model.ActividadEstado;

import java.time.Duration;
import java.time.LocalDate;

public abstract class AbstractFacadeActividad extends AbstractFacade {

    public interface CrearActividadChain {

        CrearActividadChain setInstitucion(String institucion);

        CrearActividadChain setNombre(String nombre);

        CrearActividadChain setDescripcion(String descripcion);

        CrearActividadChain setDuracion(Duration duracion);

        CrearActividadChain setCosto(float costo);

        CrearActividadChain setRegistro(LocalDate registro);

        CrearActividadChain setImagen(File imagen);

        CrearActividadChain setCategorias(Set<String> categorias);

        CrearActividadChain setEstado(ActividadEstado estado);

        CrearActividadChain setCreador(String creador);

        void invoke() throws ActividadRepetidaException;
    }

    public abstract CrearActividadChain crearActividad();

    public abstract void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro)
            throws RegistroInconsistenteException;

    public abstract void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro)
            throws RegistroInconsistenteException;

    public abstract Set<String> getActividadesDeInstitucion(String institucion);

    public abstract DataActividad getDataActividad(String actividad);

    public abstract Set<String> getCategorias();

    public abstract Set<String> getActividadesDeCategoria(String categoria);

    public abstract void crearCategoria(String nombre) throws CategoriaRepetidaException;

    public abstract Set<DataActividad> listarActividadesIngresadas(); //Devuelve las actividades de estado Ingresada

    public abstract Set<DataActividad> listarActividadesAceptadas(); //Devuelve las actividades de estado Aceptada

    public abstract void aceptarActividad(String actividad);

    public abstract void rechazarActividad(String actividad);

    public abstract File getImagenActividad(String id);
}
