package com.codefest.noizies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codefest.noizies.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

	List<ProductCategory> findProductCategoryByStatus(int status);
	ProductCategory findProductCategoryByProductCategoryId(int id);
}
