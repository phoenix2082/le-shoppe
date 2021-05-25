package org.jaravan.lecustomer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.jaravan.lecustomer.entity.Address;
import org.jaravan.lecustomer.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.yml")
@EnableAutoConfiguration
class LeCustomerTest {

    /**
     * Start local server with a random port.
     */
    @LocalServerPort
    private int port;

    /**
     * Inject default rest template.
     */
    @Autowired
    private TestRestTemplate restTemplate;

    @SuppressWarnings("unchecked")
    @Test
    public void getNoCustomers() throws Exception {

        String testURL = "http://localhost:" + port + "/c/all";

        assertThat(this.restTemplate.getForObject(testURL,
                Iterable.class)).hasSize(0);
    }
    
    @Test
    public void createCustomer() throws Exception {

        String testURL = "http://localhost:" + port + "/c/create";
        Customer customer = new Customer("Art", "M", "Caldarera");
        List<Address> addressList = new ArrayList<Address>();
        Address address = new Address("6649 N Blue Gum St",
        		"", "New Orleans", "LA", "USA", "70116", "RESIDENCE");
        address.setCustomer(customer);
        addressList.add(address);
       
        customer.setAddresses(addressList);
        
        Customer response = this.restTemplate.postForObject(testURL,
        		customer, Customer.class);
        System.out.println("Response: " + response);
        //assertThat(response.getStatusCode());
        assertThat(response);
    }

}
