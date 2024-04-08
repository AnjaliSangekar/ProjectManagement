package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.ProjectBO;
import com.dao.dao;
import com.dao.projectdao;

/**
 * Servlet implementation class ProjectController
 */
@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		System.out.println("This is console");
		
		
		String name = request.getParameter("name");
		String reason = request.getParameter("reason");
		String type = request.getParameter("type");
		String division = request.getParameter("division");
		String category = request.getParameter("category");
		String priority = request.getParameter("priority");
		String department = request.getParameter("department");
		String location = request.getParameter("location");		
		String status = request.getParameter("status");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		
		
		ProjectBO ob = new ProjectBO();
		
		ob.setName(name);
		ob.setReason(reason);
		ob.setType(type);
		ob.setDivision(division);
		ob.setCategory(category);
		ob.setPriority(priority);
		ob.setDepartment(department);
		ob.setLocation(location);
		ob.setStatus(status);
		ob.setStartdate(startdate);;
		ob.setEnddate(enddate);
		
		
		int result = projectdao.addProject(ob);
		
		if(result>0)
		{
			pw.print("<script> alert('data added successfully..') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong..try again') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("project.html");
			
			rd.include(request, response);
			
		}
	}

	
}
