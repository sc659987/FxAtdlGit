//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//

package com.three360.fixatdl.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * The list of markets (by ISO MIC Code) for which the given strategy is valid. The absence of any markets implies that the strategy is valid for all markets.
 * <p>
 * <p>
 * Java class for Markets_t complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <p>
 * 
 * <pre>
 * &lt;complexType name="Markets_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Market" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Market_t" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Markets_t", propOrder = {
		"market"
})
public class MarketsT {

	@XmlElement(name = "Market", required = true)
	protected List<MarketT> market;

	/**
	 * Gets the value of the market property.
	 * <p>
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the market property.
	 * <p>
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <p>
	 * 
	 * <pre>
	 * getMarket().add(newItem);
	 * </pre>
	 * <p>
	 * <p>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link MarketT }
	 */
	public List<MarketT> getMarket() {
		if (market == null) {
			market = new ArrayList<MarketT>();
		}
		return this.market;
	}

}
