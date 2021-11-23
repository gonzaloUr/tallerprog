
package com.entrenamosuy.web.publicar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para beanLocalDateTime complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="beanLocalDateTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dayOfMonth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nano" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="second" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanLocalDateTime", propOrder = {
    "dayOfMonth",
    "hour",
    "minute",
    "month",
    "nano",
    "second",
    "year"
})
public class BeanLocalDateTime {

    protected int dayOfMonth;
    protected int hour;
    protected int minute;
    protected int month;
    protected int nano;
    protected int second;
    protected int year;

    /**
     * Obtiene el valor de la propiedad dayOfMonth.
     * 
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * Define el valor de la propiedad dayOfMonth.
     * 
     */
    public void setDayOfMonth(int value) {
        this.dayOfMonth = value;
    }

    /**
     * Obtiene el valor de la propiedad hour.
     * 
     */
    public int getHour() {
        return hour;
    }

    /**
     * Define el valor de la propiedad hour.
     * 
     */
    public void setHour(int value) {
        this.hour = value;
    }

    /**
     * Obtiene el valor de la propiedad minute.
     * 
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Define el valor de la propiedad minute.
     * 
     */
    public void setMinute(int value) {
        this.minute = value;
    }

    /**
     * Obtiene el valor de la propiedad month.
     * 
     */
    public int getMonth() {
        return month;
    }

    /**
     * Define el valor de la propiedad month.
     * 
     */
    public void setMonth(int value) {
        this.month = value;
    }

    /**
     * Obtiene el valor de la propiedad nano.
     * 
     */
    public int getNano() {
        return nano;
    }

    /**
     * Define el valor de la propiedad nano.
     * 
     */
    public void setNano(int value) {
        this.nano = value;
    }

    /**
     * Obtiene el valor de la propiedad second.
     * 
     */
    public int getSecond() {
        return second;
    }

    /**
     * Define el valor de la propiedad second.
     * 
     */
    public void setSecond(int value) {
        this.second = value;
    }

    /**
     * Obtiene el valor de la propiedad year.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Define el valor de la propiedad year.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

}
