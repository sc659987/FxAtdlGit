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
import java.math.BigInteger;

/**
 * Derived parameter type corresponding to the FIX "SeqNum" type defined in the FIX specification.
 * <p>
 * <p>
 * Java class for SeqNum_t complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <p>
 * <pre>
 * &lt;complexType name="SeqNum_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Parameter_t">
 *       &lt;attribute name="constValue" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}SeqNum" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SeqNum_t")
public class SeqNumT
        extends ParameterT {

    @XmlAttribute
    protected BigInteger constValue;

    /**
     * Gets the value of the constValue property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getConstValue() {
        return constValue;
    }

    /**
     * Sets the value of the constValue property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setConstValue(BigInteger value) {
        this.constValue = value;
    }

}
