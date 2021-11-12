package com.entrenamosuy.core.data;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class DataProfesor extends DataUsuario {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nickname;

        private String nombre;

        private String apellido;

        private Email correo;

        private LocalDate nacimiento;

        private Set<String> seguidores = Collections.emptySet();

        private Set<String> seguidos = Collections.emptySet();

        private String descripcion;

        private String biografia;

        private URL sitioWeb;

        private String institucion;

        private Set<DataActividad> actividades = Collections.emptySet();

        private Set<DataClase> clases = Collections.emptySet();

        private Set<DataActividad> aceptadas = Collections.emptySet();

        private Set<DataActividad> sinAceptar = Collections.emptySet();

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

        public Builder setSeguidores(Set<String> seguidores) {
            this.seguidores = seguidores;
            return this;
        }

        public Builder setSeguidos(Set<String> seguidos) {
            this.seguidos = seguidos;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
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

        public Builder setInstitucion(String institucion) {
            this.institucion = institucion;
            return this;
        }

        public Builder setActividades(Set<DataActividad> actividades) {
            this.actividades = actividades;
            return this;
        }

        public Builder setClases(Set<DataClase> clases) {
            this.clases = clases;
            return this;
        }

        public Builder setAceptadas(Set<DataActividad> aceptadas) {
            this.aceptadas = aceptadas;
            return this;
        }

        public Builder setSinAceptar(Set<DataActividad> sinAceptar) {
            this.sinAceptar = sinAceptar;
            return this;
        }

        public DataProfesor build() {
            return new DataProfesor(nickname, nombre, apellido, correo, nacimiento,
                    institucion, actividades, clases, descripcion, biografia, sitioWeb, seguidores, seguidos, aceptadas, sinAceptar);
        }
    }

    private final String descripcion;

    private final String biografia;

    private final URL sitioWeb;

    private final String institucion;

    private final Set<DataActividad> actividades;

    private final Set<DataClase> clases;

    private final Set<DataActividad> aceptadas;

    private final Set<DataActividad> sinAceptar;


    protected DataProfesor(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
            String institucion, Set<DataActividad> actividades, Set<DataClase> clases, String descripcion,
            String biografia, URL sitioWeb, Set<String> seguidores, Set<String> seguidos, Set<DataActividad> aceptadas, Set<DataActividad> sinAceptar) {

        super(nickname, nombre, apellido, correo, nacimiento, seguidores, seguidos);

        Objects.requireNonNull(institucion, "institucion es null en constructor DataProfesor");
        Objects.requireNonNull(actividades, "actividades es null en constructor DataProfesor");
        Objects.requireNonNull(clases, "clases es null en constructor DataProfesor");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor DataProfesor");
        Objects.requireNonNull(aceptadas, "aceptadas es null en constructor DataProfesor");
        Objects.requireNonNull(sinAceptar, "sinAceptar es null en constructor DataProfesor");


        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
        this.actividades = actividades;
        this.clases = clases;
        this.aceptadas = aceptadas;
        this.sinAceptar = sinAceptar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getBiografia() {
        return biografia;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    public Set<DataClase> getClases() {
        return clases;
    }

    public Set<DataActividad> getActividades() {
        return actividades;
    }

    public Set<DataActividad> getAceptadas() {
        return aceptadas;
    }

    public Set<DataActividad> getSinAceptar() {
        return sinAceptar;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(biografia, descripcion, institucion, sitioWeb);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj) || getClass() != obj.getClass())
            return false;
        DataProfesor other = (DataProfesor) obj;
        return Objects.equals(biografia, other.biografia)
            && Objects.equals(descripcion, other.descripcion)
            && Objects.equals(institucion, other.institucion)
            && Objects.equals(sitioWeb, other.sitioWeb);
    }
}
