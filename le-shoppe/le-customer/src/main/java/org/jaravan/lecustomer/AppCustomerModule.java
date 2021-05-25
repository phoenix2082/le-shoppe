package org.jaravan.lecustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class AppCustomerModule {

    /**
     * Start the Application.
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(AppCustomerModule.class);
    }

}
