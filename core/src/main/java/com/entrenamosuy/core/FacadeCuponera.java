package com.entrenamosuy.core;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.exceptions.CuponeraInconsistenteException;
import com.entrenamosuy.core.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.core.exceptions.CuponeraYaPoseidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Categoria;
import com.entrenamosuy.core.model.Cuponera;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Integra;
import com.entrenamosuy.core.model.Socio;
import com.entrenamosuy.core.model.Compra;

public class FacadeCuponera extends AbstractFacadeCuponera {

    @Override
    public CrearCuponeraChain crearCuponera() {
        return new CrearCuponeraChain() {

            private String nombre;

            private String descripcion;

            private LocalDate inicio;

            private LocalDate fin;

            private int descuento;

            private LocalDate fechaRegistro;

            private File imagen;

            @Override
            public CrearCuponeraChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public CrearCuponeraChain setDescripcion(String descripcion) {
                this.descripcion = descripcion;
                return this;
            }

            @Override
            public CrearCuponeraChain setInicio(LocalDate inicio) {
                this.inicio = inicio;
                return this;
            }

            @Override
            public CrearCuponeraChain setFin(LocalDate fin) {
                this.fin = fin;
                return this;
            }

            @Override
            public CrearCuponeraChain setDescuento(int descuento) {
                this.descuento = descuento;
                return this;
            }

            @Override
            public CrearCuponeraChain setFechaRegistro(LocalDate fechaRegistro) {
                this.fechaRegistro = fechaRegistro;
                return this;
            }

            @Override
            public CrearCuponeraChain setImagen(File imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public void invoke() throws CuponeraInconsistenteException {
                Map<String, Cuponera> cuponeras = getRegistry().getCuponeras();

                List<CuponeraInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

                if (cuponeras.containsKey(nombre))
                    inconsistencias.add(CuponeraInconsistenteException.Restriccion.NOMBRE_REPETIDO);

                if (inicio.isAfter(fin))
                    inconsistencias.add(CuponeraInconsistenteException.Restriccion.FIN_MENOR_INICIO);

                if (inicio.isBefore(fechaRegistro))
                    inconsistencias.add(CuponeraInconsistenteException.Restriccion.INICIO_MENOR_REGISTRO);

                if (!inconsistencias.isEmpty())
                    throw new CuponeraInconsistenteException(inconsistencias);

                Cuponera nuevaCup = Cuponera.builder()
                        .setNombre(nombre)
                        .setDescripcion(descripcion)
                        .setInicio(inicio)
                        .setFin(fin)
                        .setDescuento(descuento)
                        .setFechaRegistro(fechaRegistro)
                        .setImagen(imagen)
                        .build();

                cuponeras.put(nombre, nuevaCup);
            }
        };
    }

    @Override
    public Set<String> cuponerasUsables(String actividad, String socio)
        throws ActividadNoEncontradaException, SocioNoEncontradoException {

        Socio soci = getRegistry().getSocios().get(socio);
        Actividad activ = getRegistry().getActividades().get(actividad);

        if (soci == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        if (activ == null)
            throw new ActividadNoEncontradaException("No existe una actividad con nombre: " + actividad);

        return soci.cuponerasUsables(activ);
    }

    @Override
    public Set<String> actividadesAgregables(String cuponera, String institucion)
        throws CuponeraNoEncontradaException, InstitucionNoEncontradaException {

        Map<String, Cuponera> cuponeras = getRegistry().getCuponeras();
        Map<String, Institucion> instituciones = getRegistry().getInstituciones();
        Cuponera cup = cuponeras.get(cuponera);
        Institucion ins = instituciones.get(institucion);
        if (cup == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre: " + cuponera);
        if (ins == null)
            throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);
        Set<String> res = ins.actividadesAgregables(cup);
        return res;
    }

    @Override
    public void agregarACuponera(String cuponera, String actividad, int cant)
        throws ActividadNoEncontradaException, CuponeraNoEncontradaException {

        Cuponera cup = getRegistry().getCuponeras().get(cuponera);
        Actividad activ = getRegistry().getActividades().get(actividad);

        if (activ == null)
            throw new ActividadNoEncontradaException("No existe una actividad con nombre: " + actividad);

        if (cup == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre:" + cuponera);

        Integra integra = new Integra(cant, activ, cup);
        cup.getIntegras().add(integra);
        activ.getIntegras().add(integra);
        for ( Categoria cat : activ.getCategorias()){ //la categoria sabe quienes la tienen
            cat.agregarCuponera(cup);
            cup.getCategorias().add(cat);
        }
    }

    @Override
    public Set<String> getCuponeras() {
        Map<String, Cuponera> cuponeras = getRegistry().getCuponeras();

        Set<String> ret = new HashSet<>();

        for (Cuponera cup : cuponeras.values())
            ret.add(cup.getNombre());

        return ret;
    }

    @Override
    public DataCuponera getDataCuponera(String nombre) throws CuponeraNoEncontradaException {
        Cuponera cup = getRegistry().getCuponeras().get(nombre);

        if (cup == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre:" + nombre);

        return cup.getDataCuponera();
    }

    @Override
    public Set<DataCuponera> cuponerasVigentes(){
        Set<DataCuponera> ret = new HashSet<>();
        Map<String, Cuponera> cuponeras = getRegistry().getCuponeras();
        for (Map.Entry<String, Cuponera> par : cuponeras.entrySet()){
            if (par.getValue().getFin().isAfter(LocalDate.now())){
                ret.add(par.getValue().getDataCuponera());
            }
        }
        return ret;
    }

    @Override
    public void comprarCuponera(String nickname, String nombreCuponera) //ojo, podrias copmrar una cuponera expirada, ese control se hace porque se muestra CuponerasVigentes()
        throws CuponeraYaPoseidaException{

        Socio socio = getRegistry().getSocios().get(nickname);
        Cuponera cuponera = getRegistry().getCuponeras().get(nombreCuponera);
        Set<Compra> comprasSocio = socio.getCompras();

        for (Compra c : comprasSocio){
            if (c.getCuponera().equals(cuponera))
                throw new CuponeraYaPoseidaException("Ya posees la cuponera " + nombreCuponera);
        }
        Compra nuevaCompra = new Compra(LocalDate.now(), socio, cuponera);
        socio.agregarCompra(nuevaCompra);
        if (cuponera.getComprada()==false)
            cuponera.setComprada(true);
    }

    @Override
    public Set<String> getCuponerasSinCompras() {
        Map<String, Cuponera> cuponeras = getRegistry().getCuponeras();

        Set<String> ret = new HashSet<>();

        for (Cuponera cup : cuponeras.values()){
            if (cup.getComprada()==false)
                ret.add(cup.getNombre());
        }

        return ret;
    }

    @Override
    public File getImagenCuponera(String nombre) {
        Cuponera cuponera = getRegistry().getCuponeras().get(nombre);
        return cuponera.getImagen();
    }
}
