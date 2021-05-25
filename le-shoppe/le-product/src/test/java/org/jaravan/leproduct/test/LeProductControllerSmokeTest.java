package org.jaravan.leproduct.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.jaravan.leproduct.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Check if OrderController is actually created when
 * application starts.
 *
 * @author jayant
 *
 */
@SpringBootTest
class LeProductControllerSmokeTest {

    /**
     * Product Controller.
     */
    @Autowired
    private ProductController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
