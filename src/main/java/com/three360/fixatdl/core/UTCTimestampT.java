//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//

package com.three360.fixatdl.core;

import com.three360.fixatdl.timezones.Timezone;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Derived parameter type corresponding to the FIX "UTCTimestamp" type defined in the FIX specification.
 * <p>
 * <p>
 * Java class for UTCTimestamp_t complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <p>
 * <pre>
 * &lt;complexType name="UTCTimestamp_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Parameter_t">
 *       &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="constValue" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="localMktTz" type="{http://www.fixprotocol.org/FIXatdl-1-1/Timezones}LocalMktTz_t" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UTCTimestamp_t")
public class UTCTimestampT
        extends ParameterT {

    @XmlAttribute
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar minValue;
    @XmlAttribute
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar maxValue;
    @XmlAttribute
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar constValue;
    @XmlAttribute
    protected Timezone localMktTz;

    /**
     * Gets the value of the minValue property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMinValue() {
        return minValue;
    }

    /**
     * Sets the value of the minValue property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMinValue(XMLGregorianCalendar value) {
        this.minValue = value;
    }

    /**
     * Gets the value of the maxValue property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the value of the maxValue property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMaxValue(XMLGregorianCalendar value) {
        this.maxValue = value;
    }

    /**
     * Gets the value of the constValue property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getConstValue() {
        return constValue;
    }

    /**
     * Sets the value of the constValue property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setConstValue(XMLGregorianCalendar value) {
        this.constValue = value;
    }

    /**
     * Gets the value of the localMktTz property.
     *
     * @return possible object is
     * {@link Timezone }
     */
    public Timezone getLocalMktTz() {
        return localMktTz;
    }

    /**
     * Sets the value of the localMktTz property.
     *
     * @param value allowed object is
     *              {@link Timezone }
     */
    public void setLocalMktTz(Timezone value) {
        this.localMktTz = value;
    }

}
