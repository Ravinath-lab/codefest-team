package com.codefest.noizies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefest.noizies.entity.ProductCategory;
import com.codefest.noizies.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository proCategoryRepo;

	public List<ProductCategory> getAll() {
		return proCategoryRepo.findProductCategoryByStatus(1);
	}

	public ProductCategory save(ProductCategory pc) {
		return proCategoryRepo.save(pc);
	}

	public ProductCategory update(ProductCategory proC) {
		ProductCategory pc = proCategoryRepo.findProductCategoryByProductCategoryId(proC.getProductCategoryId());
		if(pc != null) {
			if(proC.getName() != null && !proC.getName().trim().isEmpty()) {
				pc.setName(proC.getName());
			}
			if(proC.getDescription() != null && !proC.getDescription().trim().isEmpty()) {
				pc.setDescription(proC.getDescription());
			}
			return proCategoryRepo.save(pc);
		}else {
			return null;
		}
	}

	public ProductCategory deactivat(int id) {
		ProductCategory pc = proCategoryRepo.findProductCategoryByProductCategoryId(id);
		if(pc != null) {
			pc.setStatus(ProductCategory.DEACTIVE);
			return proCategoryRepo.save(pc);
		}else {
			return null;
		}
	}
}
