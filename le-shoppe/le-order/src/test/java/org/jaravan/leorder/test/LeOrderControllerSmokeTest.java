package org.jaravan.leorder.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.jaravan.leorder.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Check if OrderController is actually created
 * on application start.
 */
@SpringBootTest
class LeOrderControllerSmokeTest {

    /**
     * Controller service.
     */
    @Autowired
    private OrderController controller;

    /**
     * Test if order controller is initialised.
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
