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

import com.codefest.noizies.entity.ProductCategory;
import com.codefest.noizies.service.ProductCategoryService;

@RestController
@RequestMapping(path = "/productCategory")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService proCategoryService;
	
	@GetMapping(path = "/getAll")
	public List<ProductCategory> getAll(){
		return proCategoryService.getAll();
	}
	
	@GetMapping(path = "/get/{id}")
	public ProductCategory getCat(@PathVariable int id){
		return proCategoryService.getCat(id);
	}
		
	@PostMapping(path = "/save")
	public ProductCategory save(@RequestBody ProductCategory pc){
		return proCategoryService.save(pc);
	}
		
	@PutMapping(path = "/update")
	public ProductCategory update(@RequestBody ProductCategory pc){
		return proCategoryService.update(pc);
	}
	
	@PutMapping(path = "/deactivate/{id}")
	public ProductCategory deactivate(@PathVariable int id){
		return proCategoryService.deactivat(id);
	}

}
