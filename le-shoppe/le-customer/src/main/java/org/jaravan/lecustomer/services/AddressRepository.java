package org.jaravan.lecustomer.services;

import org.jaravan.lecustomer.entity.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository
    extends PagingAndSortingRepository<Address, Long> {

}
