package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;


import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataSocio;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.util.Triple;

public class ControladorUsuario implements IControladorUsuario {

    @Override
    public void crearProfesor(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
                              String institucion, String descripcion, String bio, URL link) throws UsuarioRepetidoException, InstitucionNoEncontradaException {
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
        Profesor nuevo = new Profesor(nickname, nombre, apellido, correo, nacimiento, descripcion, bio, link, inst);
        manejador.getProfesores().put(nickname, nuevo);
        manejador.getProfesoresMail().put(correo, nuevo);
    }

    @Override
    public void crearSocio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento) throws UsuarioRepetidoException {
        Manejador man = Manejador.getInstance();
        Map<String, Profesor> profes = man.getProfesores();
        Map<Email, Profesor> profesE = man.getProfesoresMail();
        Map<String, Socio> socios = man.getSocios();
        Map<Email, Socio> sociosE = man.getSociosMail();
        boolean noExisteN = (profes.get(nickname) == null) && (socios.get(nickname) == null);
        boolean noExisteE = (profesE.get(correo) == null) && (sociosE.get(correo) == null);
        if (noExisteN && noExisteE) {
            Socio nuevo = new Socio(nickname, nombre, apellido, correo, nacimiento, new HashSet<>(), new HashSet<>());//modificado para que tenga sentido con la clase Socio
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

    @Override
    public void modificarDatosUsuario(String nickname, String nombre, String apellido, LocalDate nacimiento) throws UsuarioNoEncontradoException {
        Manejador manejador = Manejador.getInstance();
        Usuario usuario;

        Profesor profesor = manejador.getProfesores().get(nickname);

        if (profesor == null) {
            Socio socio = manejador.getSocios().get(nickname);

            if (socio == null) {
                throw new UsuarioNoEncontradoException("No existe un usuario con nickname: " + nickname);
            } else {
                usuario = socio;
            }
        } else {
            usuario = profesor;
        }

        if (nombre != null)
            usuario.setNombre(nombre);

        if (apellido != null)
            usuario.setApellido(apellido);

        if (nacimiento != null)
            usuario.setNacimiento(nacimiento);
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