
package com.entrenamosuy.web.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para beanCrearClaseArgs complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
    protected byte[] imagen;
    protected BeanLocalDateTime inicio;
    @XmlElement(nillable = true)
    protected List<String> nicknameProfesores;
    protected String nombre;
    protected BeanLocalDate registro;

    /**
     * Obtiene el valor de la propiedad acceso.
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
     * Define el valor de la propiedad acceso.
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
     * Obtiene el valor de la propiedad actividad.
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
     * Define el valor de la propiedad actividad.
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
     * Obtiene el valor de la propiedad imagen.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Define el valor de la propiedad imagen.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImagen(byte[] value) {
        this.imagen = value;
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
     * Obtiene el valor de la propiedad registro.
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
     * Define el valor de la propiedad registro.
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
