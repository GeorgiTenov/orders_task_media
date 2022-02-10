package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Dish;
import com.model.Order;
import com.model.Restaurant;

public class DishesDataHandler {
	
	private Database db = Database.getInstance();
	
	
	
	private ArrayList<Dish> dishes = new ArrayList<Dish>();
	
	//get all dish
	public ArrayList<Dish> getAllDishes() throws SQLException{
		
		String state = "SELECT * FROM `dishes`";
		ResultSet result = db.createStatement(state);
		
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
		
		return this.dishes;
	}
	
	
	//get dish by id
	public Dish getDishById(int dishId) {
		Dish dish = null;
		
		int id=0,restaurant_id=0,order_id=0;
		
		String name="",description="",url="";
		
		String statement = "SELECT * FROM `dishes` WHERE dish_id = '"+dishId+"'";
		try {
			ResultSet result = db.createStatement(statement);
			
			while(result.next()) {

				 id = result.getInt("dish_id");
				
				 name = result.getString("name");
				
				 description = result.getString("description");
				
				 url = result.getString("url");
				
				 restaurant_id = result.getInt("restaurant_id");
				
				 order_id = result.getInt("order_id");
				
				
			}
			
			dish = new Dish(id,name,description,url,restaurant_id,order_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dish;
	}
	
	public void DeleteDish(int id) {
		String statement = "DELETE FROM `dishes` WHERE dish_id = '"+id+"'";
		db.executeModification(statement);
	}
	
	
	public void UpdateDishName(int id,String newName) {
		String statement = "UPDATE `dishes` SET name = '"+newName+"'WHERE dish_id = '"+id+"'" ;
		
		db.executeModification(statement);
		
	}
	
	public void UpdateDishDescription(int id,String newDescription) {
		String statement = "UPDATE dishes SET description = '"+newDescription+"' WHERE dish_id = '"+id+"'";
		
		db.executeModification(statement);
		
	}
	
	public void UpdateDishUrl(int id,String newUrl) {
		String statement = "UPDATE dishes SET url = '"+newUrl+"' WHERE dish_id = '"+id+"'";
		
		db.executeModification(statement);
		
	}
	
	public void UpdateDishRestaurantId(int id,int newRestaurantId) {
		String statement = "UPDATE dishes SET restaurant_id = '"+newRestaurantId+"' WHERE dish_id = '"+id+"'";
		
		db.executeModification(statement);
		
	}
	
	public void UpdateDishOrderId(int id,int newOrderId) {
		String statement = "UPDATE dishes SET order_id = '"+newOrderId+"' WHERE dish_id = '"+id+"'";
		
		db.executeModification(statement);
		
	}
	
	public void addDish(Dish dish) {
		
		String name = dish.getName();
		
		String description = dish.getDescription();
		
		String url = dish.getUrl();
		
		int restaurant_id = dish.getRestaurantId();
		
		int order_id = dish.getOrderId();
		
		String statement = "INSERT INTO `dishes`(`name`,`description`,`url`,`restaurant_id`,`order_id`)"
				+ " VALUES('"+name+"','"+description+"','"+url+"','"+restaurant_id+"','"+order_id+"')";
		
		db.executeModification(statement);
	}
}
