package org.jaravan.leorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/o")
public class OrderController {

    /**
     * Order Repository.
     */
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Find list of all orders.
     *
     * @return list of orders.
     */
    @GetMapping("/all")
    public @ResponseBody Iterable<Order> orders() {
        return orderRepository.findAll();
    }

    /**
     * Create a new Order.
     *
     * @param order Order object.
     * @return new order.
     */
    @PostMapping("/create")
    Order create(@RequestBody final Order order) {
        return orderRepository.save(order);
    }
}
