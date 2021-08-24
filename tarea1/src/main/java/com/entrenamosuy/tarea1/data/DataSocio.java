package com.entrenamosuy.tarea1.data;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class DataSocio extends DataUsuario {
 
    private final Set<DataClase> clases;

    public DataSocio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
            Set<DataClase> clases) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.clases = clases;
    }

    public Set<DataClase> getClases() {
        return clases;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(clases);
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
        DataSocio other = (DataSocio) obj;
        return Objects.equals(clases, other.clases);
    }
}
