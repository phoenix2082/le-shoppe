/**
 *
 */
package org.jaravan.lecustomer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.jaravan.lecustomer.entity.Address;
import org.jaravan.lecustomer.entity.Customer;
import org.jaravan.lecustomer.services.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

/**
 */
@EnableJpaRepositories(basePackages = {"org.jaravan.lecustomer"})
@DataJpaTest(bootstrapMode = BootstrapMode.DEFAULT)
public class LeCustomerRepositoryTest {

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
     * Populate database with test data.
     */
    @BeforeEach
    public void setUp() {
        // given
        Customer customer = new Customer("Art", "M", "Caldarera");
        List<Address> addressList = new ArrayList<Address>();
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(customer);
        addressList.add(address);
        customer.setAddresses(addressList);

        customerRepository.save(customer);
    }

    @Test
      void customerRepositoryTest() {
        assertThat(customerRepository).isNotNull();
      }

    /**
     * Test find customer by Id.
     */
    @Test
    public void findCustomerByIdTest() {

        ArrayList<Customer> customers = (ArrayList<Customer>)
                customerRepository.findAll();

        assertThat(customers.size()).isGreaterThan(0);

        Customer customer = customerRepository.findAll().iterator().next();
        assertThat(customer.getId()).isEqualTo(1);
    }

    /**
     * Test Customer first name.
     * Null value is not allowed in customer first name.
     */
    @Test
    public void customerFirstNameNotNullTest() {

        Customer customer = new Customer(null, "M", "Caldarera");
        List<Address> addressList = new ArrayList<Address>();
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(customer);
        addressList.add(address);

        customer.setAddresses(addressList);

        // After executing repository operation, flush is required,
        // because JPA invokes the Bean Validation operation only when
        // database synchronisation i.e. during commit or flush.
        //entityManager.flush();

        assertThrows(ConstraintViolationException.class, () -> {
            customerRepository.save(customer);
            entityManager.flush();
        });
    }

    /**
     * Test Customer first name.
     * Blank value is not allowed in customer first name.
     */
    @Test
    public void customerFirstNameNotBlankTest() {

        Customer customer = new Customer("", "M", "Caldarera");
        List<Address> addressList = new ArrayList<Address>();
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(customer);
        addressList.add(address);

        customer.setAddresses(addressList);

        // After executing repository operation, flush is required,
        // because JPA invokes the Bean Validation operation only when
        // database synchronisation i.e. during commit or flush.
        //entityManager.flush();

        assertThrows(ConstraintViolationException.class, () -> {
            customerRepository.save(customer);
            entityManager.flush();
        });
    }
    
    /**
     * Test Customer first name.
     * Blank value is not allowed in customer first name.
     */
    @Test
    public void customerLastNameNullBlankTest() {

        Customer customer = new Customer("Art", "M", null);
        List<Address> addressList = new ArrayList<Address>();
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(customer);
        addressList.add(address);

        customer.setAddresses(addressList);

        // After executing repository operation, flush is required,
        // because JPA invokes the Bean Validation operation only when
        // database synchronisation i.e. during commit or flush.
        //entityManager.flush();

        assertThrows(ConstraintViolationException.class, () -> {
            customerRepository.save(customer);
            entityManager.flush();
        });
    }
    
    /**
     * Test Customer first name.
     * Blank value is not allowed in customer first name.
     */
    @Test
    public void customerLastNameNotBlankTest() {

        Customer customer = new Customer("Art", "M", "");
        List<Address> addressList = new ArrayList<Address>();
        Address address = new Address("6649 N Blue Gum St",
                "", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(customer);
        addressList.add(address);

        customer.setAddresses(addressList);

        // After executing repository operation, flush is required,
        // because JPA invokes the Bean Validation operation only when
        // database synchronisation i.e. during commit or flush.
        //entityManager.flush();

        assertThrows(ConstraintViolationException.class, () -> {
            customerRepository.save(customer);
            entityManager.flush();
        });
    }

}
