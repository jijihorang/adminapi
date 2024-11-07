package org.oz.adminapi.product.repository;

import org.oz.adminapi.product.domain.ProductEntity;
import org.oz.adminapi.product.repository.search.ProductSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, ProductSearch {
}
