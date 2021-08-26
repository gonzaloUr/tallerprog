package com.entrenamosuy.tarea1.data;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
//import com.entrenamosuy.tarea1.logic.Clase;

public class DataSocio extends DataUsuario {
 
    private final Set<DataClase> clases;

    public DataSocio(String nickname, String nombre, String apellido, Email correo, LocalDate LocalDate,
            Set<DataClase> claseReg) {
        super(nickname, nombre, apellido, correo, LocalDate);
        this.clases = claseReg;
    }

/*    public DataSocio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
			Set<Clase> claseReg) {
	}*/

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
