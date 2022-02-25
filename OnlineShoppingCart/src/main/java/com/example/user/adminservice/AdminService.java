package com.example.user.adminservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.model.Admin;
import com.example.user.model.User;

@Service
public interface AdminService {

	List<Admin> getAdmin();

	Admin createAdmin(Admin admin);

	Admin getAdminByEmail(String email);
}
