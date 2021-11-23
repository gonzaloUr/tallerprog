
package com.entrenamosuy.web.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beanCrearClaseArgs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanCrearClaseArgs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acceso" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="actividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantMax" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantMin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantPremios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="descPremio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="inicio" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanLocalDateTime" minOccurs="0"/>
 *         &lt;element name="nicknameProfesores" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="registro" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanLocalDate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanCrearClaseArgs", propOrder = {
    "acceso",
    "actividad",
    "cantMax",
    "cantMin",
    "cantPremios",
    "descPremio",
    "imagen",
    "inicio",
    "nicknameProfesores",
    "nombre",
    "registro"
})
public class BeanCrearClaseArgs {

    @XmlSchemaType(name = "anyURI")
    protected String acceso;
    protected String actividad;
    protected int cantMax;
    protected int cantMin;
    protected int cantPremios;
    protected String descPremio;
    protected byte[] imagen;
    protected BeanLocalDateTime inicio;
    @XmlElement(nillable = true)
    protected List<String> nicknameProfesores;
    protected String nombre;
    protected BeanLocalDate registro;

    /**
     * Gets the value of the acceso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceso() {
        return acceso;
    }

    /**
     * Sets the value of the acceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceso(String value) {
        this.acceso = value;
    }

    /**
     * Gets the value of the actividad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActividad() {
        return actividad;
    }

    /**
     * Sets the value of the actividad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActividad(String value) {
        this.actividad = value;
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
     * Gets the value of the cantPremios property.
     * 
     */
    public int getCantPremios() {
        return cantPremios;
    }

    /**
     * Sets the value of the cantPremios property.
     * 
     */
    public void setCantPremios(int value) {
        this.cantPremios = value;
    }

    /**
     * Gets the value of the descPremio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPremio() {
        return descPremio;
    }

    /**
     * Sets the value of the descPremio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPremio(String value) {
        this.descPremio = value;
    }

    /**
     * Gets the value of the imagen property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Sets the value of the imagen property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImagen(byte[] value) {
        this.imagen = value;
    }

    /**
     * Gets the value of the inicio property.
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
     * Sets the value of the inicio property.
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
     * Gets the value of the nicknameProfesores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nicknameProfesores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNicknameProfesores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNicknameProfesores() {
        if (nicknameProfesores == null) {
            nicknameProfesores = new ArrayList<String>();
        }
        return this.nicknameProfesores;
    }

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
     * Gets the value of the registro property.
     * 
     * @return
     *     possible object is
     *     {@link BeanLocalDate }
     *     
     */
    public BeanLocalDate getRegistro() {
        return registro;
    }

    /**
     * Sets the value of the registro property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeanLocalDate }
     *     
     */
    public void setRegistro(BeanLocalDate value) {
        this.registro = value;
    }

}
