//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//

package com.three360.fixatdl.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Derived parameter type corresponding to the FIX "int" type defined in the FIX specification.
 * <p>
 * <p>
 * Java class for Int_t complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <p>
 * <pre>
 * &lt;complexType name="Int_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Parameter_t">
 *       &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="constValue" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Int_t")
public class IntT
        extends ParameterT {

    @XmlAttribute
    protected Integer minValue;
    @XmlAttribute
    protected Integer maxValue;
    @XmlAttribute
    protected Integer constValue;

    /**
     * Gets the value of the minValue property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMinValue() {
        return minValue;
    }

    /**
     * Sets the value of the minValue property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinValue(Integer value) {
        this.minValue = value;
    }

    /**
     * Gets the value of the maxValue property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the value of the maxValue property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMaxValue(Integer value) {
        this.maxValue = value;
    }

    /**
     * Gets the value of the constValue property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getConstValue() {
        return constValue;
    }

    /**
     * Sets the value of the constValue property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setConstValue(Integer value) {
        this.constValue = value;
    }

}
