package com.example.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.model.Items;
import com.example.user.model.User;

@Service
public interface UserService {

	List<User> getUsers();

	User createUser(User user);

	String deleteUser(String email);

	User getUserByEmail(String email);

	void sendItems(User user);
}
