package org.jaravan.leorder.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeOrderTest {

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

        assertThat(this.restTemplate
                .getForObject(testURL, Iterable.class)).hasSize(0);
    }

}
