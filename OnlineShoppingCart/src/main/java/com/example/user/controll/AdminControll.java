package com.example.user.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.adminservice.AdminService;
import com.example.user.model.Admin;
import com.example.user.model.User;

@RestController
@CrossOrigin(origins ="*")
public class AdminControll {
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/api/getadmins")
	public List<Admin> getListOfEmployee() {
		return adminService.getAdmin();
		
	}
	@PostMapping("/api/admin")
	public Admin createStudent(@RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}
	@GetMapping("/api/admin/{email}")
	public Admin getAdminByEmail(@PathVariable("email") String email) {
		return adminService.getAdminByEmail(email);
		
	}
}
