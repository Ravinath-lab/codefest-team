package com.codefest.noizies.dao;



import com.codefest.noizies.entity.ProductCategory;

public class ProductDAO {

	private int productId;
	private double buyingPrice;
	private double qty;
	private String name;
	private double sellingPrice;
	private int categoryId;
	
	public ProductDAO() {
		super();
	}

	public ProductDAO(int productId, double buyingPrice, double qty, String name, double sellingPrice, int categoryId) {
		super();
		this.productId = productId;
		this.buyingPrice = buyingPrice;
		this.qty = qty;
		this.name = name;
		this.sellingPrice = sellingPrice;
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
