
package com.entrenamosuy.web.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beanClase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanClase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inicio" type="{http://publicar.view.tarea1.entrenamosuy.com/}localDateTime" minOccurs="0"/>
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
    protected LocalDateTime inicio;
    protected int cantMin;
    protected int cantMax;
    @XmlSchemaType(name = "anyURI")
    protected String accesoURL;
    protected BeanDescActividad actividad;
    @XmlElement(nillable = true)
    protected List<BeanDescProfesor> profesores;

    /**
     * Gets the value of the nombre property.
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
     * Sets the value of the nombre property.
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
     * Gets the value of the inicio property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDateTime }
     *     
     */
    public LocalDateTime getInicio() {
        return inicio;
    }

    /**
     * Sets the value of the inicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDateTime }
     *     
     */
    public void setInicio(LocalDateTime value) {
        this.inicio = value;
    }

    /**
     * Gets the value of the cantMin property.
     * 
     */
    public int getCantMin() {
        return cantMin;
    }

    /**
     * Sets the value of the cantMin property.
     * 
     */
    public void setCantMin(int value) {
        this.cantMin = value;
    }

    /**
     * Gets the value of the cantMax property.
     * 
     */
    public int getCantMax() {
        return cantMax;
    }

    /**
     * Sets the value of the cantMax property.
     * 
     */
    public void setCantMax(int value) {
        this.cantMax = value;
    }

    /**
     * Gets the value of the accesoURL property.
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
     * Sets the value of the accesoURL property.
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
     * Gets the value of the actividad property.
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
     * Sets the value of the actividad property.
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
