//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.02.24 at 10:55:05 AM CST 
//

package com.three360.fixatdl.core;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The list of security types that the given strategy is valid for. The absence of any security types implies that the strategy is valid for all markets.
 * <p>
 * <p>
 * Java class for SecurityTypes_t complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <p>
 * <pre>
 * &lt;complexType name="SecurityTypes_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="SecurityType">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="ABS"/>
 *                       &lt;enumeration value="AMENDED"/>
 *                       &lt;enumeration value="AN"/>
 *                       &lt;enumeration value="BA"/>
 *                       &lt;enumeration value="BN"/>
 *                       &lt;enumeration value="BOX"/>
 *                       &lt;enumeration value="BRADY"/>
 *                       &lt;enumeration value="BRIDGE"/>
 *                       &lt;enumeration value="BUYSELL"/>
 *                       &lt;enumeration value="CB"/>
 *                       &lt;enumeration value="CD"/>
 *                       &lt;enumeration value="CL"/>
 *                       &lt;enumeration value="CMBS"/>
 *                       &lt;enumeration value="CMO"/>
 *                       &lt;enumeration value="COFO"/>
 *                       &lt;enumeration value="COFP"/>
 *                       &lt;enumeration value="CORP"/>
 *                       &lt;enumeration value="CP"/>
 *                       &lt;enumeration value="CPP"/>
 *                       &lt;enumeration value="CS"/>
 *                       &lt;enumeration value="DEFLTED"/>
 *                       &lt;enumeration value="DINP"/>
 *                       &lt;enumeration value="DN"/>
 *                       &lt;enumeration value="DUAL"/>
 *                       &lt;enumeration value="EUCD"/>
 *                       &lt;enumeration value="EUCORP"/>
 *                       &lt;enumeration value="EUCP"/>
 *                       &lt;enumeration value="EUSOV"/>
 *                       &lt;enumeration value="EUSUPRA"/>
 *                       &lt;enumeration value="FAC"/>
 *                       &lt;enumeration value="FADN"/>
 *                       &lt;enumeration value="FOR"/>
 *                       &lt;enumeration value="FORWARD"/>
 *                       &lt;enumeration value="FUT"/>
 *                       &lt;enumeration value="GO"/>
 *                       &lt;enumeration value="IET"/>
 *                       &lt;enumeration value="LOFC"/>
 *                       &lt;enumeration value="LQN"/>
 *                       &lt;enumeration value="MATURED"/>
 *                       &lt;enumeration value="MBS"/>
 *                       &lt;enumeration value="MF"/>
 *                       &lt;enumeration value="MIO"/>
 *                       &lt;enumeration value="MLEG"/>
 *                       &lt;enumeration value="MPO"/>
 *                       &lt;enumeration value="MPP"/>
 *                       &lt;enumeration value="MPT"/>
 *                       &lt;enumeration value="MT"/>
 *                       &lt;enumeration value="MTN"/>
 *                       &lt;enumeration value="NONE"/>
 *                       &lt;enumeration value="ONITE"/>
 *                       &lt;enumeration value="OPT"/>
 *                       &lt;enumeration value="PEF"/>
 *                       &lt;enumeration value="PFAND"/>
 *                       &lt;enumeration value="PN"/>
 *                       &lt;enumeration value="PS"/>
 *                       &lt;enumeration value="PZFJ"/>
 *                       &lt;enumeration value="RAN"/>
 *                       &lt;enumeration value="REPLACD"/>
 *                       &lt;enumeration value="REPO"/>
 *                       &lt;enumeration value="RETIRED"/>
 *                       &lt;enumeration value="REV"/>
 *                       &lt;enumeration value="RVLV"/>
 *                       &lt;enumeration value="RVLVTRM"/>
 *                       &lt;enumeration value="SECLOAN"/>
 *                       &lt;enumeration value="SECPLEDGE"/>
 *                       &lt;enumeration value="SPCLA"/>
 *                       &lt;enumeration value="SPCLO"/>
 *                       &lt;enumeration value="SPCLT"/>
 *                       &lt;enumeration value="STN"/>
 *                       &lt;enumeration value="STRUCT"/>
 *                       &lt;enumeration value="SUPRA"/>
 *                       &lt;enumeration value="SWING"/>
 *                       &lt;enumeration value="TAN"/>
 *                       &lt;enumeration value="TAXA"/>
 *                       &lt;enumeration value="TBA"/>
 *                       &lt;enumeration value="TBILL"/>
 *                       &lt;enumeration value="TBOND"/>
 *                       &lt;enumeration value="TCAL"/>
 *                       &lt;enumeration value="TD"/>
 *                       &lt;enumeration value="TECP"/>
 *                       &lt;enumeration value="TERM"/>
 *                       &lt;enumeration value="TINT"/>
 *                       &lt;enumeration value="TIPS"/>
 *                       &lt;enumeration value="TNOTE"/>
 *                       &lt;enumeration value="TPRN"/>
 *                       &lt;enumeration value="TRAN"/>
 *                       &lt;enumeration value="UST"/>
 *                       &lt;enumeration value="USTB"/>
 *                       &lt;enumeration value="VRDN"/>
 *                       &lt;enumeration value="WAR"/>
 *                       &lt;enumeration value="WITHDRN"/>
 *                       &lt;enumeration value="?"/>
 *                       &lt;enumeration value="XCN"/>
 *                       &lt;enumeration value="XLINKD"/>
 *                       &lt;enumeration value="YANK"/>
 *                       &lt;enumeration value="YCD"/>
 *                       &lt;enumeration value="OOP"/>
 *                       &lt;enumeration value="OOF"/>
 *                       &lt;enumeration value="CASH"/>
 *                       &lt;enumeration value="OOC"/>
 *                       &lt;enumeration value="IRS"/>
 *                       &lt;enumeration value="BDN"/>
 *                       &lt;enumeration value="CAMM"/>
 *                       &lt;enumeration value="CAN"/>
 *                       &lt;enumeration value="CTB"/>
 *                       &lt;enumeration value="CDS"/>
 *                       &lt;enumeration value="CMB"/>
 *                       &lt;enumeration value="EUFRN"/>
 *                       &lt;enumeration value="FRN"/>
 *                       &lt;enumeration value="PROV"/>
 *                       &lt;enumeration value="SLQN"/>
 *                       &lt;enumeration value="TB"/>
 *                       &lt;enumeration value="TLQN"/>
 *                       &lt;enumeration value="TMCP"/>
 *                       &lt;enumeration value="FXNDF"/>
 *                       &lt;enumeration value="FXSPOT"/>
 *                       &lt;enumeration value="FXFWD"/>
 *                       &lt;enumeration value="FXSWAP"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="inclusion" use="required" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Inclusion_t" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityTypes_t", propOrder = {
        "securityType"
})
public class SecurityTypesT {

    @XmlElement(name = "SecurityType", required = true)
    protected List<SecurityType> securityType;

    /**
     * Gets the value of the securityType property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the securityType property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <p>
     * <pre>
     * getSecurityType().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecurityTypesT.SecurityType }
     */
    public List<SecurityType> getSecurityType() {
        if (securityType == null) {
            securityType = new ArrayList<SecurityType>();
        }
        return this.securityType;
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     * <p>
     * <p>
     * The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="ABS"/>
     *             &lt;enumeration value="AMENDED"/>
     *             &lt;enumeration value="AN"/>
     *             &lt;enumeration value="BA"/>
     *             &lt;enumeration value="BN"/>
     *             &lt;enumeration value="BOX"/>
     *             &lt;enumeration value="BRADY"/>
     *             &lt;enumeration value="BRIDGE"/>
     *             &lt;enumeration value="BUYSELL"/>
     *             &lt;enumeration value="CB"/>
     *             &lt;enumeration value="CD"/>
     *             &lt;enumeration value="CL"/>
     *             &lt;enumeration value="CMBS"/>
     *             &lt;enumeration value="CMO"/>
     *             &lt;enumeration value="COFO"/>
     *             &lt;enumeration value="COFP"/>
     *             &lt;enumeration value="CORP"/>
     *             &lt;enumeration value="CP"/>
     *             &lt;enumeration value="CPP"/>
     *             &lt;enumeration value="CS"/>
     *             &lt;enumeration value="DEFLTED"/>
     *             &lt;enumeration value="DINP"/>
     *             &lt;enumeration value="DN"/>
     *             &lt;enumeration value="DUAL"/>
     *             &lt;enumeration value="EUCD"/>
     *             &lt;enumeration value="EUCORP"/>
     *             &lt;enumeration value="EUCP"/>
     *             &lt;enumeration value="EUSOV"/>
     *             &lt;enumeration value="EUSUPRA"/>
     *             &lt;enumeration value="FAC"/>
     *             &lt;enumeration value="FADN"/>
     *             &lt;enumeration value="FOR"/>
     *             &lt;enumeration value="FORWARD"/>
     *             &lt;enumeration value="FUT"/>
     *             &lt;enumeration value="GO"/>
     *             &lt;enumeration value="IET"/>
     *             &lt;enumeration value="LOFC"/>
     *             &lt;enumeration value="LQN"/>
     *             &lt;enumeration value="MATURED"/>
     *             &lt;enumeration value="MBS"/>
     *             &lt;enumeration value="MF"/>
     *             &lt;enumeration value="MIO"/>
     *             &lt;enumeration value="MLEG"/>
     *             &lt;enumeration value="MPO"/>
     *             &lt;enumeration value="MPP"/>
     *             &lt;enumeration value="MPT"/>
     *             &lt;enumeration value="MT"/>
     *             &lt;enumeration value="MTN"/>
     *             &lt;enumeration value="NONE"/>
     *             &lt;enumeration value="ONITE"/>
     *             &lt;enumeration value="OPT"/>
     *             &lt;enumeration value="PEF"/>
     *             &lt;enumeration value="PFAND"/>
     *             &lt;enumeration value="PN"/>
     *             &lt;enumeration value="PS"/>
     *             &lt;enumeration value="PZFJ"/>
     *             &lt;enumeration value="RAN"/>
     *             &lt;enumeration value="REPLACD"/>
     *             &lt;enumeration value="REPO"/>
     *             &lt;enumeration value="RETIRED"/>
     *             &lt;enumeration value="REV"/>
     *             &lt;enumeration value="RVLV"/>
     *             &lt;enumeration value="RVLVTRM"/>
     *             &lt;enumeration value="SECLOAN"/>
     *             &lt;enumeration value="SECPLEDGE"/>
     *             &lt;enumeration value="SPCLA"/>
     *             &lt;enumeration value="SPCLO"/>
     *             &lt;enumeration value="SPCLT"/>
     *             &lt;enumeration value="STN"/>
     *             &lt;enumeration value="STRUCT"/>
     *             &lt;enumeration value="SUPRA"/>
     *             &lt;enumeration value="SWING"/>
     *             &lt;enumeration value="TAN"/>
     *             &lt;enumeration value="TAXA"/>
     *             &lt;enumeration value="TBA"/>
     *             &lt;enumeration value="TBILL"/>
     *             &lt;enumeration value="TBOND"/>
     *             &lt;enumeration value="TCAL"/>
     *             &lt;enumeration value="TD"/>
     *             &lt;enumeration value="TECP"/>
     *             &lt;enumeration value="TERM"/>
     *             &lt;enumeration value="TINT"/>
     *             &lt;enumeration value="TIPS"/>
     *             &lt;enumeration value="TNOTE"/>
     *             &lt;enumeration value="TPRN"/>
     *             &lt;enumeration value="TRAN"/>
     *             &lt;enumeration value="UST"/>
     *             &lt;enumeration value="USTB"/>
     *             &lt;enumeration value="VRDN"/>
     *             &lt;enumeration value="WAR"/>
     *             &lt;enumeration value="WITHDRN"/>
     *             &lt;enumeration value="?"/>
     *             &lt;enumeration value="XCN"/>
     *             &lt;enumeration value="XLINKD"/>
     *             &lt;enumeration value="YANK"/>
     *             &lt;enumeration value="YCD"/>
     *             &lt;enumeration value="OOP"/>
     *             &lt;enumeration value="OOF"/>
     *             &lt;enumeration value="CASH"/>
     *             &lt;enumeration value="OOC"/>
     *             &lt;enumeration value="IRS"/>
     *             &lt;enumeration value="BDN"/>
     *             &lt;enumeration value="CAMM"/>
     *             &lt;enumeration value="CAN"/>
     *             &lt;enumeration value="CTB"/>
     *             &lt;enumeration value="CDS"/>
     *             &lt;enumeration value="CMB"/>
     *             &lt;enumeration value="EUFRN"/>
     *             &lt;enumeration value="FRN"/>
     *             &lt;enumeration value="PROV"/>
     *             &lt;enumeration value="SLQN"/>
     *             &lt;enumeration value="TB"/>
     *             &lt;enumeration value="TLQN"/>
     *             &lt;enumeration value="TMCP"/>
     *             &lt;enumeration value="FXNDF"/>
     *             &lt;enumeration value="FXSPOT"/>
     *             &lt;enumeration value="FXFWD"/>
     *             &lt;enumeration value="FXSWAP"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="inclusion" use="required" type="{http://www.fixprotocol.org/FIXatdl-1-1/Core}Inclusion_t" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SecurityType {

        @XmlAttribute(required = true)
        protected String name;
        @XmlAttribute(required = true)
        protected InclusionT inclusion;

        /**
         * Gets the value of the name property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the inclusion property.
         *
         * @return possible object is
         * {@link InclusionT }
         */
        public InclusionT getInclusion() {
            return inclusion;
        }

        /**
         * Sets the value of the inclusion property.
         *
         * @param value allowed object is
         *              {@link InclusionT }
         */
        public void setInclusion(InclusionT value) {
            this.inclusion = value;
        }

    }

}
