package com.seed.beans;

//TODO:0	Modification required
abstract public class Product {
	private int id;
	private String name;
	private double price;
	
//	TODO:1	Provide no-argument public constructor
	
	public Product()
	{
		
	}
//	TODO:2	Provide getters and setters for all attributes.

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
