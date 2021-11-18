
package com.entrenamosuy.web.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para beanClase complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="beanClase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inicio" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanLocalDateTime" minOccurs="0"/>
 *         &lt;element name="cantMin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantMax" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accesoURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="actividad" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanDescActividad" minOccurs="0"/>
 *         &lt;element name="profesores" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanDescProfesor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanClase", propOrder = {
    "nombre",
    "inicio",
    "cantMin",
    "cantMax",
    "accesoURL",
    "actividad",
    "profesores"
})
public class BeanClase {

    protected String nombre;
    protected BeanLocalDateTime inicio;
    protected int cantMin;
    protected int cantMax;
    @XmlSchemaType(name = "anyURI")
    protected String accesoURL;
    protected BeanDescActividad actividad;
    @XmlElement(nillable = true)
    protected List<BeanDescProfesor> profesores;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad inicio.
     * 
     * @return
     *     possible object is
     *     {@link BeanLocalDateTime }
     *     
     */
    public BeanLocalDateTime getInicio() {
        return inicio;
    }

    /**
     * Define el valor de la propiedad inicio.
     * 
     * @param value
     *     allowed object is
     *     {@link BeanLocalDateTime }
     *     
     */
    public void setInicio(BeanLocalDateTime value) {
        this.inicio = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMin.
     * 
     */
    public int getCantMin() {
        return cantMin;
    }

    /**
     * Define el valor de la propiedad cantMin.
     * 
     */
    public void setCantMin(int value) {
        this.cantMin = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMax.
     * 
     */
    public int getCantMax() {
        return cantMax;
    }

    /**
     * Define el valor de la propiedad cantMax.
     * 
     */
    public void setCantMax(int value) {
        this.cantMax = value;
    }

    /**
     * Obtiene el valor de la propiedad accesoURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccesoURL() {
        return accesoURL;
    }

    /**
     * Define el valor de la propiedad accesoURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccesoURL(String value) {
        this.accesoURL = value;
    }

    /**
     * Obtiene el valor de la propiedad actividad.
     * 
     * @return
     *     possible object is
     *     {@link BeanDescActividad }
     *     
     */
    public BeanDescActividad getActividad() {
        return actividad;
    }

    /**
     * Define el valor de la propiedad actividad.
     * 
     * @param value
     *     allowed object is
     *     {@link BeanDescActividad }
     *     
     */
    public void setActividad(BeanDescActividad value) {
        this.actividad = value;
    }

    /**
     * Gets the value of the profesores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profesores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfesores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeanDescProfesor }
     * 
     * 
     */
    public List<BeanDescProfesor> getProfesores() {
        if (profesores == null) {
            profesores = new ArrayList<BeanDescProfesor>();
        }
        return this.profesores;
    }

}
