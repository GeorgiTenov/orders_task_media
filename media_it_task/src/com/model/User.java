package com.model;

import java.util.ArrayList;

import com.service.UsersDataHandler;

public class User implements IDataValidation{
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String telephone;
	
	
	
	private final int EMAIL_MAX_LENGTH = 70;
	private final int PASSWORD_MAX_LENGTH = 10;
	private final int FIRST_NAME_MAX_LENGTH  = 20;
	private final int LAST_NAME_MAX_LENGTH  = 20;
	private final int ADDRESS_MAX_LENGTH  = 60;
	private final int TELEPHONE_MAX_LENGTH  = 20;
	
	
	public User(String email,String password,String firstName,String lastName,String address,String telephone) {
		this.email = email;
		
		this.password = password;
		
		this.firstName = firstName;
		
		this.lastName = lastName;
		
		this.address = address;
		
		this.telephone = telephone;
		
		
		
		
		
	}
	//get set for email
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//get set for password
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//get set for first name
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//get set for last name
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//get full name
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	//get set for address
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//get set for telephone
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public boolean isDataValid() {
		if(this.email.length() <= EMAIL_MAX_LENGTH 
				&& this.password.length() <= PASSWORD_MAX_LENGTH
				&& this.firstName.length() <= FIRST_NAME_MAX_LENGTH
				&& this.lastName.length() <= LAST_NAME_MAX_LENGTH
				&& this.address.length() <= ADDRESS_MAX_LENGTH
				&& this.telephone.length() <= TELEPHONE_MAX_LENGTH) {
			
			return true;
		}
		
		return false;
	}
	
	private boolean isAvailableInDb() {
		UsersDataHandler udh = new UsersDataHandler();
		
		ArrayList<User> users = udh.getAllUsers();
		
		
		if(users.size() > 0) {
			for(int i=0;i<users.size();i++) {
				if(users.get(i).email == this.email)
					return false;
			}
		}
		return true;
	}
}
