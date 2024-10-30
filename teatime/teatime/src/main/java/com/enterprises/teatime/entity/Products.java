package com.enterprises.teatime.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double costPrice;
	private double sellPrice;
	private boolean avaliability;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public boolean isAvaliability() {
		return avaliability;
	}
	public void setAvaliability(boolean avaliability) {
		this.avaliability = avaliability;
	}
	public Products(int productId, String productName, double costPrice, double sellPrice, boolean avaliability) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.costPrice = costPrice;
		this.sellPrice = sellPrice;
		this.avaliability = avaliability;
	}
	public Products() {
		super();
	}
	
	

}
