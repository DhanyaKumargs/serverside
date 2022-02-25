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

import com.example.user.model.Catagories;
import com.example.user.model.User;
import com.example.user.service.CatagoryService;

@RestController
@CrossOrigin(origins ="*")
public class CatagoryControll {
	
	@Autowired
	private CatagoryService catagoryService;

	@GetMapping("/api/getcatagories")
	public List<Catagories> getCatagories() {
		return catagoryService.getCatagories();
		
	}
	@PostMapping("/api/catagory")
	public Catagories createStudent(@RequestBody Catagories cat) {
		System.out.println(cat);
		return catagoryService.addCatagory(cat);
	}
	
	@DeleteMapping("/api/catagory/delete/{catagory}")
	public String deleteCatagoryByName(@PathVariable("catagory") String catagory) {
		
		return catagoryService.deleteCatagoryByName(catagory);
	}
	
	@GetMapping("/api/getCatagoryByName/{catagory}")
	public Catagories getCatagoryByName(@PathVariable("catagory") String catagory) {
		return catagoryService.getCatagoryByName(catagory);
		
	}
}
