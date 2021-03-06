package com.codefest.noizies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codefest.noizies.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findProductByProductId(int id);
}
