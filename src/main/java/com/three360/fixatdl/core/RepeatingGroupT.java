//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//

package com.three360.fixatdl.core;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java class for RepeatingGroup_t complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <p>
 * 
 * <pre>
 * &lt;complexType name="RepeatingGroup_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Description" minOccurs="0"/>
 *         &lt;element name="Parameter" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Parameter_t" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fixTag" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="minSize" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="maxSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepeatingGroup_t", propOrder = {
		"description",
		"parameter"
})
public class RepeatingGroupT {

	@XmlElement(name = "Description")
	protected String description;
	@XmlElement(name = "Parameter", required = true)
	protected List<ParameterT> parameter;
	@XmlAttribute
	protected String name;
	@XmlAttribute
	@XmlSchemaType(name = "positiveInteger")
	protected BigInteger fixTag;
	@XmlAttribute(required = true)
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger minSize;
	@XmlAttribute
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger maxSize;

	/**
	 * Description of the Repeating Group.
	 *
	 * @return possible object is
	 *         {@link String }
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 *
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the parameter property.
	 * <p>
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the parameter property.
	 * <p>
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <p>
	 * 
	 * <pre>
	 * getParameter().add(newItem);
	 * </pre>
	 * <p>
	 * <p>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ParameterT }
	 */
	public List<ParameterT> getParameter() {
		if (parameter == null) {
			parameter = new ArrayList<ParameterT>();
		}
		return this.parameter;
	}

	/**
	 * Gets the value of the name property.
	 *
	 * @return possible object is
	 *         {@link String }
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 *
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the fixTag property.
	 *
	 * @return possible object is
	 *         {@link BigInteger }
	 */
	public BigInteger getFixTag() {
		return fixTag;
	}

	/**
	 * Sets the value of the fixTag property.
	 *
	 * @param value
	 *            allowed object is
	 *            {@link BigInteger }
	 */
	public void setFixTag(BigInteger value) {
		this.fixTag = value;
	}

	/**
	 * Gets the value of the minSize property.
	 *
	 * @return possible object is
	 *         {@link BigInteger }
	 */
	public BigInteger getMinSize() {
		return minSize;
	}

	/**
	 * Sets the value of the minSize property.
	 *
	 * @param value
	 *            allowed object is
	 *            {@link BigInteger }
	 */
	public void setMinSize(BigInteger value) {
		this.minSize = value;
	}

	/**
	 * Gets the value of the maxSize property.
	 *
	 * @return possible object is
	 *         {@link BigInteger }
	 */
	public BigInteger getMaxSize() {
		return maxSize;
	}

	/**
	 * Sets the value of the maxSize property.
	 *
	 * @param value
	 *            allowed object is
	 *            {@link BigInteger }
	 */
	public void setMaxSize(BigInteger value) {
		this.maxSize = value;
	}

}
