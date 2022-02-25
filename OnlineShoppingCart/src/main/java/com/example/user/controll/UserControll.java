package com.example.user.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.Items;
import com.example.user.model.User;
import com.example.user.service.UserService;

@RestController
@CrossOrigin(origins ="*")
public class UserControll {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/api/getUsers")
	public List<User> getListOfEmployee() {
		return userService.getUsers();
		
	}

	@PostMapping("/api")
	public User createStudent(@RequestBody User user) {
		System.out.println(user);
		return userService.createUser(user);
	}
	
	@DeleteMapping("/api/user/delete/{email}")
	public String deleteByemail(@PathVariable("email") String email) {
		System.out.println(email);
		return userService.deleteUser(email);
	}
	@GetMapping("/api/user/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		System.out.println(email);
		return userService.getUserByEmail(email);
	}
	
	@PostMapping("/api/sendItems")
	public void sendItems(@RequestBody  User items) {
		userService.sendItems(items);
		}
	
	
}