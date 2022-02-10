package com.main;

import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Dish;
import com.model.Order;
import com.model.Restaurant;
import com.model.User;
import com.service.*;
public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			Database db = Database.getInstance();
			System.out.println(db.connect());
			
			//Users
			UsersDataHandler uh = new UsersDataHandler();
			
			User user = new User("mediaSupport@gmail.bg","test23","something","area51","Stone river","0887661244");
			
			ArrayList<User>users = uh.getAllUsers();
			
			uh.addUser(user);
			uh.updateFirstName("mediaSupport@gmail.bg", "new_name");
			//uh.deleteUserByEmail("mediaSupport@gmail.bg");
			
			//Restaurants
			Restaurant restaurant = new Restaurant(1,"Scorp A","desc","website!","address");
			RestaurantsDataHandler rsh = new RestaurantsDataHandler();
			
			ArrayList<Restaurant> restaurants = rsh.getAllRestaurants();
			rsh.addRestaurant(restaurant);
			for(int i=0;i<restaurants.size();i++) {
				//System.out.println("Name:" + restaurants.get(i).getName());
				if(restaurants.get(i).getName().equals("Scorp A"))
					rsh.updateName(restaurants.get(i).getId(), "Scorp X");
			}
			
			
			//Orders
			//get user by email for test usually we use url params...
			User userForOrder = uh.getUserByEmail("mediaSupport@gmail.bg");
			Order order = new Order(1,userForOrder.getEmail(),"Pending");
			OrdersDataHandler ordersHandler = new OrdersDataHandler();
			//test order dishes
			int test = 0;
			ArrayList<Order> orders = ordersHandler.getAllOrders();
			ordersHandler.addOrder(order);
			for(int i=0;i<orders.size();i++) {
				//System.out.println("Stat:" + orders.get(i).getStatus());
				 test = ordersHandler.getOrderDishes(orders.get(i).getId()).size();
				
				
			}
			
			System.out.println(test);
			//Dishes
			//hardcoded order and restaurant id usually set with url params etc...
			Dish dish = new Dish(1,"egg","desc","url..",2,2);
			DishesDataHandler dishesHandler = new DishesDataHandler();
			dishesHandler.addDish(dish);
			dishesHandler.DeleteDish(9);
			dishesHandler.UpdateDishName(18, "New_dish_name");
			
			
		
		}
		catch(Exception e) {
			System.out.println("Error...");
		}
		
	}

}
