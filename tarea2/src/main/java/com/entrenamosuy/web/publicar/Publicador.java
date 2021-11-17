
package com.entrenamosuy.web.publicar;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Publicador", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Publicador {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCategorias", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetCategorias")
    @ResponseWrapper(localName = "getCategoriasResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetCategoriasResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getCategoriasRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getCategoriasResponse")
    public List<String> getCategorias();

    /**
     * 
     * @param arg0
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "crearSocio", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.CrearSocio")
    @ResponseWrapper(localName = "crearSocioResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.CrearSocioResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearSocioRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearSocioResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearSocio/Fault/UsuarioRepetidoException")
    })
    public void crearSocio(
        @WebParam(name = "arg0", targetNamespace = "")
        BeanCrearSocioArgs arg0)
        throws UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInstituciones", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetInstituciones")
    @ResponseWrapper(localName = "getInstitucionesResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetInstitucionesResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getInstitucionesRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getInstitucionesResponse")
    public List<String> getInstituciones();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getActividadesDeInstitucion", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetActividadesDeInstitucion")
    @ResponseWrapper(localName = "getActividadesDeInstitucionResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetActividadesDeInstitucionResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getActividadesDeInstitucionRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getActividadesDeInstitucionResponse")
    public List<String> getActividadesDeInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSocios", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetSocios")
    @ResponseWrapper(localName = "getSociosResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetSociosResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getSociosRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getSociosResponse")
    public List<String> getSocios();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.entrenamosuy.web.publicar.BeanSocio
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDataSocio", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataSocio")
    @ResponseWrapper(localName = "getDataSocioResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataSocioResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataSocioRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataSocioResponse")
    public BeanSocio getDataSocio(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProfesores", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetProfesores")
    @ResponseWrapper(localName = "getProfesoresResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetProfesoresResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getProfesoresRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getProfesoresResponse")
    public List<String> getProfesores();

    /**
     * 
     * @param arg0
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "crearProfesor", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.CrearProfesor")
    @ResponseWrapper(localName = "crearProfesorResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.CrearProfesorResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearProfesorRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearProfesorResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearProfesor/Fault/UsuarioRepetidoException")
    })
    public void crearProfesor(
        @WebParam(name = "arg0", targetNamespace = "")
        BeanCrearProfesorArgs arg0)
        throws UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.entrenamosuy.web.publicar.BeanClase
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDataClase", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataClase")
    @ResponseWrapper(localName = "getDataClaseResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataClaseResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataClaseRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataClaseResponse")
    public BeanClase getDataClase(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.entrenamosuy.web.publicar.BeanActividad
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDataActividad", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataActividad")
    @ResponseWrapper(localName = "getDataActividadResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataActividadResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataActividadRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataActividadResponse")
    public BeanActividad getDataActividad(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.entrenamosuy.web.publicar.BeanProfesor
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDataProfesor", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataProfesor")
    @ResponseWrapper(localName = "getDataProfesorResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataProfesorResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataProfesorRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataProfesorResponse")
    public BeanProfesor getDataProfesor(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getActividadesDeCategoria", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetActividadesDeCategoria")
    @ResponseWrapper(localName = "getActividadesDeCategoriaResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetActividadesDeCategoriaResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getActividadesDeCategoriaRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getActividadesDeCategoriaResponse")
    public List<String> getActividadesDeCategoria(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @throws ActividadRepetidaException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "crearActividad", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.CrearActividad")
    @ResponseWrapper(localName = "crearActividadResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.CrearActividadResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearActividadRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearActividadResponse", fault = {
        @FaultAction(className = ActividadRepetidaException_Exception.class, value = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/crearActividad/Fault/ActividadRepetidaException")
    })
    public void crearActividad(
        @WebParam(name = "arg0", targetNamespace = "")
        BeanCrearActividadArgs arg0)
        throws ActividadRepetidaException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.entrenamosuy.web.publicar.BeanActividad>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarActividadesAceptadas", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.ListarActividadesAceptadas")
    @ResponseWrapper(localName = "listarActividadesAceptadasResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.ListarActividadesAceptadasResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/listarActividadesAceptadasRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/listarActividadesAceptadasResponse")
    public List<BeanActividad> listarActividadesAceptadas();

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImagenActividad", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenActividad")
    @ResponseWrapper(localName = "getImagenActividadResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenActividadResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenActividadRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenActividadResponse")
    public byte[] getImagenActividad(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImagenUsuario", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenUsuario")
    @ResponseWrapper(localName = "getImagenUsuarioResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenUsuarioResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenUsuarioRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenUsuarioResponse")
    public byte[] getImagenUsuario(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "seguirUsuario", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.SeguirUsuario")
    @ResponseWrapper(localName = "seguirUsuarioResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.SeguirUsuarioResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/seguirUsuarioRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/seguirUsuarioResponse")
    public void seguirUsuario(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.entrenamosuy.web.publicar.BeanInstitucion
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDataInstitucion", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataInstitucion")
    @ResponseWrapper(localName = "getDataInstitucionResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetDataInstitucionResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataInstitucionRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getDataInstitucionResponse")
    public BeanInstitucion getDataInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImagenCuponera", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenCuponera")
    @ResponseWrapper(localName = "getImagenCuponeraResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenCuponeraResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenCuponeraRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenCuponeraResponse")
    public byte[] getImagenCuponera(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImagenInstitucion", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenInstitucion")
    @ResponseWrapper(localName = "getImagenInstitucionResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenInstitucionResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenInstitucionRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenInstitucionResponse")
    public byte[] getImagenInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws PasswordInvalidaException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "validarCredenciales", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.ValidarCredenciales")
    @ResponseWrapper(localName = "validarCredencialesResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.ValidarCredencialesResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/validarCredencialesRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/validarCredencialesResponse", fault = {
        @FaultAction(className = PasswordInvalidaException_Exception.class, value = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/validarCredenciales/Fault/PasswordInvalidaException")
    })
    public void validarCredenciales(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws PasswordInvalidaException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "dejarDeSeguirUsuario", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.DejarDeSeguirUsuario")
    @ResponseWrapper(localName = "dejarDeSeguirUsuarioResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.DejarDeSeguirUsuarioResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/dejarDeSeguirUsuarioRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/dejarDeSeguirUsuarioResponse")
    public void dejarDeSeguirUsuario(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImagenClase", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenClase")
    @ResponseWrapper(localName = "getImagenClaseResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetImagenClaseResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenClaseRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getImagenClaseResponse")
    public byte[] getImagenClase(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getClasesDeActividad", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetClasesDeActividad")
    @ResponseWrapper(localName = "getClasesDeActividadResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetClasesDeActividadResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getClasesDeActividadRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getClasesDeActividadResponse")
    public List<String> getClasesDeActividad(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCuponerasUsablesActividad", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetCuponerasUsablesActividad")
    @ResponseWrapper(localName = "getCuponerasUsablesActividadResponse", targetNamespace = "http://publicar.view.tarea1.entrenamosuy.com/", className = "com.entrenamosuy.web.publicar.GetCuponerasUsablesActividadResponse")
    @Action(input = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getCuponerasUsablesActividadRequest", output = "http://publicar.view.tarea1.entrenamosuy.com/Publicador/getCuponerasUsablesActividadResponse")
    public List<String> getCuponerasUsablesActividad(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
