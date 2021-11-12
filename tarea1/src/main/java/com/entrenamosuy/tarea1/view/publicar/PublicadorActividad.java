package com.entrenamosuy.tarea1.view.publicar;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.ws.Endpoint;

import java.util.stream.Collectors;
import java.util.ArrayList;

import com.entrenamosuy.core.util.FacadeContainer;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
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
    public ArrayList<BeanActividad> listarActividadesAceptadas(){
        return facades
            .getFacadeActividad()
            .listarActividadesAceptadas()
            .stream()
            .map(BeanActividad::of)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    @WebMethod
    public BeanActividad getDataActividad(String act){
        BeanActividad actividad = BeanActividad.of(facades.getFacadeActividad().getDataActividad(act));
        return actividad;
    }
}