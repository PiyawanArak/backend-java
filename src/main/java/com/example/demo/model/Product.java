package com.example.demo.model;

public class Product {
	private Integer productID;
	private String productName;
	private Double productPrice;
	private Integer productAmount;
	private String productDetail;
	
	public Product() {
		super();
	}
	
	public Product(Integer productID, String productName, Double productPrice, Integer productAmount,
			String productDetail) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAmount = productAmount;
		this.productDetail = productDetail;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
	
}
