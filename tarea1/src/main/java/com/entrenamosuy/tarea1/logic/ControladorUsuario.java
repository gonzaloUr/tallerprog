package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataUsuario;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.util.Triple;



public void registrarUsuario(String n, String ap, String ci) throws UsuarioRepetidoException {
    ManejadorUsuario mu = ManejadorUsuario.getinstance();
    Usuario u = mu.obtenerUsuario(ci);
    if (u != null)
        throw new UsuarioRepetidoException("El usuario " + ci + " ya esta registrado");

    u = new Usuario(n, ap, ci);
    mu.addUsuario(u);
}









public class ControladorUsuario implements IControladorUsuario {

    @Override
    public void crearProfesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            String institucion, String descripcion, String bio, URL link) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void crearSocio(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento) {
        // TODO Auto-generated method stub
        
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
            Set<Triple<String, String, String>> res;
            it = mapa.entrySet().iterator();
            while(it.hasNext()) {
                Socio s = it.next();
                Triple<String, String, String> trip = new Triple<String, String, String>(s.nombre, s.nickname, s.apellido);
                res.add(trip);
            }
            return res;
        }
        else  
            throw new SociosVacioException("No hay socios en el sistema");
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