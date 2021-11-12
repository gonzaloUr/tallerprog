
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

    private final static QName _GetDataActividad_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataActividad");
    private final static QName _ListarActividadesAceptadas_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "listarActividadesAceptadas");
    private final static QName _GetDataActividadResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "getDataActividadResponse");
    private final static QName _ListarActividadesAceptadasResponse_QNAME = new QName("http://publicar.view.tarea1.entrenamosuy.com/", "listarActividadesAceptadasResponse");

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
     * Create an instance of {@link ListarActividadesAceptadasResponse }
     * 
     */
    public ListarActividadesAceptadasResponse createListarActividadesAceptadasResponse() {
        return new ListarActividadesAceptadasResponse();
    }

    /**
     * Create an instance of {@link GetDataActividad }
     * 
     */
    public GetDataActividad createGetDataActividad() {
        return new GetDataActividad();
    }

    /**
     * Create an instance of {@link ListarActividadesAceptadas }
     * 
     */
    public ListarActividadesAceptadas createListarActividadesAceptadas() {
        return new ListarActividadesAceptadas();
    }

    /**
     * Create an instance of {@link Duration }
     * 
     */
    public Duration createDuration() {
        return new Duration();
    }

    /**
     * Create an instance of {@link LocalDateTime }
     * 
     */
    public LocalDateTime createLocalDateTime() {
        return new LocalDateTime();
    }

    /**
     * Create an instance of {@link BeanDescActividad }
     * 
     */
    public BeanDescActividad createBeanDescActividad() {
        return new BeanDescActividad();
    }

    /**
     * Create an instance of {@link BeanDescProfesor }
     * 
     */
    public BeanDescProfesor createBeanDescProfesor() {
        return new BeanDescProfesor();
    }

    /**
     * Create an instance of {@link BeanActividad }
     * 
     */
    public BeanActividad createBeanActividad() {
        return new BeanActividad();
    }

    /**
     * Create an instance of {@link BeanClase }
     * 
     */
    public BeanClase createBeanClase() {
        return new BeanClase();
    }

    /**
     * Create an instance of {@link BeanCuponera }
     * 
     */
    public BeanCuponera createBeanCuponera() {
        return new BeanCuponera();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividadesAceptadas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "listarActividadesAceptadas")
    public JAXBElement<ListarActividadesAceptadas> createListarActividadesAceptadas(ListarActividadesAceptadas value) {
        return new JAXBElement<ListarActividadesAceptadas>(_ListarActividadesAceptadas_QNAME, ListarActividadesAceptadas.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividadesAceptadasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://publicar.view.tarea1.entrenamosuy.com/", name = "listarActividadesAceptadasResponse")
    public JAXBElement<ListarActividadesAceptadasResponse> createListarActividadesAceptadasResponse(ListarActividadesAceptadasResponse value) {
        return new JAXBElement<ListarActividadesAceptadasResponse>(_ListarActividadesAceptadasResponse_QNAME, ListarActividadesAceptadasResponse.class, null, value);
    }

}
