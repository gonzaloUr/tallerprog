package com.entrenamosuy.tarea1.view.publicar;

import java.util.ArrayList;

import java.util.stream.Collectors;
import com.entrenamosuy.core.data.DataSocio;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanSocio {

    private String nickname;

    private String nombre;

    private String apellido;

    private BeanEmail correo;

    private BeanLocalDate nacimiento;

    private ArrayList<String> seguidores;

    private ArrayList<String> seguidos;

    private ArrayList<BeanClase> clases;

    private ArrayList<BeanCuponera> cuponeras;

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

	public BeanLocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(BeanLocalDate nacimiento) {
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

    public ArrayList<BeanClase> getClases() {
        return this.clases;
    }

    public void setClases(ArrayList<BeanClase> clases) {
        this.clases = clases;
    }

    public ArrayList<BeanCuponera> getCuponeras() {
        return this.cuponeras;
    }

    public void setCuponeras(ArrayList<BeanCuponera> cuponeras) {
        this.cuponeras = cuponeras;
    }

    public void from(DataSocio x) {
        setNickname(x.getNickname());
        setNombre(x.getNombre());
        setApellido(x.getApellido());
        setCorreo(BeanEmail.of(x.getCorreo()));
        setNacimiento(BeanLocalDate.of(x.getNacimiento()));
        setSeguidores(new ArrayList<>(x.getSeguidores()));
        setSeguidos(new ArrayList<>(x.getSeguidores()));
        setClases(x.getClases()
            .stream()
            .map(BeanClase::of)
            .collect(Collectors.toCollection(ArrayList::new)));
        setCuponeras(x.getCuponeras()
            .stream()
            .map(BeanCuponera::of)
            .collect(Collectors.toCollection(ArrayList::new)));;
    }

    public static BeanSocio of(DataSocio x) {
        BeanSocio ret = new BeanSocio();
        ret.from(x);
        return ret;
    }
}
