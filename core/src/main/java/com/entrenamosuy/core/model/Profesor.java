package com.entrenamosuy.core.model;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DescProfesor;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.data.DataActividad;

public class Profesor extends Usuario {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nickname;

        private String nombre;

        private String apellido;

        private Email correo;

        private LocalDate nacimiento;

        private String password;

        private Set<Usuario> usuariosSeguidos = new HashSet<>();

        private Set<Usuario> seguidores = new HashSet<>();

        private File imagen;

        private String descripcion;

        private String biografia;

        private URL sitioWeb;

        private Institucion institucion;

        private Set<Clase> clasesDictadas = new HashSet<>();

        private Set<Actividad> actividadesRegistradas = new HashSet<>(); //todas las que ingresó

        public Builder setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder setCorreo(Email correo) {
            this.correo = correo;
            return this;
        }

        public Builder setNacimiento(LocalDate nacimiento) {
            this.nacimiento = nacimiento;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUsuariosSeguidos(Set<Usuario> usuariosSeguidos) {
            this.usuariosSeguidos = usuariosSeguidos;
            return this;
        }

        public Builder setSeguidores(Set<Usuario> seguidores) {
            this.seguidores = seguidores;
            return this;
        }

        public Builder setImagen(File imagen) {
            this.imagen = imagen;
            return this;
        }

        public Builder setBiografia(String biografia) {
            this.biografia = biografia;
            return this;
        }

        public Builder setSitioWeb(URL sitioWeb) {
            this.sitioWeb = sitioWeb;
            return this;
        }

        public Builder setInstitucion(Institucion institucion) {
            this.institucion = institucion;
            return this;
        }

        public Builder setClasesDictadas(Set<Clase> clasesDictadas) {
            this.clasesDictadas = clasesDictadas;
            return this;
        }

        public Builder setActividadesRegistradas(Set<Actividad> actividades) {
            this.actividadesRegistradas = actividades;
            return this;
        }

        public Profesor build() {
            return new Profesor(nickname, nombre, apellido, correo, nacimiento, descripcion,
                    password, usuariosSeguidos, seguidores, imagen, biografia, sitioWeb, institucion,
                    clasesDictadas, actividadesRegistradas);
        }
    }

    private String descripcion;

    private String biografia;

    private URL sitioWeb;

    private Institucion institucion;

    private Set<Clase> clasesDictadas;

    private Set<Actividad> actividadesRegistradas;

    protected Profesor(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
                    String descripcion, String password, Set<Usuario> usuariosSeguidos, Set<Usuario> seguidores,
                    File imagen, String biografia, URL sitioWeb, Institucion institucion, Set<Clase> clasesDictadas,
                    Set<Actividad> actividadesRegistradas) {

        super(nickname, nombre, apellido, correo, nacimiento, password, usuariosSeguidos, seguidores, imagen);

        Objects.requireNonNull(descripcion, "descripcion es null en constructor Profesor");
        Objects.requireNonNull(institucion, "institucion es null en constructor Profesor");
        Objects.requireNonNull(clasesDictadas, "clasesDictadas es null en constructor Profesor");
        Objects.requireNonNull(actividadesRegistradas, "actividadesRegistradas es null en constructor Profesor");

        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
        this.clasesDictadas = clasesDictadas;
        this.actividadesRegistradas = actividadesRegistradas;
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

    public void setActividadesRegistradas(Set<Actividad> actividades) {
        this.actividadesRegistradas = actividades;
    }

    public Set<Actividad> getActividadesRegistradas() {
        return actividadesRegistradas;
    }

    public void agregarActividadRegistrada(Actividad activ){
        actividadesRegistradas.add(activ);
    }

    public DataProfesor getDataProfesor() {
        String institucionNombre = this.getInstitucion().getNombre();

        Set<DataActividad> actividadesAsociadas = new HashSet<>();

        for (Clase c : clasesDictadas) {
            DataActividad dataAct = c.getActividad().getDataActividad();
            if (!actividadesAsociadas.contains(dataAct))
                actividadesAsociadas.add(dataAct);
        }

        Set<String> seguidoresString = new HashSet<>();
        Set<String> seguidosString = new HashSet<>();

        for (Usuario u : getSeguidores()){
            seguidoresString.add(u.getNickname());
        }

        for (Usuario u : getUsuariosSeguidos()){ //esta bien dejar el getter flotando?
            seguidosString.add(u.getNickname());
        }

        Set<DataClase> clasesData = new HashSet<>();

        for (Clase c : clasesDictadas) {
            clasesData.add(c.getDataClase());
        }

        Set<DataActividad> actAceptadas = new HashSet<>();
        Set<DataActividad> actSinAceptar = new HashSet<>();

        for (Actividad act : actividadesRegistradas){
            if (act.getEstado()==ActividadEstado.ACEPTADA)
                actAceptadas.add(act.getDataActividad());
            else
                actSinAceptar.add(act.getDataActividad());
        }


        return DataProfesor.builder()
                .setNickname(getNickname())
                .setNombre(getNombre())
                .setApellido(getApellido())
                .setCorreo(getCorreo())
                .setNacimiento(getNacimiento())
                .setSeguidores(seguidoresString)
                .setSeguidos(seguidosString)
                .setActividades(actividadesAsociadas)
                .setClases(clasesData)
                .setInstitucion(institucionNombre)
                .setDescripcion(descripcion)
                .setBiografia(biografia)
                .setSitioWeb(sitioWeb)
                .setAceptadas(actAceptadas)
                .setSinAceptar(actSinAceptar)
                .build();
    }

    public DescProfesor getDescProfesor() {
        return new DescProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.sitioWeb);
    }
}
