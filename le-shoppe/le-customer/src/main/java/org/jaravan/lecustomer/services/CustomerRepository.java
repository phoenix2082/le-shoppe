package org.jaravan.lecustomer.services;

import org.jaravan.lecustomer.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository
    extends PagingAndSortingRepository<Customer, Long> {

}
