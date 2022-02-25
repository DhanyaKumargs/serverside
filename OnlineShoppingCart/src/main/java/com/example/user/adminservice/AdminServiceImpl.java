package com.example.user.adminservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.user.dto.AdminDto;
import com.example.user.exception.UserException;
import com.example.user.model.Admin;
import com.example.user.model.User;
import com.example.user.repository.AdminRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.insert(admin);
	}

	@Override
	public Admin getAdminByEmail(String email) {
//		try {
//			Assert.notNull(email, "Email is null");
//			log.info("Email: {}", email);
//			Admin admin =  adminRepository.findByemail(email);
//			AdminDto admindto = new AdminDto();
//			BeanUtils.copyProperties(admin, admindto);
//			return admindto;
//		} catch(Exception e) {
//			log.error(e.getMessage());
//			throw new UserException(e.getMessage());
//		}
		return adminRepository.findByemail(email);
	}

}
