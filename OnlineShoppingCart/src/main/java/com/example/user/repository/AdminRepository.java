package com.example.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.user.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

	Admin findByemail(String email);

}
