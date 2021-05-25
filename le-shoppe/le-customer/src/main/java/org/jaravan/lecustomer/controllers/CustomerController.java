package org.jaravan.lecustomer.controllers;

import java.util.List;

import org.jaravan.lecustomer.entity.Address;
import org.jaravan.lecustomer.entity.Customer;
import org.jaravan.lecustomer.services.AddressRepository;
import org.jaravan.lecustomer.services.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c")
public class CustomerController {

    /**
     * Customer Controller logger.
     */
    private Logger logger = LoggerFactory
            .getLogger(CustomerController.class);

    /**
     * Customer Repository.
     */
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Address Repository.
     */
    @Autowired
    private AddressRepository addressRepository;

    /**
     * Find list of all customers.
     *
     * @return list of customers.
     */
    @GetMapping("/all")
    public @ResponseBody Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    /**
     * Create a new Customer.
     *
     * @param customer Customer object.
     * @return new customer.
     */
    @PostMapping("/create")
    Customer create(@RequestBody final Customer customer) {
        Customer c = null;
        try {
            logger.info("Creating Customer {}.", customer);
            c = customerRepository.save(customer);

            logger.info("Created Customer {}.", c);

            List<Address> addresses = customer.getAddresses();
            logger.info("Creating Addresses {}.", addresses);
            for (Address adr: addresses) {
                adr.setCustomer(c);
            }
            addresses.forEach(addr -> {
                addressRepository.save(addr);
                logger.info("Created Address {}.", addr);
            });

        } catch (Exception e) {
            logger.error("Error on creating customer: {}", e);
        }
        return c;
    }

}
