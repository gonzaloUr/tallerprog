package com.entrenamosuy.tarea1.logic;

import java.net.URL;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataUsuario;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.util.Triple;
import exceptions.UsuarioRepetidoException;

public class ControladorUsuario implements IControladorUsuario {

    @Override
    public void crearProfesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            Institucion institucion, String descripcion, String bio, URL link) throws UsuarioRepetidoException {
        Manejador man = Manejador.getInstance();
        Map<String, Profesor> profes = man.getProfesores();
        Map<Email, Profesor> profesE = man.getProfesoresMail();
        Map<String, Socio> socios = man.getSocios();
        Map<Email, Socio> sociosE = man.getSociosMail();
        boolean noExisteN = (profes.get(nickname) == null) && (socios.get(nickname) == null);
        boolean noExisteE = (profesE.get(correo) == null) && (sociosE.get(correo) == null);
        if(noExisteN && noExisteE) {
        	Profesor nuevo = new Profesor(nickname, nombre, apellido, correo, nacimiento,descripcion, bio, link, institucion);
        	profes.put(nickname, nuevo);
        	man.setProfesores(profes);
        	profesE.put(correo, nuevo);
        	man.setProfesoresMail(profesE);
        }
        else if(!noExisteN){
        	throw new UsuarioRepetidoException("Ya existe un ususario con ese nickname.");
        }
        else {
        	throw new UsuarioRepetidoException("Ya existe un usuario con ese correo electronico.");
        }
    }

    @Override
    public void crearSocio(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento) throws UsuarioRepetidoException {
        Manejador man = Manejador.getInstance();
        Map<String, Profesor> profes = man.getProfesores();
        Map<Email, Profesor> profesE = man.getProfesoresMail();
        Map<String, Socio> socios = man.getSocios();
        Map<Email, Socio> sociosE = man.getSociosMail();
        boolean noExisteN = (profes.get(nickname) == null) && (socios.get(nickname) == null);
        boolean noExisteE = (profesE.get(correo) == null) && (sociosE.get(correo) == null);
        if(noExisteN && noExisteE) {
        	Socio nuevo = new Socio(nickname, nombre, apellido, correo, nacimiento);
        	socios.put(nickname, nuevo);
        	man.setSocios(socios);
        	sociosE.put(correo, nuevo);
        	man.setSociosMail(sociosE);
        }
        else if(!noExisteN){
        	throw new UsuarioRepetidoException("Ya existe un ususario con ese nickname.");
        }
        else {
        	throw new UsuarioRepetidoException("Ya existe un usuario con ese correo electronico.");
        }
        
    }

    @Override
    public void modificarDatosUsuario(String nombre, String apellido, LocalDateTime nacimiento) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<Triple<String, String, String>> obtenerDescSocios() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Triple<String, String, String>> obtenerDescProfesores() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataUsuario consultarSocio(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataProfesor consultarProfesor(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }
}