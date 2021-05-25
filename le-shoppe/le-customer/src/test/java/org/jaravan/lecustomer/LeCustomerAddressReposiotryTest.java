/**
 *
 */
package org.jaravan.lecustomer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.jaravan.lecustomer.entity.Address;
import org.jaravan.lecustomer.entity.Customer;
import org.jaravan.lecustomer.services.AddressRepository;
import org.jaravan.lecustomer.services.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

/**
 * @author jayant
 *
 */
@EnableJpaRepositories(basePackages = {"org.jaravan.lecustomer"})
@DataJpaTest(bootstrapMode = BootstrapMode.DEFAULT)
public class LeCustomerAddressReposiotryTest {

    /**
     * Entity Manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Customer Repository service.
     */
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Address Repository service.
     */
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void addressRepositoryTest() {
      assertThat(addressRepository).isNotNull();
    }

    /**
     * Create Customer and Address.
     */
    @Test
    public void createCustomerAddress() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        customerRepository.save(customer);

        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(customer);
        addressRepository.save(address);
        entityManager.flush();
    }

    /**
     * Test Address 'Line 1' is required.
     * null 'Line 1' is now allowed.
     */
    @Test
    public void createAddressWithNullkLine1() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        Address address = new Address(null,
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address 'Line 1' is required.
     * Blank 'Line 1' is now allowed.
     */
    @Test
    public void createAddressWithBlankLine1() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        Address address = new Address(null,
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address 'City' is required.
     * null 'City' is now allowed.
     */
    @Test
    public void createAddressWithBlankCity() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        //Blank City Name.
        Address address = new Address("6649 N Blue Gum St",
                "", "", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address 'City' is required.
     * null 'City' is now allowed.
     */
    @Test
    public void createAddressWithNullCity() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        Address address = new Address("6649 N Blue Gum St",
                "", null, "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address 'State' is required.
     * null 'State' is now allowed.
     */
    @Test
    public void createAddressWithNullState() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", null, "USA", "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address 'State' is required.
     * Blank 'State' is now allowed.
     */
    @Test
    public void createAddressWithBlankState() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "", "USA", "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address 'Country' is required.
     * null 'Country' is now allowed.
     */
    @Test
    public void createAddressWithNullCountry() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", null, "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address country is required.
     * Blank country is now allowed.
     */
    @Test
    public void createAddressWithBlankCountry() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "", "70116", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address 'Zipcode' is required.
     * null 'Zipcode' is now allowed.
     */
    @Test
    public void createAddressWithNullZipcode() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);

        // null Zipcode
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", null, "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }

    /**
     * Test Address zipcode is required.
     * Blank zipcode is now allowed.
     */
    @Test
    public void createAddressWithBlankZipcode() {
        Customer customer = new Customer("Art", "M", "Caldarera");
        Customer newCustomer = customerRepository.save(customer);

        // Blank Zipcode
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", "", "RESIDENCE");
        address.setCustomer(newCustomer);

        assertThrows(ConstraintViolationException.class, () -> {
            addressRepository.save(address);
            entityManager.flush();
        });
    }
}
