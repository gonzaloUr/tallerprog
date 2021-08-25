package com.entrenamosuy.tarea1.logic;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataSocio;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.util.Pair;

public class Socio extends Usuario {

    private Set<Registro> registros;

    private Set<Compra> compras;

    public Socio(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            Set<Registro> registros, Set<Compra> compras) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.registros = registros;
        this.compras = compras;
    }

    public Socio(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento) {
        this(nickname, nombre, apellido, correo, nacimiento, Collections.emptySet(), Collections.emptySet());
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(compras, registros);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Socio other = (Socio) obj;
        return Objects.equals(compras, other.compras) && Objects.equals(registros, other.registros);
    }

    public Set<Pair<String, String>> cuponerasValidas(Clase c, Actividad a) {
        return null;
    }

    public DataSocio getDataSocio() {
        return null;
    }
}
