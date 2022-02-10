package com.service;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Database {
	
	private static Database instance = new Database();
	
	private Connection con;
	
	private Database() {};
	
	public static Database getInstance()  {
		try {
			instance.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instance;
	}
	
	
	
	public boolean connect() throws SQLException{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/media_task","root","pass");

		if(con != null) return true;
		
		return false;
		
		
	}
	
	public Connection getConnection() {
		return this.con;
	}
	
	public ResultSet createStatement(String statement) throws SQLException {
		
		
		
		Statement state = con.createStatement();
		
		ResultSet result = state.executeQuery(statement);
		
		return result;
		
		
	}
	
	public int executeModification(String statement) {
		Statement nonSelectable;
		
		int result = 0;
		try {
			nonSelectable = con.createStatement();
			result = nonSelectable.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	

}
