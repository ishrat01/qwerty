package com.seed.beans;

//TODO:0	Modification required
abstract public class Product {
	
	private int id;
	private String name;
	private double price;
	
	public Product()
	{
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

//	TODO:1	Provide no-argument public constructor
//	TODO:2	Provide getters and setters for all attributes.
	

}
