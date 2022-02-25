package com.example.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.user.exception.UserException;
import com.example.user.model.Catagories;
import com.example.user.repository.CatagoryRepo;
@Service
public class CatagoryServiceImpl implements CatagoryService{

	@Autowired
	private CatagoryRepo catagoryRepository;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Catagories> getCatagories() {
		// TODO Auto-generated method stub
		
		return catagoryRepository.findAll();
	}
	@Override
	public Catagories addCatagory(Catagories cat) {
		// TODO Auto-generated method stub
		try {
			Assert.notNull(cat, "Catagories is null");
			return catagoryRepository.save(cat);
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new UserException(e.getMessage());
		}
		
	}
	@Override
	public String deleteCatagoryByName(String name) {
		// TODO Auto-generated method stub
		try {
			Assert.notNull(name, "name is null");
			catagoryRepository.deleteByname(name);
			return name;
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new UserException(e.getMessage());
		}
//		catagoryRepository.deleteByname(name);
//		return name;
		
	}
	@Override
	public Catagories getCatagoryByName(String catagory) {
		// TODO Auto-generated method stub
		return catagoryRepository.findByname(catagory);
	}

	
}
