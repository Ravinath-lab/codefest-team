package com.codefest.noizies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefest.noizies.dao.ProductDAO;
import com.codefest.noizies.entity.Product;
import com.codefest.noizies.entity.ProductCategory;
import com.codefest.noizies.repository.ProductCategoryRepository;
import com.codefest.noizies.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository proRepo;
	@Autowired 
	private ProductCategoryRepository proCatRepo;

	public List<Product> getAll() {
		return proRepo.findAll();
	}

	public Product save(ProductDAO p) {
		Product pro = getProduct(p);
		return proRepo.save(pro);
	}

	public Product update(ProductDAO p) {
		Product pro = proRepo.findProductByProductId(p.getProductId());
		if(pro != null) {
			if(p.getBuyingPrice() > 0) {
				pro.setBuyingPrice(p.getBuyingPrice());
			}
			if(p.getSellingPrice() >= p.getBuyingPrice()) {
				pro.setSellingPrice(p.getSellingPrice());
			}
			if(p.getName() != null && !p.getName().trim().isEmpty()) {
				pro.setName(p.getName());
			}
			if(p.getQty() > 0) {
				pro.setQty(p.getQty());
			}
			Product pp = getProduct(p);
			pro.setProductCategory(pp.getProductCategory());
			return proRepo.save(pro);
		}else {
			return null;
		}	
	}

	public void delete(int id) {
		proRepo.deleteById(id);
	}
	
	private Product getProduct(ProductDAO model) {
		Product p = new Product();
		p.setName(model.getName());
		p.setBuyingPrice(model.getBuyingPrice());
		p.setSellingPrice(model.getSellingPrice());
		p.setQty(model.getQty());
		
		ProductCategory pc = proCatRepo.findProductCategoryByProductCategoryId(model.getCategoryId());
		if(pc != null) {
			p.setProductCategory(pc);
		}else {
			System.out.println("category null");
		}
		return p;
	}

	public Product getProductById(int id) {
		Product pro = proRepo.findProductByProductId(id);
		return pro;
	}
}
