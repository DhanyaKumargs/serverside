package com.example.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	void deleteByemail(String email);

	User findByemail(String email);

}
