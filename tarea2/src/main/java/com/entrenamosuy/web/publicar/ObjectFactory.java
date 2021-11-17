
package com.entrenamosuy.web.publicar;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.entrenamosuy.web.publicar package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDataClase_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataClase");
    private final static QName _GetCategorias_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getCategorias");
    private final static QName _GetCategoriasResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getCategoriasResponse");
    private final static QName _GetInstituciones_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getInstituciones");
    private final static QName _GetProfesores_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getProfesores");
    private final static QName _DejarDeSeguirUsuario_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "dejarDeSeguirUsuario");
    private final static QName _GetDataSocioResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataSocioResponse");
    private final static QName _GetCuponerasUsablesActividad_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getCuponerasUsablesActividad");
    private final static QName _GetDataActividad_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataActividad");
    private final static QName _GetSociosResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getSociosResponse");
    private final static QName _GetDataActividadResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataActividadResponse");
    private final static QName _GetDataInstitucionResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataInstitucionResponse");
    private final static QName _GetActividadesDeCategoriaResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getActividadesDeCategoriaResponse");
    private final static QName _GetSocios_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getSocios");
    private final static QName _ListarActividadesAceptadasResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "listarActividadesAceptadasResponse");
    private final static QName _GetInstitucionesResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getInstitucionesResponse");
    private final static QName _GetActividadesDeInstitucionResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getActividadesDeInstitucionResponse");
    private final static QName _GetActividadesDeCategoria_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getActividadesDeCategoria");
    private final static QName _GetCuponerasUsablesActividadResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getCuponerasUsablesActividadResponse");
    private final static QName _DejarDeSeguirUsuarioResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "dejarDeSeguirUsuarioResponse");
    private final static QName _GetDataInstitucion_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataInstitucion");
    private final static QName _GetDataSocio_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataSocio");
    private final static QName _GetDataClaseResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataClaseResponse");
    private final static QName _SeguirUsuarioResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "seguirUsuarioResponse");
    private final static QName _GetActividadesDeInstitucion_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getActividadesDeInstitucion");
    private final static QName _GetProfesoresResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getProfesoresResponse");
    private final static QName _GetClasesDeActividad_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getClasesDeActividad");
    private final static QName _SeguirUsuario_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "seguirUsuario");
    private final static QName _ListarActividadesAceptadas_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "listarActividadesAceptadas");
    private final static QName _GetClasesDeActividadResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getClasesDeActividadResponse");
    private final static QName _GetDataProfesorResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataProfesorResponse");
    private final static QName _GetDataProfesor_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataProfesor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.entrenamosuy.web.publicar
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDataActividadResponse }
     * 
     */
    public GetDataActividadResponse createGetDataActividadResponse() {
        return new GetDataActividadResponse();
    }

    /**
     * Create an instance of {@link GetDataInstitucionResponse }
     * 
     */
    public GetDataInstitucionResponse createGetDataInstitucionResponse() {
        return new GetDataInstitucionResponse();
    }

    /**
     * Create an instance of {@link GetActividadesDeCategoriaResponse }
     * 
     */
    public GetActividadesDeCategoriaResponse createGetActividadesDeCategoriaResponse() {
        return new GetActividadesDeCategoriaResponse();
    }

    /**
     * Create an instance of {@link GetSocios }
     * 
     */
    public GetSocios createGetSocios() {
        return new GetSocios();
    }

    /**
     * Create an instance of {@link ListarActividadesAceptadasResponse }
     * 
     */
    public ListarActividadesAceptadasResponse createListarActividadesAceptadasResponse() {
        return new ListarActividadesAceptadasResponse();
    }

    /**
     * Create an instance of {@link GetCuponerasUsablesActividad }
     * 
     */
    public GetCuponerasUsablesActividad createGetCuponerasUsablesActividad() {
        return new GetCuponerasUsablesActividad();
    }

    /**
     * Create an instance of {@link GetDataActividad }
     * 
     */
    public GetDataActividad createGetDataActividad() {
        return new GetDataActividad();
    }

    /**
     * Create an instance of {@link GetSociosResponse }
     * 
     */
    public GetSociosResponse createGetSociosResponse() {
        return new GetSociosResponse();
    }

    /**
     * Create an instance of {@link GetCategorias }
     * 
     */
    public GetCategorias createGetCategorias() {
        return new GetCategorias();
    }

    /**
     * Create an instance of {@link GetCategoriasResponse }
     * 
     */
    public GetCategoriasResponse createGetCategoriasResponse() {
        return new GetCategoriasResponse();
    }

    /**
     * Create an instance of {@link GetInstituciones }
     * 
     */
    public GetInstituciones createGetInstituciones() {
        return new GetInstituciones();
    }

    /**
     * Create an instance of {@link GetProfesores }
     * 
     */
    public GetProfesores createGetProfesores() {
        return new GetProfesores();
    }

    /**
     * Create an instance of {@link DejarDeSeguirUsuario }
     * 
     */
    public DejarDeSeguirUsuario createDejarDeSeguirUsuario() {
        return new DejarDeSeguirUsuario();
    }

    /**
     * Create an instance of {@link GetDataSocioResponse }
     * 
     */
    public GetDataSocioResponse createGetDataSocioResponse() {
        return new GetDataSocioResponse();
    }

    /**
     * Create an instance of {@link GetDataClase }
     * 
     */
    public GetDataClase createGetDataClase() {
        return new GetDataClase();
    }

    /**
     * Create an instance of {@link GetClasesDeActividadResponse }
     * 
     */
    public GetClasesDeActividadResponse createGetClasesDeActividadResponse() {
        return new GetClasesDeActividadResponse();
    }

    /**
     * Create an instance of {@link GetDataProfesorResponse }
     * 
     */
    public GetDataProfesorResponse createGetDataProfesorResponse() {
        return new GetDataProfesorResponse();
    }

    /**
     * Create an instance of {@link GetDataProfesor }
     * 
     */
    public GetDataProfesor createGetDataProfesor() {
        return new GetDataProfesor();
    }

    /**
     * Create an instance of {@link SeguirUsuarioResponse }
     * 
     */
    public SeguirUsuarioResponse createSeguirUsuarioResponse() {
        return new SeguirUsuarioResponse();
    }

    /**
     * Create an instance of {@link GetActividadesDeInstitucion }
     * 
     */
    public GetActividadesDeInstitucion createGetActividadesDeInstitucion() {
        return new GetActividadesDeInstitucion();
    }

    /**
     * Create an instance of {@link GetProfesoresResponse }
     * 
     */
    public GetProfesoresResponse createGetProfesoresResponse() {
        return new GetProfesoresResponse();
    }

    /**
     * Create an instance of {@link GetClasesDeActividad }
     * 
     */
    public GetClasesDeActividad createGetClasesDeActividad() {
        return new GetClasesDeActividad();
    }

    /**
     * Create an instance of {@link SeguirUsuario }
     * 
     */
    public SeguirUsuario createSeguirUsuario() {
        return new SeguirUsuario();
    }

    /**
     * Create an instance of {@link ListarActividadesAceptadas }
     * 
     */
    public ListarActividadesAceptadas createListarActividadesAceptadas() {
        return new ListarActividadesAceptadas();
    }

    /**
     * Create an instance of {@link DejarDeSeguirUsuarioResponse }
     * 
     */
    public DejarDeSeguirUsuarioResponse createDejarDeSeguirUsuarioResponse() {
        return new DejarDeSeguirUsuarioResponse();
    }

    /**
     * Create an instance of {@link GetDataInstitucion }
     * 
     */
    public GetDataInstitucion createGetDataInstitucion() {
        return new GetDataInstitucion();
    }

    /**
     * Create an instance of {@link GetDataSocio }
     * 
     */
    public GetDataSocio createGetDataSocio() {
        return new GetDataSocio();
    }

    /**
     * Create an instance of {@link GetDataClaseResponse }
     * 
     */
    public GetDataClaseResponse createGetDataClaseResponse() {
        return new GetDataClaseResponse();
    }

    /**
     * Create an instance of {@link GetInstitucionesResponse }
     * 
     */
    public GetInstitucionesResponse createGetInstitucionesResponse() {
        return new GetInstitucionesResponse();
    }

    /**
     * Create an instance of {@link GetActividadesDeInstitucionResponse }
     * 
     */
    public GetActividadesDeInstitucionResponse createGetActividadesDeInstitucionResponse() {
        return new GetActividadesDeInstitucionResponse();
    }

    /**
     * Create an instance of {@link GetActividadesDeCategoria }
     * 
     */
    public GetActividadesDeCategoria createGetActividadesDeCategoria() {
        return new GetActividadesDeCategoria();
    }

    /**
     * Create an instance of {@link GetCuponerasUsablesActividadResponse }
     * 
     */
    public GetCuponerasUsablesActividadResponse createGetCuponerasUsablesActividadResponse() {
        return new GetCuponerasUsablesActividadResponse();
    }

    /**
     * Create an instance of {@link BeanClase }
     * 
     */
    public BeanClase createBeanClase() {
        return new BeanClase();
    }

    /**
     * Create an instance of {@link Duration }
     * 
     */
    public Duration createDuration() {
        return new Duration();
    }

    /**
     * Create an instance of {@link BeanDescProfesor }
     * 
     */
    public BeanDescProfesor createBeanDescProfesor() {
        return new BeanDescProfesor();
    }

    /**
     * Create an instance of {@link BeanInstitucion }
     * 
     */
    public BeanInstitucion createBeanInstitucion() {
        return new BeanInstitucion();
    }

    /**
     * Create an instance of {@link BeanSocio }
     * 
     */
    public BeanSocio createBeanSocio() {
        return new BeanSocio();
    }

    /**
     * Create an instance of {@link BeanLocalDateTime }
     * 
     */
    public BeanLocalDateTime createBeanLocalDateTime() {
        return new BeanLocalDateTime();
    }

    /**
     * Create an instance of {@link BeanLocalDate }
     * 
     */
    public BeanLocalDate createBeanLocalDate() {
        return new BeanLocalDate();
    }

    /**
     * Create an instance of {@link BeanProfesor }
     * 
     */
    public BeanProfesor createBeanProfesor() {
        return new BeanProfesor();
    }

    /**
     * Create an instance of {@link BeanCuponera }
     * 
     */
    public BeanCuponera createBeanCuponera() {
        return new BeanCuponera();
    }

    /**
     * Create an instance of {@link BeanDescActividad }
     * 
     */
    public BeanDescActividad createBeanDescActividad() {
        return new BeanDescActividad();
    }

    /**
     * Create an instance of {@link BeanActividad }
     * 
     */
    public BeanActividad createBeanActividad() {
        return new BeanActividad();
    }

    /**
     * Create an instance of {@link BeanEmail }
     * 
     */
    public BeanEmail createBeanEmail() {
        return new BeanEmail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataClase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataClase")
    public JAXBElement<GetDataClase> createGetDataClase(GetDataClase value) {
        return new JAXBElement<GetDataClase>(_GetDataClase_QNAME, GetDataClase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategorias }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getCategorias")
    public JAXBElement<GetCategorias> createGetCategorias(GetCategorias value) {
        return new JAXBElement<GetCategorias>(_GetCategorias_QNAME, GetCategorias.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoriasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getCategoriasResponse")
    public JAXBElement<GetCategoriasResponse> createGetCategoriasResponse(GetCategoriasResponse value) {
        return new JAXBElement<GetCategoriasResponse>(_GetCategoriasResponse_QNAME, GetCategoriasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstituciones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getInstituciones")
    public JAXBElement<GetInstituciones> createGetInstituciones(GetInstituciones value) {
        return new JAXBElement<GetInstituciones>(_GetInstituciones_QNAME, GetInstituciones.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfesores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getProfesores")
    public JAXBElement<GetProfesores> createGetProfesores(GetProfesores value) {
        return new JAXBElement<GetProfesores>(_GetProfesores_QNAME, GetProfesores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DejarDeSeguirUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "dejarDeSeguirUsuario")
    public JAXBElement<DejarDeSeguirUsuario> createDejarDeSeguirUsuario(DejarDeSeguirUsuario value) {
        return new JAXBElement<DejarDeSeguirUsuario>(_DejarDeSeguirUsuario_QNAME, DejarDeSeguirUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataSocioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataSocioResponse")
    public JAXBElement<GetDataSocioResponse> createGetDataSocioResponse(GetDataSocioResponse value) {
        return new JAXBElement<GetDataSocioResponse>(_GetDataSocioResponse_QNAME, GetDataSocioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCuponerasUsablesActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getCuponerasUsablesActividad")
    public JAXBElement<GetCuponerasUsablesActividad> createGetCuponerasUsablesActividad(GetCuponerasUsablesActividad value) {
        return new JAXBElement<GetCuponerasUsablesActividad>(_GetCuponerasUsablesActividad_QNAME, GetCuponerasUsablesActividad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataActividad")
    public JAXBElement<GetDataActividad> createGetDataActividad(GetDataActividad value) {
        return new JAXBElement<GetDataActividad>(_GetDataActividad_QNAME, GetDataActividad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSociosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getSociosResponse")
    public JAXBElement<GetSociosResponse> createGetSociosResponse(GetSociosResponse value) {
        return new JAXBElement<GetSociosResponse>(_GetSociosResponse_QNAME, GetSociosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataActividadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataActividadResponse")
    public JAXBElement<GetDataActividadResponse> createGetDataActividadResponse(GetDataActividadResponse value) {
        return new JAXBElement<GetDataActividadResponse>(_GetDataActividadResponse_QNAME, GetDataActividadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataInstitucionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataInstitucionResponse")
    public JAXBElement<GetDataInstitucionResponse> createGetDataInstitucionResponse(GetDataInstitucionResponse value) {
        return new JAXBElement<GetDataInstitucionResponse>(_GetDataInstitucionResponse_QNAME, GetDataInstitucionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActividadesDeCategoriaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getActividadesDeCategoriaResponse")
    public JAXBElement<GetActividadesDeCategoriaResponse> createGetActividadesDeCategoriaResponse(GetActividadesDeCategoriaResponse value) {
        return new JAXBElement<GetActividadesDeCategoriaResponse>(_GetActividadesDeCategoriaResponse_QNAME, GetActividadesDeCategoriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSocios }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getSocios")
    public JAXBElement<GetSocios> createGetSocios(GetSocios value) {
        return new JAXBElement<GetSocios>(_GetSocios_QNAME, GetSocios.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividadesAceptadasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "listarActividadesAceptadasResponse")
    public JAXBElement<ListarActividadesAceptadasResponse> createListarActividadesAceptadasResponse(ListarActividadesAceptadasResponse value) {
        return new JAXBElement<ListarActividadesAceptadasResponse>(_ListarActividadesAceptadasResponse_QNAME, ListarActividadesAceptadasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstitucionesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getInstitucionesResponse")
    public JAXBElement<GetInstitucionesResponse> createGetInstitucionesResponse(GetInstitucionesResponse value) {
        return new JAXBElement<GetInstitucionesResponse>(_GetInstitucionesResponse_QNAME, GetInstitucionesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActividadesDeInstitucionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getActividadesDeInstitucionResponse")
    public JAXBElement<GetActividadesDeInstitucionResponse> createGetActividadesDeInstitucionResponse(GetActividadesDeInstitucionResponse value) {
        return new JAXBElement<GetActividadesDeInstitucionResponse>(_GetActividadesDeInstitucionResponse_QNAME, GetActividadesDeInstitucionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActividadesDeCategoria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getActividadesDeCategoria")
    public JAXBElement<GetActividadesDeCategoria> createGetActividadesDeCategoria(GetActividadesDeCategoria value) {
        return new JAXBElement<GetActividadesDeCategoria>(_GetActividadesDeCategoria_QNAME, GetActividadesDeCategoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCuponerasUsablesActividadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getCuponerasUsablesActividadResponse")
    public JAXBElement<GetCuponerasUsablesActividadResponse> createGetCuponerasUsablesActividadResponse(GetCuponerasUsablesActividadResponse value) {
        return new JAXBElement<GetCuponerasUsablesActividadResponse>(_GetCuponerasUsablesActividadResponse_QNAME, GetCuponerasUsablesActividadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DejarDeSeguirUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "dejarDeSeguirUsuarioResponse")
    public JAXBElement<DejarDeSeguirUsuarioResponse> createDejarDeSeguirUsuarioResponse(DejarDeSeguirUsuarioResponse value) {
        return new JAXBElement<DejarDeSeguirUsuarioResponse>(_DejarDeSeguirUsuarioResponse_QNAME, DejarDeSeguirUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataInstitucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataInstitucion")
    public JAXBElement<GetDataInstitucion> createGetDataInstitucion(GetDataInstitucion value) {
        return new JAXBElement<GetDataInstitucion>(_GetDataInstitucion_QNAME, GetDataInstitucion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataSocio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataSocio")
    public JAXBElement<GetDataSocio> createGetDataSocio(GetDataSocio value) {
        return new JAXBElement<GetDataSocio>(_GetDataSocio_QNAME, GetDataSocio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataClaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataClaseResponse")
    public JAXBElement<GetDataClaseResponse> createGetDataClaseResponse(GetDataClaseResponse value) {
        return new JAXBElement<GetDataClaseResponse>(_GetDataClaseResponse_QNAME, GetDataClaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeguirUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "seguirUsuarioResponse")
    public JAXBElement<SeguirUsuarioResponse> createSeguirUsuarioResponse(SeguirUsuarioResponse value) {
        return new JAXBElement<SeguirUsuarioResponse>(_SeguirUsuarioResponse_QNAME, SeguirUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActividadesDeInstitucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getActividadesDeInstitucion")
    public JAXBElement<GetActividadesDeInstitucion> createGetActividadesDeInstitucion(GetActividadesDeInstitucion value) {
        return new JAXBElement<GetActividadesDeInstitucion>(_GetActividadesDeInstitucion_QNAME, GetActividadesDeInstitucion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfesoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getProfesoresResponse")
    public JAXBElement<GetProfesoresResponse> createGetProfesoresResponse(GetProfesoresResponse value) {
        return new JAXBElement<GetProfesoresResponse>(_GetProfesoresResponse_QNAME, GetProfesoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClasesDeActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getClasesDeActividad")
    public JAXBElement<GetClasesDeActividad> createGetClasesDeActividad(GetClasesDeActividad value) {
        return new JAXBElement<GetClasesDeActividad>(_GetClasesDeActividad_QNAME, GetClasesDeActividad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeguirUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "seguirUsuario")
    public JAXBElement<SeguirUsuario> createSeguirUsuario(SeguirUsuario value) {
        return new JAXBElement<SeguirUsuario>(_SeguirUsuario_QNAME, SeguirUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividadesAceptadas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "listarActividadesAceptadas")
    public JAXBElement<ListarActividadesAceptadas> createListarActividadesAceptadas(ListarActividadesAceptadas value) {
        return new JAXBElement<ListarActividadesAceptadas>(_ListarActividadesAceptadas_QNAME, ListarActividadesAceptadas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClasesDeActividadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getClasesDeActividadResponse")
    public JAXBElement<GetClasesDeActividadResponse> createGetClasesDeActividadResponse(GetClasesDeActividadResponse value) {
        return new JAXBElement<GetClasesDeActividadResponse>(_GetClasesDeActividadResponse_QNAME, GetClasesDeActividadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataProfesorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataProfesorResponse")
    public JAXBElement<GetDataProfesorResponse> createGetDataProfesorResponse(GetDataProfesorResponse value) {
        return new JAXBElement<GetDataProfesorResponse>(_GetDataProfesorResponse_QNAME, GetDataProfesorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataProfesor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "getDataProfesor")
    public JAXBElement<GetDataProfesor> createGetDataProfesor(GetDataProfesor value) {
        return new JAXBElement<GetDataProfesor>(_GetDataProfesor_QNAME, GetDataProfesor.class, null, value);
    }

}
