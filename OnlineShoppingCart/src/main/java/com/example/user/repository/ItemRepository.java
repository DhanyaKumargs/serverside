package com.example.user.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.user.model.Items;
@Repository
public interface ItemRepository extends MongoRepository<Items, String>{

	List<Items> findBycategory(String catagory);

	void deleteBycategory(String catagory);
	
//	@Query("{ 'searchQuery': ?0, 'updateQuery': ?1}")
//	void updateMulti( Document searchQuery,  Document updateQuery);
	
	@Query("{ 'query': ?0, 'update': ?1}")
	void updateMany(Document query, Document update);

	Items findByname(String name);
}
