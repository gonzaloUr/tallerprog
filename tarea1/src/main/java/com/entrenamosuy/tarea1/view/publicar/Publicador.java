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
public class Publicador {

    private FacadeContainer facades;
    private Endpoint endpoint = null;

    public Publicador(FacadeContainer facades) {
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

    @WebMethod
    public BeanInstitucion getDataInstitucion(String ins){
        BeanInstitucion institucion = BeanInstitucion.of(facades.getFacadeInstitucion().getDataInstitucion(ins));
        return institucion;
    }

    @WebMethod
    public ArrayList<String> getActividadesDeInstitucion(String institucion){

        return new ArrayList<String>(facades
            .getFacadeActividad()
            .getActividadesDeInstitucion(institucion));
            
    }

     @WebMethod
    public ArrayList<String> getActividadesDeCategoria(String categoria){

        return new ArrayList<String>(facades
            .getFacadeActividad()
            .getActividadesDeCategoria(categoria));
    }

    @WebMethod
    public ArrayList<String> getInstituciones(){
        return new ArrayList<String>(facades
            .getFacadeInstitucion()
            .getInstituciones());
    }

    @WebMethod
    public ArrayList<String> getCategorias(){
        return new ArrayList<String>(facades
            .getFacadeActividad()
            .getCategorias());
    }  

    @WebMethod
    public ArrayList<String> getClasesDeActividad(String actividad){
        return new ArrayList<String>(facades
            .getFacadeClase()
            .getClases(actividad));
    }

    @WebMethod
    public ArrayList<String> getCuponerasUsablesActividad(String act, String nickname){
        return new ArrayList<String>(facades
        .getFacadeCuponera()
        .cuponerasUsables(act, nickname));
    }

    @WebMethod
    public BeanClase getDataClase(String cla){
        BeanClase clase = BeanClase.of(facades.getFacadeClase().getDataClase(cla));
        return clase;
    }

}