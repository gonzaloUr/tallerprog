package com.entrenamosuy.tarea1.view.publicar;

import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.LocalDate;

import com.entrenamosuy.core.data.DataProfesor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanProfesor {

    private String nickname;

    private String nombre;

    private String apellido;

    private BeanEmail correo;

    private LocalDate nacimiento;

    private ArrayList<String> seguidores;

    private ArrayList<String> seguidos;

    private String descripcion;

    private String biografia;

    private URL sitioWeb;

    private String institucion;

    private ArrayList<BeanActividad> actividades;

    private ArrayList<BeanClase> clases;

    private ArrayList<BeanActividad> aceptadas;

    private ArrayList<BeanActividad> sinAceptar;

    public String getNombre() {
		return nombre;
	}

    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(ArrayList<String> seguidos) {
		this.seguidos = seguidos;
	}

	public ArrayList<String> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(ArrayList<String> seguidores) {
		this.seguidores = seguidores;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public BeanEmail getCorreo() {
        return correo;
    }

    public void setCorreo(BeanEmail correo) {
        this.correo = correo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public URL getSitioWeb() {
        return this.sitioWeb;
    }

    public void setSitioWeb(URL sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getInstitucion() {
        return this.institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public ArrayList<BeanActividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(ArrayList<BeanActividad> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<BeanClase> getClases() {
        return this.clases;
    }

    public void setClases(ArrayList<BeanClase> clases) {
        this.clases = clases;
    }

    public ArrayList<BeanActividad> getAceptadas() {
        return this.aceptadas;
    }

    public void setAceptadas(ArrayList<BeanActividad> aceptadas) {
        this.aceptadas = aceptadas;
    }

    public ArrayList<BeanActividad> getSinAceptar() {
        return this.sinAceptar;
    }

    public void setSinAceptar(ArrayList<BeanActividad> sinAceptar) {
        this.sinAceptar = sinAceptar;
    }

    public void from(DataProfesor x) {
        setNickname(x.getNickname());
        setNombre(x.getNombre());
        setApellido(x.getApellido());
        setCorreo(BeanEmail.of(x.getCorreo()));
        setNacimiento(x.getNacimiento());
        setSeguidores(new ArrayList<>(x.getSeguidores()));
        setSeguidos(new ArrayList<>(x.getSeguidos()));
        setDescripcion(x.getDescripcion());
        setBiografia(x.getBiografia());
        setSitioWeb(x.getSitioWeb());
        setInstitucion(x.getInstitucion());
        setActividades(x.getActividades()
            .stream()
            .map(BeanActividad::of)
            .collect(Collectors.toCollection(ArrayList::new)));
        setClases(x.getClases()
            .stream()
            .map(BeanClase::of)
            .collect(Collectors.toCollection(ArrayList::new)));
        setAceptadas(x.getAceptadas()
            .stream()
            .map(BeanActividad::of)
            .collect(Collectors.toCollection(ArrayList::new)));
        setSinAceptar(x.getSinAceptar()
            .stream()
            .map(BeanActividad::of)
            .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static BeanProfesor of(DataProfesor x) {
        BeanProfesor ret = new BeanProfesor();
        ret.from(x);
        return ret;
    }
}