package com.example.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Items {

	@Id
	String itemsId;
	String name;
	String description;
	double price;
	int qty , stock;
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	String category;

	public String getItemsId() {
		return itemsId;
	}

	public void setItemsId(String itemsId) {
		this.itemsId = itemsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Items(String name, String description, double price, int qty, int stock, String category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
		this.stock = stock;
		this.category = category;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
