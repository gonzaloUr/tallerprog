package com.entrenamosuy.tarea1.logic;

import java.net.URL;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataUsuario;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.util.Triple;
import exceptions.UsuarioRepetidoException;
import exceptions.SociosVacioException;
import exceptions.SocioNoExisteException;
import exceptions.ProfesoresVacioException;
import exceptions.ProfesorNoExisteException;


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
    public Set<Triple<String, String, String>> obtenerDescSocios() throws SociosVacioException {
        Manejador man = Manejador.getInstance();
        Map<String, Socio> mapa = man.getSocios();
        if (mapa != null) {
            Set<Triple<String, String, String>> res = Collections.emptySet();
            Iterator<Entry<String, Socio>> it = mapa.entrySet().iterator();
            while(it.hasNext()) {
                Socio s = (Socio) it.next();
                Triple<String, String, String> trip = new Triple<String, String, String>(s.getNombre(), s.getNickname(), s.getApellido());
                res.add(trip);
            }
            return res;
        }
        else  
            throw new SociosVacioException("No hay socios en el sistema");
    }

    @Override
    public Set<Triple<String, String, String>> obtenerDescProfesores() throws ProfesoresVacioException {
        Manejador man = Manejador.getInstance();
        Map<String, Profesor> mapa = man.getProfesores();
        if (mapa != null) {
            Set<Triple<String, String, String>> res = Collections.emptySet();
            Iterator<Entry<String, Profesor>> it = mapa.entrySet().iterator();
            while(it.hasNext()) {
                Profesor p = (Profesor) it.next();
                Triple<String, String, String> trip = new Triple<String, String, String>(p.getNombre(), p.getNickname(), p.getApellido());
                res.add(trip);
            }
            return res;
        }
        else  
            throw new ProfesoresVacioException("No hay profesores en el sistema");
    }

    @Override
    public DataUsuario consultarSocio(String nickname) throws SocioNoExisteException{
        Manejador man = Manejador.getInstance();
        Map<String, Socio> mapa = man.getSocios();
        Socio p = mapa.get(nickname);
        if (p != null) {
            DataUsuario r = p.getDataUsuario(); //Implementarlo en la clase Usuario/Socio
            return r;
        }
        else
            throw new SocioNoExisteException("No existe un socio con ese nickname en el sistema");
    }

    @Override
    public DataProfesor consultarProfesor(String nickname) throws ProfesorNoExisteException{
        Manejador man = Manejador.getInstance();
        Map<String, Profesor> mapa = man.getProfesores();
        Profesor p = mapa.get(nickname);
        if (p != null) {
            DataProfesor r = p.getDataProfesor(); //Implementarlo en la clase Profesor
            return r;
        }
        else
            throw new ProfesorNoExisteException("No existe un profesor con ese nickname en el sistema");

    }
}