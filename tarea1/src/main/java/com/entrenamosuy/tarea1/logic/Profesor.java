package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DescProfesor;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.data.DataActividad;

public class Profesor extends Usuario {

    private String descripcion;

    private String biografia;

    private URL sitioWeb;

    private Institucion institucion;

    private Set<Clase> clasesDictadas;

    private Set<Actividad> actividades;

    public Profesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            String descripcion, String biografia, URL sitioWeb, Institucion institucion, 
            Set<Actividad> actividades) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
        this.clasesDictadas = Collections.emptySet();
        this.actividades = actividades;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(URL sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Set<Clase> getClasesDictadas() {
        return clasesDictadas;
    }

    public void setClasesDictadas(Set<Clase> clasesDictadas) {
        this.clasesDictadas = clasesDictadas;
    }

    public void setActividad(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Set<Actividad> getActividad() {
        return actividades;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(biografia, clasesDictadas, descripcion, institucion, sitioWeb, actividades);
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
        Profesor other = (Profesor) obj;
        return Objects.equals(biografia, other.biografia) && Objects.equals(clasesDictadas, other.clasesDictadas)
                && Objects.equals(descripcion, other.descripcion) && Objects.equals(institucion, other.institucion)
                && Objects.equals(sitioWeb, other.sitioWeb);
    }

    public DataProfesor getDataProfesor() {
        String institucionNombre = this.getInstitucion().getNombre();
        Set<DataActividad> actividades = new HashSet<>();
        Set<Actividad> acti = this.getActividad();
        Iterator<Actividad> it = acti.iterator();
        while(it.hasNext()) {
            Actividad a = it.next();
            DataActividad dataA = a.getDataActividad(); // TODO DataActividad en actividad
            actividades.add(dataA);
        }     
        DataProfesor res = new DataProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.getCorreo(), this.getNacimiento(), actividades, this.descripcion, this.biografia, this.sitioWeb, institucionNombre);
        return res;
    }

    public DescProfesor getDescProfesor() {
        DescProfesor res = new DescProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.sitioWeb);
        return res; 
    }
}
