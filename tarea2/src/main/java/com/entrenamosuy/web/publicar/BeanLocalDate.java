
package com.entrenamosuy.web.publicar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beanLocalDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanLocalDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dayOfMonth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "beanLocalDate", propOrder = {
    "dayOfMonth",
    "month",
    "year"
})
public class BeanLocalDate {

    protected int dayOfMonth;
    protected int month;
    protected int year;

    /**
     * Gets the value of the dayOfMonth property.
     * 
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * Sets the value of the dayOfMonth property.
     * 
     */
    public void setDayOfMonth(int value) {
        this.dayOfMonth = value;
    }

    /**
     * Gets the value of the month property.
     * 
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     */
    public void setMonth(int value) {
        this.month = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

}
