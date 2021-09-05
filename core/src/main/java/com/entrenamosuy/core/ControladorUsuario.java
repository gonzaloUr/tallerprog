package com.entrenamosuy.core;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.model.Socio;
import com.entrenamosuy.core.util.Triple;

public class ControladorUsuario implements IControladorUsuario {

    @Override
    public CrearProfesorChain crearProfesor() {
        return new CrearProfesorChain() {

            private String nickname;

            private String nombre;

            private String apellido;

            private Email correo;

            private LocalDate nacimiento;

            private String institucion;

            private String descripcion;

            private String bio;

            private URL link;

            @Override
            public CrearProfesorChain setNickname(String nickname) {
                this.nickname = nickname;
                return this;
            }

            @Override
            public CrearProfesorChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public CrearProfesorChain setApellido(String apellido) {
                this.apellido = apellido;
                return this;
            }

            @Override
            public CrearProfesorChain setCorreo(Email correo) {
                this.correo = correo;
                return this;
            }

            @Override
            public CrearProfesorChain setNacimiento(LocalDate nacimiento) {
                this.nacimiento = nacimiento;
                return this;
            }

            @Override
            public CrearProfesorChain setInstitucion(String institucion) {
                this.institucion = institucion;
                return this;
            }

            @Override
            public CrearProfesorChain setDescripcion(String descripcion) {
                this.descripcion = descripcion;
                return this;
            }

            @Override
            public CrearProfesorChain setBiografia(String bio) {
                this.bio = bio;
                return this;
            }

            @Override
            public CrearProfesorChain setLink(URL link) {
                this.link = link;
                return this;
            }

            @Override
            public void invoke() throws UsuarioRepetidoException, InstitucionNoEncontradaException {
                Manejador manejador = Manejador.getInstance();

                // Obtener institucion pasada o tirar exception.
                Institucion inst = manejador.getInstituciones().get(institucion);

                if (inst == null)
                    throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);

                // Chequear que no existe usuario con nickname o correo pasado.
                Map<String, Profesor> profs = manejador.getProfesores();
                Map<String, Socio> socios = manejador.getSocios();
                Map<Email, Profesor> profsEmail = manejador.getProfesoresMail();
                Map<Email, Socio> sociosEmail = manejador.getSociosMail();

                boolean b1 = profs.get(nickname) != null || socios.get(nickname) != null;
                boolean b2 = profsEmail.get(correo) != null || sociosEmail.get(correo) != null;

                if (b1 || b2)
                    throw new UsuarioRepetidoException("No existe un usuario con nickname: " + nickname);

                // Crear un nuevo profesor con los datos pasados.
                Profesor nuevo = Profesor.builder()
                        .setNickname(nickname)
                        .setNombre(nombre)
                        .setApellido(apellido)
                        .setCorreo(correo)
                        .setNacimiento(nacimiento)
                        .setDescripcion(descripcion)
                        .setBiografia(bio)
                        .setSitioWeb(link)
                        .setInstitucion(inst)
                        .build();

                manejador.getProfesores().put(nickname, nuevo);
                manejador.getProfesoresMail().put(correo, nuevo);
            }
        };
    }

    @Override
    public CrearSocioChain crearSocio() {
         return new CrearSocioChain() {

             private String nickname;

             private String nombre;

             private String apellido;

             private Email correo;

             private LocalDate nacimiento;

             @Override
             public CrearSocioChain setNickname(String nickname) {
                 this.nickname = nickname;
                 return this;
             }

             @Override
             public CrearSocioChain setNombre(String nombre) {
                 this.nombre = nombre;
                 return this;
             }

             @Override
             public CrearSocioChain setApellido(String apellido) {
                 this.apellido = apellido;
                 return this;
             }

             @Override
             public CrearSocioChain setCorreo(Email correo) {
                 this.correo = correo;
                 return this;
             }

             @Override
             public CrearSocioChain setNacimiento(LocalDate nacimiento) {
                 this.nacimiento = nacimiento;
                 return this;
             }

             @Override
             public void invoke() throws UsuarioRepetidoException {
                 Manejador man = Manejador.getInstance();
                 Map<String, Profesor> profes = man.getProfesores();
                 Map<Email, Profesor> profesE = man.getProfesoresMail();
                 Map<String, Socio> socios = man.getSocios();
                 Map<Email, Socio> sociosE = man.getSociosMail();
                 boolean noExisteN = (profes.get(nickname) == null) && (socios.get(nickname) == null);
                 boolean noExisteE = (profesE.get(correo) == null) && (sociosE.get(correo) == null);
                 if (noExisteN && noExisteE) {
                     Socio nuevo = Socio.builder()
                             .setNickname(nickname)
                             .setNombre(nombre)
                             .setApellido(apellido)
                             .setCorreo(correo)
                             .setNacimiento(nacimiento)
                             .build();
                     socios.put(nickname, nuevo);
                     man.setSocios(socios);
                     sociosE.put(correo, nuevo);
                     man.setSociosMail(sociosE);
                 } else if (!noExisteN) {
                     throw new UsuarioRepetidoException("Ya existe un ususario con ese nickname.");
                 } else {
                     throw new UsuarioRepetidoException("Ya existe un usuario con ese correo electronico.");
                 }
             }
         };
    }

    @Override
    public void modificarDatosSocio(String nickname, String nombre, String apellido, LocalDate nacimiento) throws SocioNoEncontradoException {
        Manejador manejador = Manejador.getInstance();
        Socio socio = manejador.getSocios().get(nickname);;

        if (socio == null) {
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + nickname);
        }

        if (nombre != null)
            socio.setNombre(nombre);

        if (apellido != null)
            socio.setApellido(apellido);

        if (nacimiento != null)
            socio.setNacimiento(nacimiento);
    }

    @Override
    public ModificarDatosProfesorChain modificarDatosProfesor() {
        return new ModificarDatosProfesorChain() {

            private String nickname;

            private String nombre;

            private String apellido;

            private LocalDate nacimiento;

            private String descripcion;

            private String biografia;

            private URL sitioWeb;

            @Override
            public ModificarDatosProfesorChain setNickname(String nickname) {
                this.nickname = nickname;
                return this;
            }

            @Override
            public ModificarDatosProfesorChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public ModificarDatosProfesorChain setApellido(String apellido) {
                this.apellido = apellido;
                return this;
            }

            @Override
            public ModificarDatosProfesorChain setNacimiento(LocalDate nacimiento) {
                this.nacimiento = nacimiento;
                return this;
            }

            @Override
            public ModificarDatosProfesorChain setDescripcion(String descripcion) {
                this.descripcion = descripcion;
                return this;
            }

            @Override
            public ModificarDatosProfesorChain setBiografia(String biografia) {
                this.biografia = biografia;
                return this;
            }

            @Override
            public ModificarDatosProfesorChain setSitioWeb(URL sitioWeb) {
                this.sitioWeb = sitioWeb;
                return this;
            }

            @Override
            public void invoke() throws ProfesorNoEncontradoException {
                Manejador manejador = Manejador.getInstance();
                Profesor profesor = manejador.getProfesores().get(nickname);;

                if (profesor == null) {
                    throw new ProfesorNoEncontradoException("No existe un profesor con nickname: " + nickname);
                }

                if (nombre != null)
                    profesor.setNombre(nombre);

                if (apellido != null)
                    profesor.setApellido(apellido);

                if (nacimiento != null)
                    profesor.setNacimiento(nacimiento);

                if (descripcion != null)
                    profesor.setDescripcion(descripcion);

                if (biografia != null)
                    profesor.setBiografia(biografia);

                if (sitioWeb != null)
                    profesor.setSitioWeb(sitioWeb);
            }
        };
    }

    @Override
    public Set<Triple<String, String, String>> obtenerDescSocios() {
        Manejador man = Manejador.getInstance();
        Map<String, Socio> mapa = man.getSocios();
        Set<Triple<String, String, String>> res = new HashSet<>();

        if (!mapa.isEmpty()) {
            for (Socio s : mapa.values()) {
                Triple<String, String, String> trip = new Triple<String, String, String>(s.getNombre(), s.getNickname(), s.getApellido());
                res.add(trip);
            }
        }

        return res;
    }

    @Override
    public Set<Triple<String, String, String>> obtenerDescProfesores() {
        Manejador man = Manejador.getInstance();
        Map<String, Profesor> mapa = man.getProfesores();
        Set<Triple<String, String, String>> res = new HashSet<>();

        if (!mapa.isEmpty()) {
            for (Profesor p : mapa.values()) {
                Triple<String, String, String> trip = new Triple<String, String, String>(p.getNombre(), p.getNickname(), p.getApellido());
                res.add(trip);
            }
        }

        return res;
    }

    @Override
    public Set<Triple<String, String, String>> obtenerDescProfesoresDe(String institucion)
            throws InstitucionNoEncontradaException {

        Manejador manejador = Manejador.getInstance();

        if (!manejador.getInstituciones().containsKey(institucion))
            throw new InstitucionNoEncontradaException("institucion no encontrada");

        Set<Triple<String, String, String>> profesores = obtenerDescProfesores();
        Set<Triple<String, String, String>> ret = new HashSet<>();

        for (Triple<String, String, String> profesor : profesores) {
            String nickname = profesor.getSecond();
            String nom = manejador.getProfesores().get(nickname).getInstitucion().getNombre();
            if (nom.equals(institucion))
                ret.add(profesor);
        }

        return ret;
    }

    @Override
    public DataSocio consultarSocio(String nickname) throws SocioNoEncontradoException {
        Manejador man = Manejador.getInstance();
        Map<String, Socio> mapa = man.getSocios();
        Socio p = mapa.get(nickname);
        if (p != null) {
            DataSocio r = p.getDataSocio();
            return r;
        } else
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + nickname);
    }

    @Override
    public DataProfesor consultarProfesor(String nickname) throws ProfesorNoEncontradoException {
        Manejador man = Manejador.getInstance();
        Map<String, Profesor> mapa = man.getProfesores();
        Profesor p = mapa.get(nickname);
        if (p != null) {
            DataProfesor r = p.getDataProfesor(); //Implementarlo en la clase Profesor
            return r;
        } else {
            throw new ProfesorNoEncontradoException("No existe un profesor con nickname: " + nickname);
        }

    }
}
