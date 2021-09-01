package com.entrenamosuy.tarea1.logic;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import com.entrenamosuy.tarea1.data.DataSocio;
import com.entrenamosuy.tarea1.data.DataClase;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.util.Pair;

public class Socio extends Usuario {

    private Set<Registro> registros;

    private Set<Compra> compras;

    public Socio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
                 Set<Registro> registros, Set<Compra> compras) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.registros = registros;
        this.compras = compras;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<Registro> registros) {
        this.registros = registros;
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }

    public Set<Pair<String, String>> cuponerasUsables(Actividad a) {
        List<Cuponera> cuponerasADescribir = new ArrayList<>();

        for (Compra compra : compras) {
            Cuponera cup = compra.getCuponera();
            // Obtener el tipo asociativo integra entre cup y a.
            Integra integra = cup.getIntegra(a);
            // Si la cuponera actual no tiene la actividad deseada no continuar.
            if (integra == null)
                continue;
            // Obtener la cantidad de registros que utilizan cup y compararlo con la cantidad de integra.
            int cantRegistros = cantRegistrosConCuponeraA(a, cup);
            int cantClases = integra.getCantClases();
            if (cantRegistros < cantClases)
                cuponerasADescribir.add(cup);
        }
        Set<Pair<String, String>> ret = new HashSet<>(cuponerasADescribir.size());
        for (Cuponera cup : cuponerasADescribir)
            ret.add(new Pair<>(cup.getNombre(), cup.getDescripcion()));
        return ret;
    }

    public int cantRegistrosConCuponeraA(Actividad a, Cuponera cup) {
        int ret = 0;

        for (Registro reg : registros)
            if (reg.getCuponera().equals(cup))
                ret++;

        return ret;
    }

    public DataSocio getDataSocio() {
        Set<Registro> reg = this.getRegistros();
        Iterator<Registro> it = reg.iterator();
        Set<DataClase> claseReg = new HashSet<>();
        while (it.hasNext()) {
            Registro r = it.next();
            Clase c = r.getClaseAsociada();
            DataClase dataClase = c.getDataClase();
            claseReg.add(dataClase);
        }
        DataSocio res = new DataSocio(this.getNickname(), this.getNombre(), this.getApellido(), this.getCorreo(), this.getNacimiento(), claseReg);
        return res;
    }

    public void asociarSocioRegistro(Registro reg) {
        registros.add(reg);
    }
}
