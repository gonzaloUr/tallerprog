package com.entrenamosuy.tarea1.view.publicar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.entrenamosuy.core.data.MiniUsuario;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanMiniUsuario {

    private String nombre;

    private boolean esSocio;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEsSocio() {
        return this.esSocio;
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }

    public void from(MiniUsuario x) {
        setNombre(x.getNombre());
        setEsSocio(x.getEsSocio());
    }

    public static BeanMiniUsuario of(MiniUsuario x) {
        BeanMiniUsuario ret = new BeanMiniUsuario();
        ret.from(x);
        return ret;
    }
}