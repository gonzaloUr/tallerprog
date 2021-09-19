package com.entrenamosuy.core.data;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class DataSocio extends DataUsuario {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nickname;

        private String nombre;

        private String apellido;

        private Email correo;

        private LocalDate nacimiento;

        private Set<String> seguidores;
        
        private Set<String> seguidos;

        private Set<DataClase> clases = Collections.emptySet();

        private Set<DataCuponera> cuponeras = Collections.emptySet();

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

        public Builder setClases(Set<DataClase> clases) {
            this.clases = clases;
            return this;
        }

        public Builder setCuponeras(Set<DataCuponera> cuponeras) {
            this.cuponeras = cuponeras;
            return this;
        }

        public DataSocio build() {
            return new DataSocio(nickname, nombre, apellido, correo, nacimiento, seguidores, seguidos, clases, cuponeras);
        }
    }

    private final Set<DataClase> clases;
    private final Set<DataCuponera> cuponeras;

    protected DataSocio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento, Set<String> seguidores, 
        Set<String> seguidos, Set<DataClase> clases, Set<DataCuponera> cuponeras) {

        super(nickname, nombre, apellido, correo, nacimiento, seguidores, seguidos);
        this.clases = clases;
        this.cuponeras = cuponeras;
    }

    public Set<DataClase> getClases() {
        return clases;
    }

    public Set<DataCuponera> getCuponeras() {
        return cuponeras;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj) || getClass() != obj.getClass())
            return false;
        DataSocio other = (DataSocio) obj;
        return Objects.equals(clases, other.clases);
    }
}
