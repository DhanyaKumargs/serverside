package com.example.user.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Catagories {
	@Id
	private String catId;
	private String name;
	private String description;
	
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Catagories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Catagories(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Catagories [Id=" + catId + ", name=" + name + ", description=" + description + "]";
	}
	

}
