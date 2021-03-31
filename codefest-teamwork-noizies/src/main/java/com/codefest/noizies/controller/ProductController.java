package com.codefest.noizies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefest.noizies.dao.ProductDAO;
import com.codefest.noizies.entity.Product;
import com.codefest.noizies.service.ProductService;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/getAll")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	@PostMapping(path = "/save")
	public Product save(@RequestBody ProductDAO p){
		return productService.save(p);
	}
	
	@PutMapping(path = "/update")
	public Product update(@RequestBody ProductDAO p){
		return productService.update(p);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable int id){
		productService.delete(id);
	}

}
