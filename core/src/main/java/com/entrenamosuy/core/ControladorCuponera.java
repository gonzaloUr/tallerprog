package com.entrenamosuy.core;

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
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Cuponera;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Integra;
import com.entrenamosuy.core.model.Socio;
import com.entrenamosuy.core.util.Pair;

public class ControladorCuponera implements IControladorCuponera {

    @Override
    public CrearCuponeraChain crearCuponera() {
        return new CrearCuponeraChain() {

            private String nombre;

            private String descripcion;

            private LocalDate inicio;

            private LocalDate fin;

            private int descuento;

            private LocalDate fechaRegistro;

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
            public void invoke() throws CuponeraInconsistenteException {
                Manejador manejador = Manejador.getInstance();
                Map<String, Cuponera> cuponeras = manejador.getCuponeras();

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
                        .build();

                cuponeras.put(nombre, nuevaCup);
            }
        };
    }

    @Override
    public Set<Pair<String, String>> cuponerasUsables(String actividad, String socio) throws ActividadNoEncontradaException, SocioNoEncontradoException {
        // Obtener instancia de manejador.
        Manejador manejador = Manejador.getInstance();

        // Intentar obtener socio, clase y actividad del manejador.
        Socio s = manejador.getSocios().get(socio);
        Actividad a = manejador.getActividades().get(actividad);

        // Si alguno no se encontro tirar excepcion.
        if (s == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        if (a == null)
            throw new ActividadNoEncontradaException("No existe una actividad con nombre: " + actividad);

        // Buscar cuponeras validas de socio s para clase c de actividad a.
        return s.cuponerasUsables(a);
    }

    @Override
    public Set<String> actividadesAgregables(String cuponera, String institucion) throws CuponeraNoEncontradaException, InstitucionNoEncontradaException {
        Manejador maneja = Manejador.getInstance();
        Map<String, Cuponera> cuponeras = maneja.getCuponeras();
        Map<String, Institucion> instituciones = maneja.getInstituciones();
        Cuponera cup = cuponeras.get(cuponera);
        Institucion ins = instituciones.get(institucion);
        if (cup == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre: " + cuponera);
        if (ins == null)
            throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);
        Set<String> res = ins.actividadesAgregables(cup);
        return res;
    }

    public void agregarACuponera(String cuponera, String actividad, int cant) throws ActividadNoEncontradaException, CuponeraNoEncontradaException {
        Manejador m = Manejador.getInstance();
        Cuponera c = m.getCuponeras().get(cuponera);
        Actividad a = m.getActividades().get(actividad);
        if (a == null)
            throw new ActividadNoEncontradaException("No existe una actividad con nombre: " + actividad);
        if (c == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre:" + cuponera);
        Integra integra = new Integra(cant, a);
        Set<Integra> ins = c.getIntegras();
        ins.add(integra);
        c.setIntegras(ins);
    }

    @Override
    public Set<Pair<String, String>> obtenerDescCuponeras() {
        Manejador manejador = Manejador.getInstance();
        Map<String, Cuponera> cuponeras = manejador.getCuponeras();

        Set<Pair<String, String>> ret = new HashSet<>();

        for (Cuponera cup : cuponeras.values())
            ret.add(new Pair<>(cup.getNombre(), cup.getDescripcion()));

        return ret;
    }

    @Override
    public DataCuponera consultarCuponera(String nombre) throws CuponeraNoEncontradaException {
        Manejador manejador = Manejador.getInstance();
        Cuponera c = manejador.getCuponeras().get(nombre);
        if (c == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre:" + nombre);
        return c.getDataCuponera();
    }
}
