package com.example.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.user.exception.UserException;
import com.example.user.model.Items;
import com.example.user.repository.ItemRepository;
import com.mongodb.client.result.UpdateResult;
@Service
public class ItemServiceImpl  {

	
	@Autowired
	ItemRepository itemsRepository;
	
	@Autowired
	MongoTemplate mongotemplet;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	public void createItems(Items item) {
		
		itemsRepository.save(item);
		
	}

	public List<Items> getItemsByCatagory(String catagory) {
		// TODO Auto-generated method stub
		
		return itemsRepository.findBycategory(catagory);
	}
	
	public List<Items> getAllItems(){
		return itemsRepository.findAll();
	}

	public String deleteCatagoryByName(String catagory) {
		// TODO Auto-generated method stub
		 itemsRepository.deleteBycategory(catagory);
		 return catagory;
	}

	public String deleteCatagoryById(String id) {
		// TODO Auto-generated method stub
		
		itemsRepository.deleteById(id);
		return id;
	}
	
	public void updateCatagory(String old,String ne) {

		Query query = new Query();
		query.addCriteria(Criteria
				.where("category").is(old));
		Update update = new Update();
		
		//update age to 11
		update.set("category", ne);
		UpdateResult i = mongotemplet.updateMulti(query, update, Items.class);
		System.out.println(i);
	}

	public Items getItemsBy(String name) {
		try {
			Assert.notNull(name, "name is null");
			return itemsRepository.findByname(name);
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new UserException(e.getMessage());
		}
		
	}

		

}
