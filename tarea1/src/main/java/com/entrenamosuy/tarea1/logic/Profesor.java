package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataClase;
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

    public Profesor(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
                    String descripcion, String biografia, URL sitioWeb, Institucion institucion,
                    Set<Actividad> actividades) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
        this.clasesDictadas = new HashSet<>();
        this.actividades = actividades;
    }

    public Profesor(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
                    String descripcion, String biografia, URL sitioWeb, Institucion institucion) {
        this(nickname, nombre, apellido, correo, nacimiento, descripcion, biografia, sitioWeb, institucion, new HashSet<>());
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

    public DataProfesor getDataProfesor() {
        String institucionNombre = "";
        if (this.getInstitucion() != null) {
            institucionNombre = this.getInstitucion().getNombre();
        }
        Set<DataActividad> actividadesData = new HashSet<>();
        System.out.println("Size actividades en profesor " + getNombre() + ": " + actividades.size());
        for (Actividad a : actividades) {
            actividadesData.add(a.getDataActividad());
        }
        
        System.out.println("Size clases en profesor " + getNombre() + ": " + clasesDictadas.size());
        Set<DataClase> clasesData = new HashSet<>();
        for (Clase c : clasesDictadas) {
            clasesData.add(c.getDataClase());
        }

        return new DataProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.getCorreo(), this.getNacimiento(), actividadesData, clasesData, this.descripcion, this.biografia, this.sitioWeb, institucionNombre);
    }

    public DescProfesor getDescProfesor() {
        return new DescProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.sitioWeb);
    }
}
