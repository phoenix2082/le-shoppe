package org.jaravan.leproduct;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository
    extends PagingAndSortingRepository<Product, Long> {
}
