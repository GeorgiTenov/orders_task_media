package com.model;

import com.service.RestaurantsDataHandler;

public class Restaurant implements IDataValidation {
	
	private int restaurant_id;
	
	private String name;
	
	private String description;
	
	private String url;
	
	private String address;
	
	private final int NAME_MAX_LENGTH = 20;
	private final int DESCRIPTION_MAX_LENGTH = 100;
	private final int URL_MAX_LENGTH  = 40;
	private final int ADDRESS_MAX_LENGTH  = 60;
	
	public Restaurant(int restaurant_id,String name,String description,String url,String address) {
		this.restaurant_id = restaurant_id;
		
		this.name = name;
		
		this.description = description;
		
		this.url = url;
		
		this.address = address;
		
		
		
			
	}
	
	public int getId() {
		return this.restaurant_id;
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
	
	//get set for address
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean isDataValid() {
		if(this.name.length() <= NAME_MAX_LENGTH
				&& this.description.length() <= DESCRIPTION_MAX_LENGTH
				&& this.url.length() <= URL_MAX_LENGTH
				&& this.address.length() <= ADDRESS_MAX_LENGTH
				) {
			return true;
		}
			
		return false;
	}

}
