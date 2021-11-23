
package com.entrenamosuy.web.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beanSocio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanSocio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correo" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanEmail" minOccurs="0"/>
 *         &lt;element name="nacimiento" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanLocalDate" minOccurs="0"/>
 *         &lt;element name="seguidores" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="seguidos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clases" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanClase" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cuponeras" type="{http://publicar.view.tarea1.entrenamosuy.com/}beanCuponera" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="favoritas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clasesGanadas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanSocio", propOrder = {
    "nickname",
    "nombre",
    "apellido",
    "correo",
    "nacimiento",
    "seguidores",
    "seguidos",
    "clases",
    "cuponeras",
    "favoritas",
    "clasesGanadas"
})
public class BeanSocio {

    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected BeanEmail correo;
    protected BeanLocalDate nacimiento;
    @XmlElement(nillable = true)
    protected List<String> seguidores;
    @XmlElement(nillable = true)
    protected List<String> seguidos;
    @XmlElement(nillable = true)
    protected List<BeanClase> clases;
    @XmlElement(nillable = true)
    protected List<BeanCuponera> cuponeras;
    @XmlElement(nillable = true)
    protected List<String> favoritas;
    @XmlElement(nillable = true)
    protected List<String> clasesGanadas;

    /**
     * Gets the value of the nickname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the value of the nickname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
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
     * Gets the value of the apellido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Sets the value of the apellido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

    /**
     * Gets the value of the correo property.
     * 
     * @return
     *     possible object is
     *     {@link BeanEmail }
     *     
     */
    public BeanEmail getCorreo() {
        return correo;
    }

    /**
     * Sets the value of the correo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeanEmail }
     *     
     */
    public void setCorreo(BeanEmail value) {
        this.correo = value;
    }

    /**
     * Gets the value of the nacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link BeanLocalDate }
     *     
     */
    public BeanLocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * Sets the value of the nacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeanLocalDate }
     *     
     */
    public void setNacimiento(BeanLocalDate value) {
        this.nacimiento = value;
    }

    /**
     * Gets the value of the seguidores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seguidores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeguidores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSeguidores() {
        if (seguidores == null) {
            seguidores = new ArrayList<String>();
        }
        return this.seguidores;
    }

    /**
     * Gets the value of the seguidos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seguidos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeguidos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSeguidos() {
        if (seguidos == null) {
            seguidos = new ArrayList<String>();
        }
        return this.seguidos;
    }

    /**
     * Gets the value of the clases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeanClase }
     * 
     * 
     */
    public List<BeanClase> getClases() {
        if (clases == null) {
            clases = new ArrayList<BeanClase>();
        }
        return this.clases;
    }

    /**
     * Gets the value of the cuponeras property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cuponeras property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCuponeras().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeanCuponera }
     * 
     * 
     */
    public List<BeanCuponera> getCuponeras() {
        if (cuponeras == null) {
            cuponeras = new ArrayList<BeanCuponera>();
        }
        return this.cuponeras;
    }

    /**
     * Gets the value of the favoritas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the favoritas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavoritas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFavoritas() {
        if (favoritas == null) {
            favoritas = new ArrayList<String>();
        }
        return this.favoritas;
    }

    /**
     * Gets the value of the clasesGanadas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clasesGanadas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClasesGanadas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getClasesGanadas() {
        if (clasesGanadas == null) {
            clasesGanadas = new ArrayList<String>();
        }
        return this.clasesGanadas;
    }

}
