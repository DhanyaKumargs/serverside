package com.example.user.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.Items;
import com.example.user.service.ItemServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="*")
public class ItemControll {

	
	@Autowired
	ItemServiceImpl itemsService;
	
	@PostMapping("/items")
	public void createItems(@RequestBody Items items)
	{
		itemsService.createItems(items);
	}
	
	@GetMapping("/getitems/{catagory}")
	public List<Items>getItemsByCatagory(@PathVariable("catagory") String catagory){
		return itemsService.getItemsByCatagory(catagory);
	}
	
	@GetMapping("/getAllItems")
	public List<Items>getAllItems(){
		return itemsService.getAllItems();
	}
	
	@DeleteMapping("/item/delete/{catagory}")
	public String deleteCatagoryByName(@PathVariable("catagory") String catagory) {
		
		return itemsService.deleteCatagoryByName(catagory);
	}
	@DeleteMapping("/item/deleteById/{id}")
	public String deleteCatagoryById(@PathVariable("id") String id) {
		
		return itemsService.deleteCatagoryById(id);
	}
	
	@GetMapping("/itemsCatagoryUpdate/{old}/{ne}")
	public void createItems(@PathVariable("old") String old ,@PathVariable("ne") String ne)
	{
		System.out.println(old+" "+ne);
		itemsService.updateCatagory(old, ne);
	}
	
	@GetMapping("/getitemsByName/{name}")
	public Items getItemsByName(@PathVariable("name") String name){
		return itemsService.getItemsBy(name);
	}
}
