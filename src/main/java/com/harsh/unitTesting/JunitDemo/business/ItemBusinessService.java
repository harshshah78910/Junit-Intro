package com.harsh.unitTesting.JunitDemo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsh.unitTesting.JunitDemo.model.DataEntityExample;
import com.harsh.unitTesting.JunitDemo.model.Item;
import com.harsh.unitTesting.JunitDemo.repos.DataJPAReps;

@Component
public class ItemBusinessService {

	@Autowired
	private DataJPAReps repo;
	
	public Item retrieveItem()
	{
		return new Item(2, "Iphone", 233, 1);
	}
	
	public List<DataEntityExample> getAllItemsFromDB()
	{
		return repo.findAll();
	}
}
