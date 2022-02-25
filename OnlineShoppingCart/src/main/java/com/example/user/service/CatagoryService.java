package com.example.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.model.Catagories;
@Service
public interface CatagoryService {

	List<Catagories> getCatagories();

	Catagories addCatagory(Catagories cat);

	String deleteCatagoryByName(String name);

	Catagories getCatagoryByName(String catagory);
}
