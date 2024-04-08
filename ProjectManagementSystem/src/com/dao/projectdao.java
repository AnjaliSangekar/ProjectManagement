package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BO.ProjectBO;


public class projectdao {

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
	
	
	public static int addProject(ProjectBO ob1)
	{
		int result = 0;
		
		try
		{
			Connection con = projectdao.getConnection();
			
			String sql = "insert into projectdemo(name, reason, type, division, category, priority, department, location, status, startdate, enddate) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ob1.getName());
			ps.setString(2, ob1.getReason());
			ps.setString(3, ob1.getType());
			ps.setString(4, ob1.getDivision());
			ps.setString(5, ob1.getCategory());
			ps.setString(6, ob1.getPriority());
			ps.setString(7, ob1.getDepartment());
			ps.setString(8, ob1.getLocation());
			ps.setString(9, ob1.getStatus());
			ps.setString(10, ob1.getStartdate());
			ps.setString(11, ob1.getEnddate());
			
			result = ps.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	
	public static List getProjectList()
	{
		
		ArrayList<ProjectBO> list = new ArrayList<ProjectBO>();
		
		try 
		{
			Connection con = projectdao.getConnection();
			
			String sql = "select * from projectdemo";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				ProjectBO sb = new ProjectBO();
				
				sb.setId(rs.getInt(1));
				sb.setName(rs.getString(2));
				sb.setReason(rs.getString(3));
				sb.setType(rs.getString(4));
				sb.setDivision(rs.getString(5));
				sb.setCategory(rs.getString(6));
				sb.setPriority(rs.getString(7));
				sb.setDepartment(rs.getString(8));
				sb.setLocation(rs.getString(9));
				sb.setStatus(rs.getString(10));
				sb.setStartdate(rs.getString(11));
				sb.setEnddate(rs.getString(12));
				
				list.add(sb);
				
				
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	
	public static ProjectBO getDataById(int id)
	{
		
		ProjectBO sb = new ProjectBO();
		
		try 
		{
			Connection con = projectdao.getConnection();
			
			String sql = "select status from projectdemo where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				//BOClass sb = new BOClass();
				
								
				sb.setId(rs.getInt(1));
				sb.setStatus(rs.getString(2));
				
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sb;
		
	}
	
	
	public static int getupdate(ProjectBO sb)
	{
		int result = 0;
		
		try 
		{
			Connection con = dao.getConnection();
			
			String sql = "update projectdemo set status=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, sb.getStatus());
			ps.setInt(2, sb.getId());
			
			result = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	
	public static ProjectBO getData(String name)
	{
		
		ProjectBO sb = new ProjectBO();
		
		try 
		{
			Connection con = projectdao.getConnection();
			
			String sql = "select * from projectdemo where name=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				//BOClass sb = new BOClass();
				
								
				//sb.setId(rs.getInt(1));
				sb.setName(rs.getString(1));
				sb.setReason(rs.getString(2));
				sb.setType(rs.getString(3));
				sb.setDivision(rs.getString(4));
				sb.setCategory(rs.getString(5));
				sb.setPriority(rs.getString(6));
				sb.setDepartment(rs.getString(7));
				sb.setLocation(rs.getString(8));
				sb.setStatus(rs.getString(9));
				sb.setStartdate(rs.getString(10));
				sb.setEnddate(rs.getString(11));
				
				
				
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sb;
		
	}
	
	
}
