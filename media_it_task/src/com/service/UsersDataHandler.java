package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Dish;
import com.model.Order;
import com.model.User;

public class UsersDataHandler {
	
	private Database db = Database.getInstance();
	
	private ArrayList<User> users = new ArrayList<User>();
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	//add user
	public void addUser(User user) {
		
		String email = user.getEmail();
		
		String password = user.getPassword();
		
		String firstName = user.getFirstName();
		
		String lastName = user.getLastName();
		
		String address = user.getAddress();
		
		String telephone = user.getTelephone();
		
		String statement = "INSERT INTO `users` VALUES('"+email+"','"+password+"','"+firstName+"','"+lastName+"','"+address+"','"+telephone+"')";
				
		if(canUserBeAdded(email)) {
			
			db.executeModification(statement);
		}
			
		
		else {
			System.out.println("Sry its an error!");
		}
			
	}
	
	//update user
	public void updateUserEmail(String oldEmail,String newEmail) {
		String statement = "UPDATE `users` SET email = '"+newEmail+"' WHERE email = '"+oldEmail+"'";  
		
		db.executeModification(statement);
	}
	
	public void updatePassword(String userEmail,String newPassword) {
		String statement = "UPDATE `users` SET password = '"+newPassword+"' WHERE email = '"+userEmail+"'";  
		
		db.executeModification(statement);
	}
	
	public void updateFirstName(String userEmail,String newFirstName) {
		String statement = "UPDATE `users` SET first_name = '"+newFirstName+"' WHERE email = '"+userEmail+"'";  
		
		db.executeModification(statement);
	}
	
	public void updateLastName(String userEmail,String newLastName) {
		String statement = "UPDATE `users` SET last_name = '"+newLastName+"' WHERE email = '"+userEmail+"'";  
		
		db.executeModification(statement);
	}
	
	public void updateAddress(String userEmail,String newAddress) {
		String statement = "UPDATE `users` SET address = '"+newAddress+"' WHERE email = '"+userEmail+"'";  
		
		db.executeModification(statement);
	}
	
	public void updateTelephone(String userEmail,String newTelephone) {
		String statement = "UPDATE `users` SET telephone = '"+newTelephone+"' WHERE email = '"+userEmail+"'";  
		
		db.executeModification(statement);
	}
	
	public void deleteUserByEmail(String email) {
		String statement = "DELETE FROM `users` WHERE email ='"+email+"'";
		db.executeModification(statement);
	}
	
	public ArrayList<User> getAllUsers(){
		String state = "SELECT * FROM `users`";
		
		User user = null;
		
		ResultSet result = null;
		try {
			result = db.createStatement(state);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(result.next()) {
				
				String email = result.getString("email");
				
				String password = result.getString("password");
				
				String firstName = result.getString("first_name");
				
				String lastName = result.getString("last_name");
				
				String address = result.getString("address");
				
				String telephone = result.getString("telephone");
				
				user = new User(email,password,firstName,lastName,address,telephone);
				
				users.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.users;
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		
		String user_email = "",password = "",firstName="",lastName="",address="",telephone="";
		
		String statement = "SELECT * FROM `users` WHERE email = '"+email+"'";
		try {
			ResultSet result = db.createStatement(statement);
			
			while(result.next()) {

				 user_email = result.getString("email");
				
				 password = result.getString("password");
				
				 firstName = result.getString("first_name");
				
				 lastName = result.getString("last_name");
				
				 address = result.getString("address");
				
				 telephone = result.getString("telephone");
				
				
			}
			
			user = new User(user_email,password,firstName,lastName,address,telephone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public ArrayList<Order> getOrdersByEmail(String email) throws SQLException {
		String statement = "SELECT * FROM `orders` WHERE user_email = '"+email+"' ";
		
		
		
		ResultSet result = db.createStatement(statement);
		
		try {
			while(result.next()) {
				
				int order_id = result.getInt("order_id");
				
				String user_email = result.getString("user_email");
				
				String order_status = result.getString("order_status");
				
				Order order = new Order(order_id,user_email,order_status);
				
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.orders;
	}
	
	private boolean canUserBeAdded(String email) {
		for(int i=0;i<this.users.size();i++) {
			if(users.get(i).getEmail().equals(email)) {
				
				return false;
			}
				
		}
		
		return true;
	}
}
