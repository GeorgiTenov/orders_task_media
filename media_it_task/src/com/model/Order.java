package com.model;

import com.service.OrdersDataHandler;

public class Order implements IDataValidation{
	private int id;
	
	private String user_email;
	
	
	private String status;
	
	private final int USER_EMAIL_MAX_LENGTH = 70;
	private final int ORDER_STATUS_MAX_LENGTH = 10;
	
	
	public Order(int id,String user_email,String status) {
		this.id = id;
		
		this.user_email = user_email;
		
		this.status = status;
		
		
		
	}
	//get id
	public int getId() {
		return this.id;
	}
	
	//get set for user
	public String getUserEmail() {
		return this.user_email;
	}
	
	public void setUser(String userEmail) {
		this.user_email = userEmail;
	}
	
	
	
	//get set status
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isDataValid() {
		
		if(this.user_email.length() <= USER_EMAIL_MAX_LENGTH
				&& this.status.length() <= ORDER_STATUS_MAX_LENGTH) {
			return true;
		}
			
		return false;
		
	}
}
