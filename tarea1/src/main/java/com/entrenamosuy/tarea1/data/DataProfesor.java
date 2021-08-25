package com.entrenamosuy.tarea1.data;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class DataProfesor extends DataUsuario {

    private final String descripcion;

    private final String biografia;

    private final URL sitioWeb;

    private final Set<DataActividad> actividades;

    private final String institucionNombre;

    public DataProfesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            Set<DataActividad> actividades, String descripcion, String biografia, URL sitioWeb, String institucionNombre) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.actividades = actividades;
        this.institucionNombre = institucionNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getInstitucionNombre() {
        return institucionNombre;
    }
    
    public String getBiografia() {
        return biografia;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    public Set<DataActividad> getActividades() {
        return actividades;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(actividades, biografia, descripcion, sitioWeb, institucionNombre);
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
        DataProfesor other = (DataProfesor) obj;
        return Objects.equals(actividades, other.actividades) && Objects.equals(biografia, other.biografia)
                && Objects.equals(descripcion, other.descripcion) && Objects.equals(sitioWeb, other.sitioWeb);
    }
}
