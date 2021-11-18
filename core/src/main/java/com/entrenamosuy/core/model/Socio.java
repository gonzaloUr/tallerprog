package com.entrenamosuy.core.model;

import java.io.File;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.Email;

public class Socio extends Usuario {

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

        private Set<Registro> registros = new HashSet<>();

        private Set<Compra> compras = new HashSet<>();

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

        public Builder setRegistros(Set<Registro> registros) {
            this.registros = registros;
            return this;
        }

        public Builder setCompras(Set<Compra> compras) {
            this.compras = compras;
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

        public Socio build() {
            return new Socio(nickname, nombre, apellido, correo, nacimiento, registros, compras,
            		password, usuariosSeguidos, seguidores, imagen);
        }
    }

    private Set<Registro> registros;

    private Set<Compra> compras;

    private Map<String, Actividad> actividadesFavoritas;

    private Set<Puntaje> puntajes;

    private List<Clase> clasesGanadas;

    protected Socio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
                 Set<Registro> registros, Set<Compra> compras , String password,
                 Set<Usuario> usuariosSeguidos, Set<Usuario> seguidores, File imagen) {

        super(nickname, nombre, apellido, correo, nacimiento, password, usuariosSeguidos, seguidores, imagen);

        Objects.requireNonNull(registros, "registros es null en constructor Socio");
        Objects.requireNonNull(compras, "compras es null en constructor Socio");

        this.registros = registros;
        this.compras = compras;
        clasesGanadas = new ArrayList<Clase>();
        puntajes = new HashSet<Puntaje>();
        actividadesFavoritas = new HashMap<String, Actividad>();
    }

    public List<Clase> getClasesGanadas() {
        return clasesGanadas;
    }

    public void setClasesGanadas(List<Clase> clasesGanadas) {
        this.clasesGanadas = clasesGanadas;
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

    public static Builder builder() {
        return new Builder();
    }

    public Map<String, Actividad> getActividadesFavoritas() {
        return actividadesFavoritas;
    }

    public void setActividadesFavoritas(Map<String, Actividad> actividadesFavoritas) {
        this.actividadesFavoritas = actividadesFavoritas;
    }

    public Set<Puntaje> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(Set<Puntaje> puntajes) {
        this.puntajes = puntajes;
    }

    public void agregarCompra(Compra compra){
        compras.add(compra);
    }

    public Set<String> cuponerasUsables(Actividad activ) {
        Set<String> ret = new HashSet<>();

        for (Compra compra : compras) {
            Cuponera cup = compra.getCuponera();
            // Obtener el tipo asociativo integra entre cup y a.
            Integra integra = cup.getIntegra(activ);
            // Si la cuponera actual no tiene la actividad deseada no continuar.
            if (integra == null)
                continue;
            // Obtener la cantidad de registros que utilizan cup y compararlo con la cantidad de integra.
            int cantRegistros = cantRegistrosConCuponeraA(activ, cup);
            int cantClases = integra.getCantClases();
            if (cantRegistros < cantClases)
                ret.add(cup.getNombre());
        }

        return ret;
    }

    public int cantRegistrosConCuponeraA(Actividad activ, Cuponera cup) {
        int ret = 0;

        for (Registro reg : registros) {
            if (reg.getCuponera() == null)
                continue;

            Clase claseRegistro = reg.getClaseAsociada();

            if (reg.getCuponera().equals(cup) && activ.getClases().contains(claseRegistro))
                ret++;
        }

        return ret;
    }

    public DataSocio getDataSocio() {
        Set<Registro> registros = getRegistros();
        Set<DataClase> dataClases = new HashSet<>(registros.size());
        Set<Compra> compras = getCompras();
        Set<DataCuponera> dataCuponeras = new HashSet<>(compras.size());
        Set<String> seguidoresString = new HashSet<>();
        Set<String> seguidosString = new HashSet<>();

        for (Usuario u : getSeguidores()){
            seguidoresString.add(u.getNickname());
        }

        for (Usuario u : getUsuariosSeguidos()){ //esta bien dejar el getter flotando?
            seguidosString.add(u.getNickname());
        }

        for (Registro r : getRegistros()) {
            Clase clase = r.getClaseAsociada();
            dataClases.add(clase.getDataClase());
        }
        for (Compra comp : getCompras()){
            Cuponera cup = comp.getCuponera();
            dataCuponeras.add(cup.getDataCuponera());
        }

        return DataSocio.builder()
            .setNickname(getNickname())
            .setNombre(getNombre())
            .setApellido(getApellido())
            .setCorreo(getCorreo())
            .setNacimiento(getNacimiento())
            .setSeguidores(seguidoresString)
            .setSeguidos(seguidosString)
            .setClases(dataClases)
            .setCuponeras(dataCuponeras)
            .setFavoritas(actividadesFavoritas)
            .build();
    }

    public void asociarSocioRegistro(Registro reg) {
        registros.add(reg);
    }
    
    public void agregarPremio(Clase clase) {
    	clasesGanadas.add(0, clase);
    }
    
    public void agregarPuntaje(Puntaje p) {
    	puntajes.add(p);
    }
    
    public void agregarFav(Actividad a) {
    	actividadesFavoritas.put(a.getNombre(), a);
    }
    
    public void eliminarFavorita(String a) {
    	actividadesFavoritas.remove(a);
    }
}
