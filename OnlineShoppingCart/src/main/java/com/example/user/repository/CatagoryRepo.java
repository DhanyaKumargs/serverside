package com.example.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.user.model.Catagories;

public interface CatagoryRepo extends MongoRepository<Catagories, String> {

	void deleteByname(String name);

	Catagories findByname(String catagory);

	
}
