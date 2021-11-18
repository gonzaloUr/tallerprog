package com.entrenamosuy.core;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.PasswordInvalidaException;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.model.Socio;
import com.entrenamosuy.core.model.Usuario;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Clase;
import com.entrenamosuy.core.model.Puntaje;

public class FacadeUsuario extends AbstractFacadeUsuario {

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

            private String password;

            private File imagen;

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
            public CrearProfesorChain setSitioWeb(URL link) {
                this.link = link;
                return this;
            }

            @Override
            public CrearProfesorChain setPassword(String password) {
                this.password = password;
                return this;
            }

            @Override
            public CrearProfesorChain setImagen(File imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public void invoke() throws UsuarioRepetidoException {
                // Obtener institucion pasada o tirar exception.
                Institucion inst = getRegistry().getInstituciones().get(institucion);

                if (inst == null)
                    throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);

                // Chequear que no existe usuario con nickname o correo pasado.
                Map<String, Profesor> profs = getRegistry().getProfesores();
                Map<String, Socio> socios = getRegistry().getSocios();
                Map<Email, Profesor> profsEmail = getRegistry().getProfesoresMail();
                Map<Email, Socio> sociosEmail = getRegistry().getSociosMail();

                boolean boolean1 = profs.get(nickname) != null || socios.get(nickname) != null;
                boolean boolean2 = profsEmail.get(correo) != null || sociosEmail.get(correo) != null;

                if (boolean1 || boolean2)
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
                        .setPassword(password)
                        .setImagen(imagen)
                        .build();

                getRegistry().getProfesores().put(nickname, nuevo);
                getRegistry().getProfesoresMail().put(correo, nuevo);
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

            private String password;

            private File imagen;

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
            public CrearSocioChain setPassword(String password) {
                this.password = password;
                return this;
            }

            @Override
            public CrearSocioChain setImagen(File imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public void invoke() throws UsuarioRepetidoException {
                Map<String, Profesor> profes = getRegistry().getProfesores();
                Map<Email, Profesor> profesE = getRegistry().getProfesoresMail();
                Map<String, Socio> socios = getRegistry().getSocios();
                Map<Email, Socio> sociosE = getRegistry().getSociosMail();
                boolean noExisteN = profes.get(nickname) == null && socios.get(nickname) == null;
                boolean noExisteE = profesE.get(correo) == null && sociosE.get(correo) == null;
                if (noExisteN && noExisteE) {
                    Socio nuevo = Socio.builder()
                            .setNickname(nickname)
                            .setNombre(nombre)
                            .setApellido(apellido)
                            .setCorreo(correo)
                            .setNacimiento(nacimiento)
                            .setPassword(password)
                            .setImagen(imagen)
                            .build();

                    socios.put(nickname, nuevo);
                    sociosE.put(correo, nuevo);
                } else if (!noExisteN) {
                    throw new UsuarioRepetidoException("Ya existe un ususuario con ese nickname.");
                } else {
                    throw new UsuarioRepetidoException("Ya existe un usuario con ese correo electronico.");
                }
            }
        };
    }

    @Override
    public ModificarDatosSocioChain modificarDatosSocio() {
        return new ModificarDatosSocioChain() {

            private String nickname;

            private String nombre;

            private String apellido;

            private LocalDate nacimiento;

            private File imagen;

            @Override
            public ModificarDatosSocioChain setNickname(String nickname) {
                this.nickname = nickname;
                return this;
            }

            @Override
            public ModificarDatosSocioChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public ModificarDatosSocioChain setApellido(String apellido) {
                this.apellido = apellido;
                return this;
            }

            @Override
            public ModificarDatosSocioChain setNacimiento(LocalDate nacimiento) {
                this.nacimiento = nacimiento;
                return this;
            }

            @Override
            public ModificarDatosSocioChain setImagen(File imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public void invoke() {
                Socio socio = getRegistry().getSocios().get(nickname);

                if (socio == null)
                    throw new SocioNoEncontradoException("No existe un socio con nickname: " + nickname);

                if (nombre != null)
                    socio.setNombre(nombre);

                if (apellido != null)
                    socio.setApellido(apellido);

                if (nacimiento != null)
                    socio.setNacimiento(nacimiento);

                if (imagen != null)
                    socio.setImagen(imagen);
            }
        };
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

            private File imagen;

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
            public ModificarDatosProfesorChain setImagen(File imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public void invoke() {
                Profesor profesor = getRegistry().getProfesores().get(nickname);

                if (profesor == null)
                    throw new ProfesorNoEncontradoException("No existe un profesor con nickname: " + nickname);

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

                if (imagen != null)
                    profesor.setImagen(imagen);
            }
        };
    }

    @Override
    public Set<String> getSocios() {
        Map<String, Socio> mapa = getRegistry().getSocios();
        Set<String> res = new HashSet<>();

        if (!mapa.isEmpty())
            for (Socio s : mapa.values())
                res.add(s.getNickname());

        return res;
    }

    @Override
    public Set<String> getProfesores() {
        Map<String, Profesor> mapa = getRegistry().getProfesores();
        Set<String> res = new HashSet<>();

        if (!mapa.isEmpty())
            for (Profesor p : mapa.values())
                res.add(p.getNickname());

        return res;
    }

    @Override
    public Set<String> getProfesoresDeInstitucion(String institucion) {

        if (!getRegistry().getInstituciones().containsKey(institucion))
            throw new InstitucionNoEncontradaException("institucion no encontrada");

        return getProfesores()
            .stream()
            .filter((String nickname) -> {
                Profesor profesor = getRegistry().getProfesores().get(nickname);
                String institucionNombreProfesor = profesor.getInstitucion().getNombre();

                return institucionNombreProfesor.equals(institucion);
            })
            .collect(Collectors.toSet());
    }

    @Override
    public DataSocio getDataSocio(String nickname) {
        Map<String, Socio> mapa = getRegistry().getSocios();
        Socio socio = mapa.get(nickname);
        if (socio != null) {
            DataSocio dataSocio = socio.getDataSocio();
            return dataSocio;
        } else
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + nickname);
    }

    @Override
    public DataProfesor getDataProfesor(String nickname) {
        Map<String, Profesor> mapa = getRegistry().getProfesores();
        Profesor profe = mapa.get(nickname);
        if (profe != null) {
            DataProfesor dataProfe = profe.getDataProfesor(); // Implementarlo en la clase Profesor
            return dataProfe;
        } else {
            throw new ProfesorNoEncontradoException("No existe un profesor con nickname: " + nickname);
        }
    }

    @Override
    public void validarCredenciales(String nickname, String password) throws PasswordInvalidaException {
        Map<String, Socio> socios = getRegistry().getSocios();
        Map<String, Profesor> profesores = getRegistry().getProfesores();
        Usuario usuario;

        if (socios.containsKey(nickname))
            usuario = socios.get(nickname);
        else if (profesores.containsKey(nickname))
            usuario = profesores.get(nickname);
        else
            throw new UsuarioNoEncontradoException(nickname);

        if (!usuario.getPassword().equals(password))
            throw new PasswordInvalidaException();
    }

    @Override
    public void validarCredencialesMovil(String nickname, String password) throws PasswordInvalidaException {
        Map<String, Socio> socios = getRegistry().getSocios();
        Usuario usuario;

        if (socios.containsKey(nickname))
            usuario = socios.get(nickname);
        else
            throw new SocioNoEncontradoException(nickname);

        if (!usuario.getPassword().equals(password))
            throw new PasswordInvalidaException();
    }

    @Override
    public void seguirUsuario(String seguido, String seguidor) {
        Map<String, Socio> socios = getRegistry().getSocios();
        Map<String, Profesor> profes = getRegistry().getProfesores();

        Usuario usuarioSeguido;
        Usuario usuarioSeguidor;

        if (socios.containsKey(seguido))
            usuarioSeguido = socios.get(seguido);
        else if (profes.containsKey(seguido))
            usuarioSeguido = profes.get(seguido);
        else
            throw new UsuarioNoEncontradoException("No existe un usuario de nickname " + seguido);

        if (socios.containsKey(seguidor))
            usuarioSeguidor = socios.get(seguidor);
        else if (profes.containsKey(seguidor))
            usuarioSeguidor = profes.get(seguidor);
        else
            throw new UsuarioNoEncontradoException("No existe un usuario de nickname " + seguidor);

        usuarioSeguidor.seguirUsuario(usuarioSeguido);
    }

    @Override
    public void dejarDeSeguirUsuario(String seguido, String seguidor) {
        Map<String, Socio> socios = getRegistry().getSocios();
        Map<String, Profesor> profes = getRegistry().getProfesores();

        Usuario usuarioSeguido;
        Usuario usuarioSeguidor;

        if (socios.containsKey(seguido))
            usuarioSeguido = socios.get(seguido);
        else if (profes.containsKey(seguido))
            usuarioSeguido = profes.get(seguido);
        else
            throw new UsuarioNoEncontradoException("No existe un usuario de nickname " + seguido);

        if (socios.containsKey(seguidor))
            usuarioSeguidor = socios.get(seguidor);
        else if (profes.containsKey(seguidor))
            usuarioSeguidor = profes.get(seguidor);
        else
            throw new UsuarioNoEncontradoException("No existe un usuario de nickname " + seguidor);

        usuarioSeguidor.dejarDeSeguirUsuario(usuarioSeguido);
    }

    @Override
    public File getImagenUsuario(String nickname) {
        Map<String, Socio> socios = getRegistry().getSocios();
        Map<String, Profesor> profes = getRegistry().getProfesores();

        Usuario usuario;

        if (socios.containsKey(nickname))
            usuario = socios.get(nickname);
        else if (profes.containsKey(nickname))
            usuario = profes.get(nickname);
        else
            throw new UsuarioNoEncontradoException(nickname);

        return usuario.getImagen();
    }
    
    
    @Override
    public void puntuarClase(String socio, String clase, int puntaje) {
    	Map<String, Clase> mapaC = getRegistry().getClases();
    	Map<String, Socio> mapa = getRegistry().getSocios();
    	Socio s = mapa.get(socio);
    	Clase c = mapaC.get(clase);
    	Puntaje p = new Puntaje(s, c, puntaje);
    	s.agregarPuntaje(p);
    	c.agregarPuntaje(p);
    }
    
    @Override
    public void marcarComoFav(String socio, String actividad) {
    	Map<String, Socio> mapa = getRegistry().getSocios();
    	Socio s = mapa.get(socio);
    	Map<String, Actividad> mapaA = getRegistry().getActividades();
    	Actividad a = mapaA.get(actividad);
    	s.agregarFav(a);
    }
    
    @Override
    public void desmarcarComoFav(String socio, String actividad) {
    	Map<String, Socio> mapa = getRegistry().getSocios();
    	Socio s = mapa.get(socio);
    	s.eliminarFavorita(actividad);
    }

    @Override
    public void agregarPremioASocio(String socio, String clase){
        Socio sochi = getRegistry().getSocios().get(socio);
        Clase clachi = getRegistry().getClases().get(clase);
        sochi.agregarPremio(clachi);
    }
    
    @Override
    public boolean esFav(String socio, String actividad){
        Map<String, Socio> mapa = getRegistry().getSocios();
    	Socio s = mapa.get(socio);
        return s.getActividadesFavoritas().containsKey(actividad);
    }
}
