package com.harsh.unitTesting.JunitDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.unitTesting.JunitDemo.business.ItemBusinessService;
import com.harsh.unitTesting.JunitDemo.model.DataEntityExample;
import com.harsh.unitTesting.JunitDemo.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService service;
	
	@GetMapping("/item")
	public Item itemController()
	{
		return new Item(1, "Iphone", 233, 1);
	}
	
	@GetMapping("/businessItem")
	public Item getFromItemBusinessService()
	{
		return service.retrieveItem();
	}
	
	@GetMapping("/allItems")
	public List<DataEntityExample> retrieveFromDataLayer()
	{
		return service.getAllItemsFromDB();
	}
	
}
