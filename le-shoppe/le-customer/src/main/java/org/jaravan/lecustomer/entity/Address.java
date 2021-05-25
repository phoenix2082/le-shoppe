/**
 */
package org.jaravan.lecustomer.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6303141726633161875L;

    /**
     * Unique Identifier of this Address.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The first line of Address.
     */
    @Column(name = "line_1")
    @NotBlank(message = "is required.")
    @JsonProperty("line1")
    private String line1;

    /**
     * The second line of Address.
     */
    @Column(name = "line_2")
    @JsonProperty("line2")
    private String line2;

    /**
     * The city of Address.
     */
    @Column(name = "city")
    @NotBlank(message = "is required.")
    private String city;

    /**
     * The state of Address.
     */
    @Column(name = "state")
    @NotBlank(message = "is required.")
    private String state;

    /**
     * The Country of Address.
     */
    @Column(name = "country")
    @NotBlank(message = "is required.")
    private String country;

    /**
     * The Zipcode of address.
     */
    @Column(name = "zipcode")
    @NotBlank(message = "is required.")
    private String zipCode;

    /**
     * The type of Address. Must be one of OFFICE/RESIDENCE.
     */
    @Column(name = "type")
    private AddressType type;

    /**
     * The person to which this address belongs.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUST_ID", nullable = false)
    private Customer customer;

    /**
     * Deafult Constructor.
     */
    public Address() {

    }

    /**
     * Create a Real World Address location of a person.
     *
     * @param addLine1 First Address Line.
     * @param addLine2 Second Address Line.
     * @param city2 City of residence.
     * @param state2 State of residence.
     * @param country2 Country of residence.
     * @param zipCode2 Zipcode of residence.
     * @param type2 Whether office or personal residence.
     */
    public Address(final String addLine1,
            final String addLine2,
            final String city2,
            final String state2,
            final String country2,
            final String zipCode2,
            final String type2) {
        this.line1 = addLine1;
        this.line2 = addLine2;
        this.city = city2;
        this.state = state2;
        this.country = country2;
        this.zipCode = zipCode2;
        this.type = AddressType.valueOf(type2);
    }

    /**
     * Customer whose address is represented by this object.
     * @return Customer
     */
    //@JsonManagedReference
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the Customer whose address is represented by this object.
     * @param cust Customer
     */
    public void setCustomer(final Customer cust) {
        this.customer = cust;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setId(final Long addressId) {
        this.id = addressId;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * City of residence.
     * @param cityName the name of the city to set
     */
    public void setCity(final String cityName) {
        this.city = cityName;
    }

    /**
     * Geographical state of residence.
     * @return the state in which
     */
    public String getState() {
        return state;
    }

    /**
     * Geographical state of residence.
     * @param stateName the Geographical state of residence to set
     */
    public void setState(final String stateName) {
        this.state = stateName;
    }

    /**
     * Country of residence.
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param countryName the name of country to set
     */
    public void setCountry(final String countryName) {
        this.country = countryName;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * The Zip/Pin/Area code of this address object.
     * @param zipcode the zip code to set
     */
    public void setZipCode(final String zipcode) {
        this.zipCode = zipcode;
    }

    /**
     * @return the type
     */
    public AddressType getType() {
        return type;
    }

    /**
     * Address type. One of OFFICE or RESIDENCE
     * @param addressType the type to address set
     */
    public void setType(final AddressType addressType) {
        this.type = addressType;
    }

    /**
     * @return the line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     * @param addressLine1 the first address line to set
     */
    public void setLine1(final String addressLine1) {
        this.line1 = addressLine1;
    }

    /**
     * @return the line2
     */
    public String getLine2() {
        return line2;
    }

    /**
     * @param addressLine2 the second address line to set.
     */
    public void setLine2(final String addressLine2) {
        this.line2 = addressLine2;
    }

    @Override
    public String toString() {
        return "Address [id=" + id
                + ", line1=" + line1
                + ", line2=" + line2
                + ", city=" + city
                + ", state=" + state
                + ", country=" + country
                + ", zipCode=" + zipCode
                + ", type=" + type
                + ", customer=" + customer.getId() + "]";
    }

}
