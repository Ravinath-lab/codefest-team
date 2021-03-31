package com.codefest.noizies.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="buying_price")
	private double buyingPrice;

	@Column(name="pro_id")
	private int proId;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;

	private double qty;

	@Column(name="selling_price")
	private double sellingPrice;

	@ManyToOne
	@JoinColumn(name="product_category_id")
	private ProductCategory productCategory;

	
	
	public Product() {
		super();
	}

	
	public Product(double buyingPrice, int proId, int productId, double qty, double sellingPrice) {
		super();
		this.buyingPrice = buyingPrice;
		this.proId = proId;
		this.productId = productId;
		this.qty = qty;
		this.sellingPrice = sellingPrice;
	}


	public Product(double buyingPrice, int proId, int productId, double qty, double sellingPrice,
			ProductCategory productCategory) {
		super();
		this.buyingPrice = buyingPrice;
		this.proId = proId;
		this.productId = productId;
		this.qty = qty;
		this.sellingPrice = sellingPrice;
		this.productCategory = productCategory;
	}


	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}