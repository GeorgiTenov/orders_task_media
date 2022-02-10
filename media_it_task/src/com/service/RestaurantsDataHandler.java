package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Dish;
import com.model.Order;
import com.model.Restaurant;
import com.model.User;

public class RestaurantsDataHandler {
	private ArrayList<Dish> dishes = new ArrayList<Dish>();
	private Database db = Database.getInstance();
	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	
	public void addRestaurant(Restaurant restaurant) {
		String name = restaurant.getName();
		
		String description = restaurant.getDescription();
		
		String url = restaurant.getUrl();
		
		String address = restaurant.getAddress();
		
		String statement = "INSERT INTO `restaurants`(`name`,`description`,`url`,`address`)"
				+ " VALUES('"+name+"','"+description+"','"+url+"','"+address+"')";
		
		db.executeModification(statement);
	}
	
	public void deleteRestaurantById(int id) {
		String statement = "DELETE FROM `restaurants` WHERE restaurant_id ='"+id+"'";
		db.executeModification(statement);
	}
	
	//update
		public void updateName(int id,String newName) {
			String statement = "UPDATE `restaurants` SET name = '"+newName+"' WHERE restaurant_id = '"+id+"'";  
			
			db.executeModification(statement);
		}
		
		public void updateDescription(int id,String newDescription) {
			String statement = "UPDATE `restaurants` SET description = '"+newDescription+"' WHERE restaurant_id = '"+id+"'";  
			
			db.executeModification(statement);
		}
		
		public void updateUrl(int id,String newUrl) {
			String statement = "UPDATE `restaurants` SET url = '"+newUrl+"' WHERE restaurant_id = '"+id+"'";  
			
			db.executeModification(statement);
		}
		
		public void updateAddress(int id,String newAddress) {
			String statement = "UPDATE `restaurants` SET address = '"+newAddress+"' WHERE restaurant_id = '"+id+"'";  
			
			db.executeModification(statement);
		}
	
		//get by id
		public Restaurant getRestaurantById(int id) {
			Restaurant restaurant = null;
			
			String name = "",description ="",url="",address="";
			int restaurant_id = 0;
			
			String statement = "SELECT * FROM `restaurants` WHERE restaurant_id = '"+id+"'";
			try {
				ResultSet result = db.createStatement(statement);
				
				while(result.next()) {
					 restaurant_id = result.getInt("restaurant_id");
					 
					 name = result.getString("name");
					
					 description = result.getString("description");
					
					 url = result.getString("url");
					 
					 address = result.getString("address");
					
					 
					
					
				}
				
				restaurant = new Restaurant(restaurant_id,name,description,url,address);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return restaurant;
		}
		
		public ArrayList<Restaurant> getAllRestaurants(){
			String state = "SELECT * FROM `restaurants`";
			
			Restaurant restaurant = null;
			
			ResultSet result = null;
			try {
				result = db.createStatement(state);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				while(result.next()) {
					
					int restaurant_id = result.getInt("restaurant_id");
					
					String name = result.getString("name");
					
					String description = result.getString("description");
					
					String url = result.getString("url");
					
					String address = result.getString("address");
					
					
					
					restaurant = new Restaurant(restaurant_id,name,description,url,address);
					
					restaurants.add(restaurant);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return this.restaurants;
		}
		
		public ArrayList<Dish> getRestaurantDishes(int restaurantId) throws SQLException{
			String statement = "SELECT * FROM `dishes` WHERE restaurant_id = '"+restaurantId+"' ";
			
			
			
			ResultSet result = db.createStatement(statement);
			
			try {
				while(result.next()) {
					
					int id = result.getInt("dish_id");
					
					String name = result.getString("name");
					
					String description = result.getString("description");
					
					String url = result.getString("url");
					
					int restaurant_id = result.getInt("restaurant_id");
					
					int order_id = result.getInt("order_id");
					
					Dish dish = new Dish(id,name,description,url,restaurant_id,order_id);
					
					dishes.add(dish);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this.dishes;
			
			
			
		}
		
}
