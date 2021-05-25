package org.jaravan.lecustomer.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Customer implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7009517139124214732L;

    /**
     * the unique ID of the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * First name of the person.
     */
    @Column(name = "first_name")
    @NotBlank(message = "is required.")
    private String firstName;

    /**
     * Middle name of the person.
     */
    @Column(name = "middle_name")
    private String middleName;

    /**
     * Last name of the person.
     */
    @Column(name = "last_name")
    @NotBlank(message = "is required.")
    private String lastName;

    /**
     * List of Addresses of person.
     */
    @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER,
                mappedBy = "customer")
    //@JsonBackReference
    private List<Address> addresses;

    /**
     * Create a new Constructor Instance.
     * @param firstname first name of the customer.
     * @param middlename middle name of the customer.
     * @param lastname last name of the customer.
     * @param addrList
     */
    public Customer(final String firstname,
            final String middlename,
            final String lastname,
            final List<Address> addrList) {
        this.firstName = firstname;
        this.middleName = middlename;
        this.lastName = lastname;
        this.addresses = addrList;
    }

    /**
     * Create a new Constructor Instance.
     * @param firstname first name of the customer.
     * @param middlename middle name of the customer.
     * @param lastname last name of the customer.
     */
    public Customer(final String firstname,
            final String middlename,
            final String lastname) {
        this.firstName = firstname;
        this.middleName = middlename;
        this.lastName = lastname;
    }

    /**
     * Default constructor.
     */
    public Customer() {
        super();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setId(final Long identifier) {
        this.id = identifier;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstName(final String firstname) {
        this.firstName = firstname;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middlename the middle name to set
     */
    public void setMiddleName(final String middlename) {
        this.middleName = middlename;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastname the last name to set
     */
    public void setLastName(final String lastname) {
        this.lastName = lastname;
    }

    /**
     * @return the address
     */
    public List<Address> getAddresses() {

        if (addresses == null) {
            addresses = new ArrayList<Address>();
        }
        return addresses;
    }

    /**
     * @param addressList the addressList to set
     */
    public void setAddresses(final List<Address> addressList) {
        this.addresses = addressList;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ","
                + " firstName=" + firstName
                + ", middleName=" + middleName
                + ", lastName=" + lastName
                + ", address=" + addresses + "]";
    }

}
