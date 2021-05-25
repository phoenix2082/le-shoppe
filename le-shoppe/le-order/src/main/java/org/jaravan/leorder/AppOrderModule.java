package org.jaravan.leorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Order application module.
 */
@SpringBootApplication
public class AppOrderModule {

    /**
     * Start order module as rest service.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(AppOrderModule.class);
    }

}
