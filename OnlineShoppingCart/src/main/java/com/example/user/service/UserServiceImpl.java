package com.example.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.user.email.EmailSenderService;
import com.example.user.model.Items;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailSenderService emailService;
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User u = userRepository.save(user);
		emailService.sendEmail(u.getEmail(),"Dear,"+u.getName()+"\n Your Unique Id:"+ u.getId(), "OnlineShoppingCart Unique Id");
		return u;
	}
	@Override
	public String deleteUser(String email) {
		// TODO Auto-generated method stub
		userRepository.deleteByemail(email);
		return email+" Deleted";
	}
	@Override
	public User getUserByEmail(String email) {
		
		// TODO Auto-generated method stub
		return userRepository.findByemail(email);
	}
	@Override
	public void sendItems(User user) {
		emailService.sendItems(user);
		
	}
	
//	public List<Items> getItems(String email){
//		return userRepository.findByemail(email);
//	}
	
}
