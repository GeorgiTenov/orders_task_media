package com.model;

import com.service.DishesDataHandler;

public class Dish implements IDataValidation {
	private int id;
	
	private String name;
	
	private String description;
	
	private String url;
	
	private int restaurant_id;
	
	private int order_id;
	
	private final int NAME_MAX_LENGTH = 20;
	private final int DESCRIPTION_MAX_LENGTH = 60;
	private final int URL_MAX_LENGTH  = 50;
	
	
	//constructor
	public Dish(int id,String name,String description,String url,int restaurant_id,int order_id) {
		this.id = id;
		
		this.name = name;
		
		this.description = description;
		
		this.url = url;
		
		this.restaurant_id = restaurant_id;
		
		this.order_id = order_id;
		
		DishesDataHandler dishesDataHandler = new DishesDataHandler();
		
		
		
		
	}
	//get id
	public int getId() {
		return this.id;
	}
	
	//get set for name
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//get set for description
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	//get set for url
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	//get restaurant id
	public int getRestaurantId() {
		return this.restaurant_id;
	}
	
	//get order id
	public int getOrderId() {
		return this.order_id;
	}
	
	public boolean isDataValid() {
		if(this.name.length() <= NAME_MAX_LENGTH
				&& this.description.length() <= DESCRIPTION_MAX_LENGTH
				&& this.url.length() <= URL_MAX_LENGTH) {
			return true;
		}
		return false;
	}
}
