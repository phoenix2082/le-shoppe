package org.jaravan.lecustomer;

import static org.assertj.core.api.Assertions.assertThat;

import org.jaravan.lecustomer.controllers.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Check if CustomerController is actually created when
 * application starts.
 * 
 * @author jayant
 *
 */
@SpringBootTest
class CustomerControllerSmokeTest {

	@Autowired
	private CustomerController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
