package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String status = request.getParameter("status");
		
		
		ProjectBO sb = new ProjectBO();
		
		sb.setId(id);
		sb.setStatus(status);
		
		int result = projectdao.getupdate(sb);
		
		if(result>0)
		{
			//pw.print("<script> alert('Data has been updated successfully...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("ProjectListController");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("ProjectListController");
			
			rd.include(request, response);
			
			
		}
		

	}

}
