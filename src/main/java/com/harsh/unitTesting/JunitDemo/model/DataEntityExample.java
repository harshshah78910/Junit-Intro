package com.harsh.unitTesting.JunitDemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class DataEntityExample {

	@Id
	private int id;
	private String name;
	
	@Transient
	private int value;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(int value) {
		this.value = value;
	}


	
}
