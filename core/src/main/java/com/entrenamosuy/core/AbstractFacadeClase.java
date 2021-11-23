package com.entrenamosuy.core;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.List;

public abstract class AbstractFacadeClase extends AbstractFacade {

    public interface CrearClaseChain {

        CrearClaseChain setNombreActividad(String nombreActividad);

        CrearClaseChain setNombre(String nombre);

        CrearClaseChain setInicio(LocalDateTime inicio);

        CrearClaseChain setNicknameProfesores(Set<String> nicknameProfesores);

        CrearClaseChain setCantMin(int cantMin);

        CrearClaseChain setCantMax(int cantMax);

        CrearClaseChain setAcceso(URL acceso);

        CrearClaseChain setFechaRegistro(LocalDate fechaRegistro);

        CrearClaseChain setImagen(File imagen);

        CrearClaseChain setPremio(String premio);

        CrearClaseChain setCantPremios(int cantPremios);

        CrearClaseChain setFechaSorteo(LocalDate fechaSorteo);

        void invoke() throws ClaseInconsistenteException;
    }

    public abstract CrearClaseChain crearClase();

    public abstract Set<String> getClases(String actividad);

    public abstract DataClase getDataClase(String nombre);

    public abstract File getImagenClase(String ident);
    
    public abstract void realizarSorteo(String clase);

    public abstract List<DataSocio> getGanadores(String clase);
    
    public abstract List<DataSocio> getRegistrados(String clase);
    
    public abstract int getEstadoSorteo(String clase);

    public abstract void agregarSocioAGanadores(String socio, String clase);

    public abstract boolean chequearSiClaseDictada(String cla);
}
