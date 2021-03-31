package com.codefest.noizies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefest.noizies.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository proRepo;
}
