package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Dish;
import com.model.Order;
import com.model.User;



public class OrdersDataHandler {
private Database db = Database.getInstance();
	
	
	private ArrayList<Dish> dishes = new ArrayList<Dish>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	//add order
	public void addOrder(Order order) {
		
		String user_email = order.getUserEmail();
		
		String order_status = order.getStatus();
		
		String statement = "INSERT INTO `orders`(`user_email`,`order_status`)"
				+ " VALUES('"+user_email+"','"+order_status+"')";
		
		db.executeModification(statement);
	}
	
	//delete order
	public void deleteOrderById(int id) {
		String statement = "DELETE FROM `orders` WHERE order_id ='"+id+"'";
		db.executeModification(statement);
	}
	
	//update
	public void updateUserEmail(int id,String newUserEmail) {
		String statement = "UPDATE `orders` SET user_email = '"+newUserEmail+"' WHERE order_id = '"+id+"'";  
		
		db.executeModification(statement);
	}
	
	public void updateStatus(int id,String newStatus) {
		String statement = "UPDATE `orders` SET order_status = '"+newStatus+"' WHERE order_id = '"+id+"'";  
		
		db.executeModification(statement);
	}
	
	//get by id
	public Order getOrderById(int id) {
		Order order = null;
		
		String user_email = "",order_status="";
		int order_id = 0;
		
		String statement = "SELECT * FROM `orders` WHERE order_id = '"+id+"'";
		try {
			ResultSet result = db.createStatement(statement);
			
			while(result.next()) {
				 order_id = result.getInt("order_id");
				 
				 user_email = result.getString("user_email");
				
				 order_status = result.getString("order_status");
				
				
				
				 
				
				
			}
			
			order = new Order(order_id,user_email,order_status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}
	
	public ArrayList<Dish> getOrderDishes(int orderId) throws SQLException{
		String statement = "SELECT * FROM `dishes` WHERE order_id = '"+orderId+"' ";
		
		
		
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
	
	public ArrayList<Order> getAllOrders(){
		String state = "SELECT * FROM `orders`";
		
		Order order = null;
		
		ResultSet result = null;
		try {
			result = db.createStatement(state);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(result.next()) {
				
				int order_id = result.getInt("order_id");
				
				String user_email = result.getString("user_email");
				
				String order_status = result.getString("order_status");
				
				
				
				order = new Order(order_id,user_email,order_status);
				
				orders.add(order);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.orders;
	}
	
}
