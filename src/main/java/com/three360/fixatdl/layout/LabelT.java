//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//

package com.three360.fixatdl.layout;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Label_t complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <p>
 * <pre>
 * &lt;complexType name="Label_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fixprotocol.org/FIXatdl-1-1/Layout}Control_t">
 *       &lt;attribute name="initValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Label_t")
public class LabelT
        extends ControlT {

    @XmlAttribute
    protected String initValue;

    /**
     * Gets the value of the initValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInitValue() {
        return initValue;
    }

    /**
     * Sets the value of the initValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInitValue(String value) {
        this.initValue = value;
    }

}
