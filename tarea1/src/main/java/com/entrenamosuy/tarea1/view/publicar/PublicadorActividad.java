package com.entrenamosuy.tarea1.view.publicar;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import com.entrenamosuy.core.Fabrica;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataUsuario;
import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.SinCategoriaException;
import com.entrenamosuy.core.util.FacadeContainer;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorActividad {

    private FacadeContainer facades;
    private Endpoint endpoint = null;

    public PublicadorActividad(FacadeContainer facades) {
        this.facades = facades;
    }

    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:9128/webservices", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint(){
        return endpoint;
    }

    @WebMethod
    public ArrayList<DataActividad> listarActividadesAceptadas(){
        Set<DataActividad> acts = facades
            .getFacadeActividad()
            .listarActividadesAceptadas();
        
        ArrayList<DataActividad> res = new ArrayList<>(acts);
        return res;
    }

    @WebMethod
    public DataActividad getDataActividad(String act){
        DataActividad actividad = facades.getFacadeActividad().getDataActividad(act);
        return actividad;
    }
}
