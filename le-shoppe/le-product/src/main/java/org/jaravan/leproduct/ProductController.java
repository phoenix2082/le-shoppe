/**
 *
 */
package org.jaravan.leproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Product Request Controller.
 */
@RestController()
@RequestMapping("/p")
public class ProductController {

    /**
     * Product Repository.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Find list of all customers.
     *
     * @return list of customers.
     */
    @GetMapping("/all")
    public @ResponseBody Iterable<Product> customers() {
        return productRepository.findAll();
    }

       /**
     * Create a new Product.
     * @param customer  Product object.
     * @return new customer.
     */
    @PostMapping("/create")
    Product create(@RequestBody final Product customer) {
        Product c = productRepository.save(customer);
        return productRepository.save(customer);
    }

}
