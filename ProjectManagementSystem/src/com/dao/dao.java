package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dao {

	
	public static Connection getConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectlist","root","Codenera@123"); 
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return con;
		
	}
	
	
	public static boolean loginvalid(String email, String password)
	{
		boolean status = false;
		
		try
		{
			
			Connection con = dao.getConnection();
			
			String sql = "select * from login where email=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}

	
	
}
