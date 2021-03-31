package com.codefest.noizies.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int ACTIVE = 1;
	public static final int DEACTIVE = 2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_category_id")
	private int productCategoryId;

	@Lob
	private String description;

	private String name;
	private int status = ACTIVE;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="productCategory")
	private List<Product> products;

		
	public ProductCategory() {
		super();
	}

	public ProductCategory(int productCategoryId, String description, String name) {
		super();
		this.productCategoryId = productCategoryId;
		this.description = description;
		this.name = name;
	}

	public ProductCategory(int productCategoryId, String description, String name, List<Product> products) {
		super();
		this.productCategoryId = productCategoryId;
		this.description = description;
		this.name = name;
		this.products = products;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}